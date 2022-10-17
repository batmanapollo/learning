package recursion;

import java.util.List;

public class SecondMaxNumberFinder {

    public int find(List<Integer> numbers) {
        int first = numbers.get(0);
        int second = numbers.get(1);
        if (first >= second) {
            return find(numbers, 2, first, second);
        } else {
            return find(numbers, 2, second, first);
        }
    }

    private int find(List<Integer> numbers, int index, int max, int secondMax) {
        if (index == numbers.size()) {
            return secondMax;
        }

        var number = numbers.get(index);
        if (number >= max) {
            secondMax = max;
            max = number;
        } else if (number > secondMax) {
            secondMax = number;
        }

        return find(numbers, index + 1, max, secondMax);
    }

}
