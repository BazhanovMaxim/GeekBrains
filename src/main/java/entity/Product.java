package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private final Integer id;
    private final String title;
    private final Integer price;

    public Product(Integer id, String title, Integer price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
}