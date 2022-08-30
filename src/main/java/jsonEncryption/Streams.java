package jsonEncryption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {

    public void streams(List<Statue> statues) {

        //Stream.of();
        Stream.of("x", "test", "ahoj");

        statues.forEach(System.out::println);

        List<String> names = new ArrayList<>();
        statues.forEach(statue -> {
            names.add(statue.getName());
        });

        Stream<String> namesStream = names.stream();
        System.out.println("Stream mien: " + namesStream.toList());

        Supplier<LongStream> selectedStatuesHeights = () -> statues.stream()
                .map(Statue::getHeight)
                .mapToLong(Long::longValue);

        Map<Integer, List<Statue>> groupedByType = statues
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Statue::getTypeId
                        ));

        System.out.println("suma vysok soch: " + selectedStatuesHeights.get().sum());
        System.out.println("Priemerna vyska: " + selectedStatuesHeights.get().average());
        System.out.println(groupedByType);

        Map<Integer, List<String>> statuesWithHeightBelow1500 = statues
                .stream()
                .filter(p -> p.getHeight() < 1500)
                .collect(
                        Collectors.groupingBy(
                                Statue::getTypeId,
                                Collectors.mapping(
                                        Statue::getName,
                                        Collectors.toList())));

        System.out.println("Pocet soch s vyskou pod 1500: " + statuesWithHeightBelow1500.size());
        System.out.println("Sochy s vyskou pod 1500" + statuesWithHeightBelow1500);

        System.out.println(statuesWithHeightBelow1500.compute (1, (k, v) -> Collections.singletonList(v + " s typ ID " + k)));
        System.out.println(statuesWithHeightBelow1500.compute (2, (k, v) -> Collections.singletonList(v + " s typ ID " + k)));

    }
}
