package functional_interfaces;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class SupplierPlay {

    public static void main(String[] args) {

        log.info("Playing with Supplier:{}", supplyMeAnIntegerPls.get());
        log.info("\n");

        log.info("Playing with Supplier's Supplier :{}", supplyInsideASupplier.get().get());
    }

    static Supplier<String> supplyMeAnIntegerPls = SupplierPlay::getSomeFood;

    static Supplier<Supplier<Integer>> supplyInsideASupplier =  SupplierPlay::getSomeInteger;

    static String getSomeFood(){
        return "No Work, No Food";
    }

    static Supplier<Integer> getSomeInteger(){
        return () -> Integer.MAX_VALUE;
    }
}
