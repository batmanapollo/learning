package com.company;

import java.util.List;

public class EvenNumbers {

    public void printEvenNumbers(List<Integer> numbers) {
        printEvenNumbers(numbers, 0);
    }

    private void printEvenNumbers(List<Integer> numbers, int index) {
        if (numbers.size() == 0 || index == numbers.size()) {
            return;
        }
        var number = numbers.get(index);
        var shouldPrintNumber = number % 2 == 0;
        if (shouldPrintNumber) {
            System.out.println(number);
        }
        printEvenNumbers(numbers, index + 1);
    }

}
