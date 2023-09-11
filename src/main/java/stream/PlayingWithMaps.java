package stream;

import lombok.extern.slf4j.Slf4j;
import modal.Product;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class PlayingWithMaps {

    /**
     * Task 1 =>
     *
     * Given a List of Strings, You have to pick up the ones which are
     * starting with letter 'b', make it upper case, Sort it and print the
     * result strings as a Map of <Integer, List<Strings>>
     *
     * The output should be
     *  1. {7=[BECKY11, BECKY99], 9=[BEEPBEEP1], 11=[BEETHOVEN11]}
     *  2. {4, [BECKY11, BECKY99, BEEPBEEP1, BEETHOVEN11]}
     *
     *  Task 2 =>
     *
     *  FlatMap is used for both transformation of streams and flattering, Given a list of products.
     *  Your goal is to Flatten the Map and print only the RAM configurations
     *
     *  The output should be
     *  1. Combine the speculations as a single stream
     *  2.
     */

    public static void main(String[] args) {

        playingWithBasicStreams(Product.listOfProducts());
        log.info("\n");

        log.info("Capitalized Sorted Strings = {}",
                capitalizeLetter(List.of("becky99", "becky11", "beethoven11", "beepBeep1", "BangaloreDays43"))
        );
        log.info("\n");

        log.info("Grouped and Capitalized Sorted Strings = {}",
                capitalizedGroupedLetters(List.of("becky99", "becky11", "beethoven11", "beepBeep1", "BangaloreDays43"))
        );
        log.info("\n");

        playingWithFlatMap(Product.listOfProducts());

    }

    protected static Map<Integer, List<String>> capitalizeLetter(List<String> input){

        Map<Integer, List<String>> result = input.stream()
                .filter(e -> e.startsWith("b"))
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.groupingBy(String::length, Collectors.toList()));

        log.info("Map has the keys as :{}, with values:{}", result.keySet(), result.values());
        return result;
    }

    protected static Map<Integer, List<String>> capitalizedGroupedLetters(List<String> input){

        Map<Integer, List<String>> result = Collections.singletonMap(
                (int) getStreams(input).count(),
                getStreams(input).toList());

        log.info("Map has the keys as :{}, with values:{}", result.keySet(), result.values());
        return result;
    }

    private static Stream<String> getStreams(List<String> stringStream){
        return stringStream
                .stream()
                .filter(l -> l.startsWith("b"))
                .sorted()
                .map(String::toUpperCase);
    }



    private static void playingWithFlatMap(List<Product> listOfProducts) {

        //Map -> To transform a Stream<T> to Stream<R>
        List<String> mobileNames = listOfProducts.stream()
                .map(Product::getName)
                .toList();

        log.info("List of mobile names: {}", mobileNames);

        List<List<String>> mobileSpecs = listOfProducts.stream()
                .map(Product::getSpecs)
                .toList();

        log.info("List of List of Mobile Speculations: {}", mobileSpecs);

        //FlatMap -> Flattering the speculations
        List<String> mobileSpecsFlattered = listOfProducts.stream()
                .flatMap(product -> product.getSpecs().stream())
                .toList();

        log.info("After flattering the Mobile Speculation: {}", mobileSpecsFlattered);
    }

    private static void playingWithBasicStreams(List<Product> productList){

        int count = productList.stream()
                .mapToInt(e -> 1)
                .sum();

        log.info("Count the number of Products: {}", count);

        List<String> mobileNames = productList.stream()
                .map(Product::getName)
                .sorted()
                .toList();

        log.info("Sorting the mobile Names: {}", mobileNames);

        boolean anyMatchCheck =  productList.stream()
                .anyMatch(p -> p.getName().contains("Apple"));
        boolean allMatchCheck =  productList.stream()
                .allMatch(p -> p.getName().length() > 2);
        boolean noneMatchCheck =  productList.stream()
                .noneMatch(p -> p.getName().contains("z"));

        log.info("Does the product name contain Apple at all : {} \r\n Does all products have letter 'a' in it? : {} \r\n None of the products have the letter 'z' in it? : {}",
                anyMatchCheck, allMatchCheck, noneMatchCheck);

        List<String> limitedProduct = productList.stream()
                .limit(2)
                .map(Product::getName)
                .toList();

        log.info("Limited Products to 2 :{}", limitedProduct);

    }

}
