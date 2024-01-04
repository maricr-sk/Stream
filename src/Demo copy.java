import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws IOException {
        //Example 1
        IntStream.range(1,10) //all numbers not including 10
                //.forEach(p-> System.out.println(p)); // .forEach(System::p:
                 .forEach(System.out::println);

        //Example 2
        IntStream.range(1,10)
                .skip(5) //skips the first 5 and prints 6789
                .forEach(System.out::println);

        //Example 3
        int answer = IntStream.range(1,5)
                .sum(); //skips the first 5 and prints 6789
        System.out.println(answer);

        /* same thing:
            System.out.println(IntStream
                               .range(1,5)
                               .sum();
         */

        //Example 4
        Stream.of("Ava", "Anna", "Alberto", "Bob", "Charlie", "Dan", "Estefan")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        //Example 5
        String [] strings = {"Ava", "Anna", "Alberto", "Bob", "Charlie", "Dan", "Estefan"};
        Arrays.stream(strings)
                 .filter(x -> x.startsWith("A"))
                .forEach(System.out::println);

         //Example 6
        Arrays.stream(new int [] {4,5,00,2,1,-7,0})
                .map(x -> x*x)
                .average()
                .ifPresent(System.out::println);

         //Example 7
        List<String> names =
                Arrays.asList("Ava", "Anna", "Alberto", "Bob", "Charlie", "Dan", "Estefan");

        names
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);

        //Example 8
        Stream<String> bands = Files.lines(Paths.get("rockBands"));
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close(); // have to close the stream



        Stream<String> bands7 = Files.lines(Paths.get("boop"));
        bands7
                .map(x -> x + " hi " + x)
                .filter(x -> x.length() > 10)
                .forEach(System.out::print);
        bands7.close();



        Stream<String> bands1 = Files.lines(Paths.get("hi!~"));
        bands1
                .sorted()
                .map(s -> s.toUpperCase() + " BOO")
                .filter(s -> s.length() < 5 )
                .forEach(System.out::println);
        bands1.close();
    }
}
