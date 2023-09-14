package functional_interfaces;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@Slf4j
public class PredicatePlay {
    static Set<String> emptySet = new TreeSet<>();

    public static void main(String[] args) {

        log.info("Set before predicate Test:{}", emptySet);

        log.info("Predicate FI with test() method: {}",
                predication.test("I am"));
        log.info("\n");

        log.info("Predicate FI with test() method * 2: {}",
                predication.test("IAm"));
        log.info("\n");

        log.info("Predicate FI with and() and test() method * 2: {}",
                predication.and(predicationAdder).test("Iam Everywhere"));
        log.info("\n");

        log.info("Set After predicate Test:{}", emptySet);
        log.info("\n");

        log.info("Predicate FI with or() and test() method * 2: {}",
                predication.or(predicationRemover).test("I will remove the set items"));
        log.info("\n");

        log.info("Set After predicate Or Check :{}", emptySet);
        log.info("\n");

        log.info("Predicate FI with test() method for a biPredicate:{}",
                biPredicateAdderAndRemover.test("", 4));
        log.info("\n");

        log.info("Set After Bi-predicate check:{}", emptySet);
    }

    static Predicate<String> predication = e -> e.startsWith("I") && e.contains("am");

    static Predicate<String> predicationAdder = e -> emptySet.add(e);

    static Predicate<String> predicationRemover = e -> emptySet.removeIf(f -> !f.isBlank());

    static BiPredicate<String, Integer> biPredicateAdderAndRemover = (e, y) -> e.isBlank() ?
            emptySet.add(y.toString()) : emptySet.add(e);

}
