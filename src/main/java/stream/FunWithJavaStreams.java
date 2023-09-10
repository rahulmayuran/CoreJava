package stream;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
public class FunWithJavaStreams {

    public static void main(String[] args) {
        log.info("Print the longest string: {}",
                printTheLongestString(Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon"))
        );
    }

    /**
     * Use the reduce operation in Streams
     * to print the longest string and its value
     *
     * @param stringList
     * @return
     */
    protected static String printTheLongestString(List<String> stringList){
        Optional<String> reduced = stringList.stream()
                .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
        reduced.ifPresent(s -> log.info("The length of the longest string is :{}", s.length()));
        return reduced.orElse("No string found");
    }

}
