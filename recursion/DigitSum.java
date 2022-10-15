package com.company;

public class DigitSum {

    public Integer compute(Integer number) {
        var quotient = number / 10;
        if (quotient == 0) {
            return number;
        }
        return number % 10 + compute(quotient);
    }

}
