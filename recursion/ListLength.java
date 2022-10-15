package com.company;

import java.util.List;

public class ListLength {

    public Integer compute(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        return 1 + compute(list.subList(1, list.size()));
    }

}
