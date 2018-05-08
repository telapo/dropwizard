/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streams;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

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
        
        listThree.stream().map(x->Arrays.toString(x)).forEach(System.out::println);
    }

}
