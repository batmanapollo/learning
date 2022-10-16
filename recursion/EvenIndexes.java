package com.company;

import java.util.List;

public class EvenIndexes {

    private static final Integer MIN_LIST_SIZE = 2;

    public void printElementsWithEvenIndex(List<Integer> list) {
        printElementsWithEvenIndex(list, 0);
    }

    private void printElementsWithEvenIndex(List<Integer> list, int index) {
        if (list.size() == 0 || index >= list.size()) {
            return;
        }
        var element = list.get(index);
        System.out.println(element);
        if (list.size() > MIN_LIST_SIZE) {
            printElementsWithEvenIndex(list, index + 2);
        }
    }

}
