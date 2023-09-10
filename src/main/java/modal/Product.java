package modal;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int id;
    private String name;
    private int price;
    private PriceRange range;
    private List<String> specs;

    public static PriceRange setPriceRange(int price){
        if(price <= 25000){
            return PriceRange.LOW;
        }
        if(price > 25000 && price <= 50000){
            return PriceRange.MODERATE;
        }
        if(price > 50000){
            return PriceRange.EXPENSIVE;
        }
        return PriceRange.UNDEFINED;
    }

    public static List<Product> listOfProducts() {
        return Arrays.asList(
                new Product(1, "Nokia G21", 23200, Product.setPriceRange(23200),
                        Arrays.asList("4GB Ram", "OctaCore Processor", "256GB Memory", "18MP/8MP")),
                new Product(2, "Samsung Galaxy S23", 45400, Product.setPriceRange(45400),
                        Arrays.asList("8GB Ram", "OctaCore Processor", "512GB Memory", "50MP/12MP")),
                new Product(3, "Apple iPhone15", 84525, Product.setPriceRange(84525),
                        Arrays.asList("8GB Ram", "A16 Bionic", "512GB Memory", "48MP/12MP")),
                new Product(4, "MicroMax In Note2", 42000, Product.setPriceRange(42000),
                        Arrays.asList("4GB Ram", "MediaTek Helio G95", "64GB Memory", "53MP/18MP"))
        );
    }
}
