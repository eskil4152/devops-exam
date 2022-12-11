package no.kristiania.devopsexam;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShoppingCartController implements ApplicationListener<ApplicationReadyEvent> {

    private final Map<String, Cart> cartMap = new HashMap();
    private final CartService cartService;
    private final MeterRegistry meterRegistry;
    private final Counter checkoutsCounter;

    @Autowired
    public ShoppingCartController(CartService cartService, MeterRegistry meterRegistry) {
        this.cartService = cartService;
        this.meterRegistry = meterRegistry;

        checkoutsCounter = meterRegistry.counter("checkoutsCounter");

    }

    @GetMapping(path = "/cart/{id}")
    public Cart getCart(@PathVariable String id) {
        return cartService.getCart(id);
    }

    /**
     * Checks out a shopping cart. Removes the cart, and returns an order ID
     *
     * @return an order ID
     */
    @PostMapping(path = "/cart/checkout")
    @Timed(value = "timed-tester")
    public String checkout(@RequestBody Cart cart) {
        meterRegistry.timer("test-timer-measure").record(() -> {
            cartMap.remove(cart.getId());

            checkoutsCounter.increment();
        });

        return cartService.checkout(cart);
    }

    /**
     * Updates a shopping cart, replacing it's contents if it already exists. If no cart exists (id is null)
     * a new cart is created.
     *
     * @return the updated cart
     */
    @PostMapping(path = "/cart")
    public Cart updateCart(@RequestBody Cart cart) {
        cartMap.put(cart.getId(), cart);

        return cartService.update(cart);
    }

    /**
     * return all cart IDs
     *
     * @return
     */
    @GetMapping(path = "/carts")
    public List<String> getAllCarts() {
        return cartService.getAllCarts();
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Gauge.builder("carts", cartMap,
                c -> c.values().size()).register(meterRegistry);

        Gauge.builder("carts_value", cartMap,
                c -> c.values().stream()
                        .flatMap(d -> d.getItems().stream()
                                .map(i -> i.getUnitPrice() * i.getQty()))
                        .reduce(0f, Float::sum)).register(meterRegistry);
    }
}