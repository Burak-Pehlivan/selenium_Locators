package Streams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

    @Test
    public void streamMap2()
    {
        ArrayList<String> names = new ArrayList<String>();
        names.add("man");
        names.add("women");
        names.add("Bunny");
        names.add("winter");


        Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        // print names which have first letter as "a" with Uppercase and sorted
        List<String> names1 = Arrays.asList("Abhijeet","Don","Alekhya","Adam","Rama");
        names1.stream().filter(s -> s.startsWith("A"))
                .map(s -> s.toUpperCase())
                .sorted()
                .forEach(s -> System.out.println(s));

        System.out.println("****** Merging *******");

        /** Merging 2 different lists */
        Stream <String> newStream = Stream.concat(names.stream(),names1.stream());
        newStream.sorted().forEach(s -> System.out.println(s));

        Stream <String> newStream1 = Stream.concat(names.stream(),names1.stream());
        boolean flag = newStream1.anyMatch(s -> s.equalsIgnoreCase("Adam"));
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect()
    {
        List<String>ls = Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls);

        //

        List<Integer> values = Arrays.asList(2,3,5,2,1,2,3,5,6);
        //print unique number from this array
        //sort the array

        values.stream().distinct().forEach(s-> System.out.print(s + " , "));
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println();
        System.out.println(li.get(2));
    }
}
