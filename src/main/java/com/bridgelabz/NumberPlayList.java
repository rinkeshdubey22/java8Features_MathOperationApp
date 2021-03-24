package com.bridgelabz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class NumberPlayList {
    public static void main(String[] args) {
        List<Integer> myNumberList = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            myNumberList.add(i);
        }

        //Method1: Traversing using Iterator
        Iterator<Integer> it = myNumberList.iterator();
        while (it.hasNext()) {

            Integer i = it.next();
            System.out.println("Iterator value::" + i);
        }

        //Method2: Traversing using Consumer integer implementation
        class MyConsumer implements Consumer<Integer> {

            public void accept(Integer t) {
                System.out.println("Mth2: Consumer impl Value::" + t);
            }
        }
        MyConsumer action = new MyConsumer();
        myNumberList.forEach(action);

        //Method3: Traversing with Anonymous Consumer interface implementation
        myNumberList.forEach(new Consumer<Integer>() {

            public void accept(Integer t) {
                System.out.println("Mth3: forEach anonymous class Value::" + t);
            }
        });

        //Method 4:Explicit Lambda Function
        Consumer<Integer> myListAction = n-> {
            System.out.println(("Mth4: forEach Lambda impl Value::" + n));
        };
        myNumberList.forEach(myListAction);

        //Method 5: Implicit Lambda Function
        myNumberList.forEach( n->{
            System.out.println(("Mth5: forEach Lambda impl Value::" + n));
        });

        //Method 6: Implicit Lambda function to print double value
        Function<Integer,Double> toDoubleFunction = Integer::doubleValue;
        myNumberList.forEach(n -> {
            System.out.println(("Math5: forEach lambda impl Value::" + toDoubleFunction.apply(n)));
        });

        //Method 7: Implicit Lambda function to print double value
        Predicate<Integer> isEvenFunction = n -> n > 0 && n%2 == 0;
        myNumberList.forEach(n -> {
            System.out.println(("Mth7: forEach Lambda impl Value::" + isEvenFunction.test(n)));
        });

        //Method 8: Processing the stream
        myNumberList.stream().forEach(n -> {
            System.out.println("Mth8: Stream for each value:" + n);
        });

        //Method 9: Processing the stream, Apply Operations on the Stream and then
        // store the Result
        List<Double> streamList = myNumberList.stream()
                                  .filter(isEvenFunction)
                                  .map(toDoubleFunction)
                                  .collect(Collectors.toList());
        System.out.println("mth9: Printing Double List:" + streamList);

        //Method 10: Listing the first even
        Integer first = myNumberList.stream()
                        .filter(isEvenFunction)
                        .peek(n -> System.out.println("Peak Even Number: " +n))
                        .findFirst()
                        .orElse(null);
        System.out.println("Mth10: First Even: " + first);

        //Method 11: Minimum Even Number
        Integer min = myNumberList.stream()
                      .filter(isEvenFunction)
                      .min((n1, n2) -> n1-n2)
                      .orElse(null);
        System.out.println("Mth11: Min Even: " + min);

        //Method 12: Maximum Even Number
        Integer max = myNumberList.stream().filter(isEvenFunction)
                        .max(Comparator.comparing(Integer::intValue))
                        .orElse(null);
        System.out.println("Mth12: Max Even:" + max);

    }

}
