package com.company;

public class Exponentiation {
    
    public Integer compute(Integer base, Integer exponent) {
        if (exponent == 1) {
            return base;
        }
        return base * compute(base, exponent - 1);
    }
    
}
