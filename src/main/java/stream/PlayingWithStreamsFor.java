package stream;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class PlayingWithStreamsFor {

    /**
     * Task =>
     *
     * Given a List of Strings, You have to pick up the ones which are
     * starting with letter 'b', make it upper case, Sort it and print the
     * result strings as a Map of <Integer, List<Strings>>
     *
     * The output should be
     *  1. {7=[BECKY11, BECKY99], 9=[BEEPBEEP1], 11=[BEETHOVEN11]}
     *  2. {4, [BECKY11, BECKY99, BEEPBEEP1, BEETHOVEN11]}
     */

    public static void main(String[] args) {
        log.info("Capitalized Sorted Strings = {}",
                capitalizeLetter(Arrays.asList("becky99", "becky11", "beethoven11", "beepBeep1", "BangaloreDays43"))
        );

        log.info("Grouped and Capitalized Sorted Strings = {}",
                capitalizedGroupedLetters(Arrays.asList("becky99", "becky11", "beethoven11", "beepBeep1", "BangaloreDays43"))
        );
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
                (int) getStreams(input).count(), getStreams(input).collect(Collectors.toList())
        );
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

}
