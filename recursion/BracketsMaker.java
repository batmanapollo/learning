package recursion;

import java.util.ArrayList;
import java.util.List;

public class BracketsMaker {

    public static final char LEFT_BRACKET = '(';
    public static final char RIGHT_BRACKET = ')';

    public List<String> make(int count) {
        var bracketsCombinations = new ArrayList<String>();
        addBracket(bracketsCombinations, count, count, new char[count * 2], 0);
        return bracketsCombinations;
    }

    private void addBracket(List<String> acc, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem == 0 && rightRem == 0) {
            acc.add(String.copyValueOf(str));
        }

        if (leftRem > 0) {
            str[index] = LEFT_BRACKET;
            addBracket(acc, leftRem - 1, rightRem, str, index + 1);
        }

        if (rightRem > leftRem) {
            str[index] = RIGHT_BRACKET;
            addBracket(acc, leftRem, rightRem - 1, str, index + 1);
        }
    }

}
