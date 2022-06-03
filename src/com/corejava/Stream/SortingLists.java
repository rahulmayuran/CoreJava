package com.corejava.Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static com.BaseLogger.Logger.commmonLogger;

public class SortingLists
{

    private List<Product> listOfProducts() {

        Product productA = new Product(1, "Nokia", 23241);
        Product productB = new Product(2, "Samsung", 43542);
        Product productC = new Product(3, "Apple", 84525);
        Product productD = new Product(4, "MicroMax", 43544);

        List<Product> productList = new ArrayList<>();
        productList.add(productA);
        productList.add(productB);
        productList.add(productC);
        productList.add(productD);

        return productList;

    }

    public void sortedList(){


        commmonLogger.info("ProductList contains => "+listOfProducts());

        Collections.sort(listOfProducts(), Comparator.comparing(Product::getName));

        for(Product p : listOfProducts()){
            commmonLogger.info("Sorted By Name => "+p);
        }

        commmonLogger.info("Products with price >45k is ");
        Stream<Product> filteredProducts =
                listOfProducts()
                        .stream()
                        .filter(p->p.getPrice() >45000);

        filteredProducts.forEach(System.out::println);

    }

    public static void main(String[] args)
    {
        SortingLists s = new SortingLists();
        s.sortedList();
    }
}
