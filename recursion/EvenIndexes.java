package com.company;

import java.util.List;

public class EvenIndexes {

    private static final Integer MIN_LIST_SIZE = 2;

    public void printElementsWithEvenIndex(List<Integer> list) {
        if (list.size() == 0) {
            return;
        }
        var element = list.get(0);
        System.out.println(element);
        if (list.size() > MIN_LIST_SIZE) {
            printElementsWithEvenIndex(list.subList(MIN_LIST_SIZE, list.size()));
        }
    }

}
