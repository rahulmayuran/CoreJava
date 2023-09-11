package functional_interfaces;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjLongConsumer;

@Slf4j
public class ConsumerPlay {

//Accepts a single argument and returns no result

    public static void main(String[] args) {

        consumeMe.accept("Accept Me Pls!");
        consumeMe.andThen(consumeMeAgain).accept("Accept me again pls!");
        log.info("\n");

        hideMe.accept("Iam", true);
        hideMe.accept("Iam not", false);
        log.info("\n");

        objLongConsumer.accept("Rera", 33);

    }

    static Consumer<String> consumeMe = c -> log.info("{}-> Consumed from Consumer FI", c);

    static Consumer<String> consumeMeAgain = c -> log.info("{}-> Consumed again from Consumer FI", c);

    static BiConsumer<String, Boolean> hideMe = (c, y) -> log.info(Boolean.TRUE.equals(y) ? c : "***");

    static ObjLongConsumer<String> objLongConsumer = (c, e) -> log.info("Calling {}", c + e);

}
