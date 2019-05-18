package no.frode.div;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringGame {


    String[] stringsAsArray = {"1", "2", "6", "8", "3"};
    List<String> stringsAsList = Arrays.asList("1", "2", "6", "3");
    List<String> myList =
            Arrays.asList("a1", "a2", "b1", "c2", "c1", "a99");


    protected String getLowestNumber() {

        Stream<String> stream1 = Stream.of(this.stringsAsArray);
        Stream<String> stream2 = stringsAsList.stream();

        String minVal = stream1.min(Comparator.comparing(String::valueOf)).get();

        String minVal2 = stream2.min(Comparator.comparing(String::valueOf)).get();

        return minVal;
    }

    protected String getStartsWitha() {

        List<String> sortedAndFilteredList = new ArrayList<>();

        myList
                .stream()
                .filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);


        sortedAndFilteredList = myList
                .stream()
                .filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        StringBuffer buffer = new StringBuffer();
        for (String s : sortedAndFilteredList) {
            buffer.append(s);
            buffer.append(",");
        }

        return new String(buffer.toString());

    }

    public String getLowestNumberByArray(String[] stringsAsArray) {

        Stream<String> stream1 = Stream.of(stringsAsArray);

        String minVal = stream1.min(Comparator.comparing(String::valueOf)).get();

        return minVal;
    }

    public String getHighestNumberByArray(String[] stringsAsArray) {

        Stream<String> stream1 = Stream.of(stringsAsArray);

        String maxVal = stream1.max(Comparator.comparing(String::valueOf)).get();

        return maxVal;
    }
}
