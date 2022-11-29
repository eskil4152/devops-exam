package no.kristiania.devopsexam;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CartService {

    Cart getCart(String id);

    Cart update(Cart cart);

    String checkout(Cart cart);

    List<String> getAllCarts();

    float total();
}