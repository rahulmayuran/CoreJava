package functional_interfaces;

import error.CustomException;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@Slf4j
public class OptionalPlay {

    public static void main(String[] args) {

        try {
            playWithOptional("rodeo@gmail.com");
            log.info("\n");

            playWithOptional(null);
            log.info("\n");

            playWithOptionalAndThrow("987328463");
            log.info("\n");

            playWithOptionalAndThrow("_987328463");
            log.info("\n");

        } catch (CustomException e) {
            log.error("Exception caught From Main thread :{}", e.getMessage());
        }
    }

    static void playWithOptional(String email){
        Optional.ofNullable(email)
                .ifPresentOrElse(
                        e -> log.info("Sent an email to :{}", e),
                        () -> log.error("Unable to send email as it is invalid")
                );
    }

    static void playWithOptionalAndThrow(String phoneNumber) throws CustomException {

        if(isValid.and(startsWithNine).test(phoneNumber)){
            Optional.ofNullable(phoneNumber)
                    .ifPresentOrElse(
                            e -> log.info("Provided Phone no:{} is valid", e),
                            () -> log.error("Will never give a chance to reach this logger")
                    );
        } else {
            log.error("Throwing Custom Exception");
            throw new CustomException("Phone Number is invalid");
        }
    }

    static Predicate<String> isValid = e -> e.length() == 10;
    static Predicate<String> startsWithNine = e -> e.startsWith("9");


}
