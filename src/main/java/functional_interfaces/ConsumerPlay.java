package functional_interfaces;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjLongConsumer;

@Slf4j
public class ConsumerPlay {

//Accepts a single argument and returns no result

    public static void main(String[] args) {

        //Accept method is generally used for a consumer
        consumeMe.accept("Accept Me Pls!");
        log.info("\n");

        //First executes consumeMe, then it executes consumeAgain
        consumeMe.andThen(consumeMeAgain).accept("Accept me again pls!");
        log.info("\n");

        //A BiConsumer can be used to evaluate two expressions and return nothing.
        hideMe.accept("Iam", true);
        log.info("\n");

        //The Same BiConsumer hides the data based on condition.
        hideMe.accept("Iam not", false);
        log.info("\n");

        objLongConsumer.accept("Rera", 33);
        log.info("\n");

        //Like a callback function in JavaScript, we can do it using a consumer.
        checkLastName("Rahul",
                null,
                v -> log.info("Last Name is missing for {}", v));
    }

    static Consumer<String> consumeMe = c -> consumeCheck();

    static Consumer<String> consumeMeAgain = c -> log.info("{}-> Consumed again from Consumer FI", c);

    static BiConsumer<String, Boolean> hideMe = (c, y) -> log.info(Boolean.TRUE.equals(y) ? c : "***");

    static ObjLongConsumer<String> objLongConsumer = (c, e) -> log.info("Calling {}", c + e);

    static void checkLastName(String firstName, String lastName, Consumer<String> callback){
        log.info("First Name is {}", firstName);
        if(null != lastName){
            log.info("Last Name is {}", lastName);
        } else {
            callback.accept(firstName);
        }
    }

    private static void consumeCheck(){

        log.info("Outside the runnable interface");
        new Runnable() {
            @Override
            public void run() {
                log.info("From the runnable interface, Anyways I wont get logged in your console ;)");
            }
        };
    }
}
