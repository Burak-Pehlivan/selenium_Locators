package Streams;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class L1_Streams {

    // Count the number of names starting with A in list

    @Test
    public void countingName(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Asli");
        names.add("Ahmet");
        names.add("Borda");
        names.add("Ramo");
        names.add("Arkas");

        int count = 0;

        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);

            if (actual.startsWith("A")){
                count++;
            }
        }

        System.out.println(count);
    }

    @Test
    public void streamFilter(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Asli");
        names.add("Ahmet");
        names.add("Borda");
        names.add("Remo");
        names.add("Arkas");

        Long counting = names.stream().filter(s->s.startsWith("A")).count();   // A ile baslayan kelimelerin sayaci
        System.out.println(counting);

        long d = Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s ->
        {
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(d);

        // Print all the names of ArrayList
        // print names of length > 4 with Uppercase
        names.stream().filter(s -> s.length()>4).forEach(s -> System.out.println(s));
    }

    @Test
    public void streamMap()
    {
        // print names which have last letter as "a" with Uppercase
        Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        // print names which have first letter as "a" with Uppercase and sorted
        List<String> names = Arrays.asList("Abhijeet","Don","Alekhya","Adam","Rama");
        names.stream().filter(s -> s.startsWith("A"))
                .map(s -> s.toUpperCase())
                .sorted()
                .forEach(s -> System.out.println(s));
    }
}
