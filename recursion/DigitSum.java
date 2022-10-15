package com.company;

public class DigitSum {

    public Integer compute(Integer number) {
        var a = number / 10;
        if (a == 0) {
            return number;
        }
        return number % 10 + compute(a);
    }

}
