package com.corejava.Stream;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
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


        log.info("ProductList contains => "+listOfProducts());

        Collections.sort(listOfProducts(), Comparator.comparing(Product::getName));

        for(Product p : listOfProducts()){
            log.info("Sorted By Name => "+p);
        }

        log.info("Products with price >45k is ");
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
