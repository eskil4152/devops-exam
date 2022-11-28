package no.kristiania.devopsexam;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Cart {
    private String id;
    List<Item> items = new ArrayList<>();

    public long getValue(){

        long value = 0;

        for (Item item:
             items) {
            float temp = (item.getQty() * item.getUnitPrice());
            value += temp;
        }

        return value;
    }
}

@Data
class Item {

    private String description;
    private int qty;
    private Float unitPrice;

}