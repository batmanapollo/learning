package com.company;

import java.util.List;

public class EvenNumbers {

    public void printEvenNumbers(List<Integer> numbers) {
        if (numbers.size() == 0) {
            return;
        }
        var number = numbers.get(0);
        var shouldPrintNumber = number % 2 == 0;
        if (shouldPrintNumber) {
            System.out.println(number);
        }
        printEvenNumbers(numbers.subList(1, numbers.size()));
    }

}
