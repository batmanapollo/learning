package recursion;

public class Palindrom {

    public boolean isPalindrom(String source) {
        if (source.length() < 2) {
            return true;
        }

        if (source.charAt(0) != source.charAt(source.length() - 1)) {
            return false;
        }

        return isPalindrom(source.substring(1, source.length() - 1));
    }

}
