package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        Predicate<Integer> pred = n ->  n%2==1;


        Function<Integer, Integer> mapPred = n -> n*2;


        List<Integer> ls = nums.stream()
                .filter(pred)
                .map(mapPred)
                //.reduce(10, (a,b) -> a+b);
                        .collect(Collectors.toList());

        System.out.println(ls);
        System.out.println(nums);

        nums.forEach(System.out::println);

    }
}
