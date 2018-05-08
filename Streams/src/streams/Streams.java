/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author davide
 */
public class Streams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // print square of elements
        Integer[] array = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.stream(array).map(x -> x * x).collect(toList());
        list.stream().forEach(System.out::println);

        // create pairs from 2 arrays
        List<Integer> arrayOne = Arrays.asList(1, 2, 3);
        List<Integer> arrayTwo = Arrays.asList(3, 4);
        List<int[]> listTwo = arrayOne.stream()
                .flatMap(x -> arrayTwo.stream()
                .map(y -> new int[]{x, y})).collect(toList()
        );

        // create pairs only if their sum is divisible by 3 and print it
        List<int[]> listThree = arrayOne.stream()
                .flatMap(x -> arrayTwo.stream()
                .filter(y -> (x + y) % 3 == 0)
                .map(y -> new int[]{x, y})
                )
                .collect(toList());

        // print number of dishes
        listThree.stream().map(x -> Arrays.toString(x)).forEach(System.out::println);
        
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("Pizza", 2000, true));
        menu.add(new Dish("Bistecca", 850, false));
        menu.add(new Dish("Insalata", 200, true));
        
        Optional<Integer> sumOfDishes = menu.stream().map(x -> 1).reduce(Integer::sum);
        System.out.println(sumOfDishes.get());

        // traders and transactions area
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        
        System.out.println("Transactions exercise\n");

        // 1. find transactions from 2011 and sort them by value
        List<Transaction> yearSorted = transactions.stream().filter(x -> x.getYear() == 2011).sorted(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                if (o1.getValue() < o2.getValue()) {
                    return -1;
                } else if (o1.getValue() == o2.getValue()) {
                    return 0;
                } else {
                    return +1;
                }
            }
        }).collect(toList());
        yearSorted.stream().forEach(System.out::println);
        
        System.out.println("");

        // 2. find unique cities
        List<String> uniqueCities = transactions.stream().map(x -> x.getTrader().getCity()).distinct().collect(toList());
        uniqueCities.stream().forEach(System.out::println);
        
        System.out.println("");

        // 3. all traders from cambridge sorted by name
        List<String> cambridgeName = transactions.stream().filter(x -> x.getTrader().getCity().equalsIgnoreCase("Cambridge")).map(y -> y.getTrader().getName()).distinct().sorted(String::compareTo).collect(toList());
        cambridgeName.stream().forEach(System.out::println);
        
        System.out.println("");

        // 4. return a string of all traders' names sorted alphabetically
        String singleString = transactions.stream().map(x -> x.getTrader().getName()).distinct().sorted(String::compareTo).reduce("", (a, b) -> a + b);
        System.out.println(singleString);
        
        System.out.println("");

        // 5. are any traders based in Milan
        Optional<Transaction> findAny = transactions.stream().filter(x -> x.getTrader().getCity().equalsIgnoreCase("Milan")).findAny();
        if (findAny.isPresent()) {
            System.out.println("There is at least one trader based in Milan");
        } else {
            System.out.println("I could not find any trader in Milan");
        }
        
        System.out.println("");
        
        // 6. print all transactions values from traders in Cambridge
        transactions.stream().filter(x->x.getTrader().getCity().equalsIgnoreCase("Cambridge")).map(y->y.getValue()).forEach(System.out::println);
        
        System.out.println("");
        
        // 7. highest transaction value
        Optional<Integer> max = transactions.stream().map(x->x.getValue()).reduce(Integer::max);
        if(max.isPresent()){
            System.out.println(max.get());
        }else{
            System.out.println("No max found!");
        }
        
        System.out.println("");
        
        // 8. smallest transaction value
        transactions.stream().map(x->x.getValue()).reduce(Integer::min).ifPresent(System.out::println);
        
        System.out.println("");
        
        // fibonacci
        Stream.iterate(new int[]{0,1}, x->new int[]{x[1],x[0]+x[1]})
                .limit(20)
                .forEach(t->System.out.println("(" + t[0] + "," + t[1] + ")"));
    }
    
}
