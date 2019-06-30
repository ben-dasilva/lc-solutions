package training.other;

public class ReverseVowels {
    String reverseVowels(String in) {
        int l = 0;
        int r = in.length() - 1;

        StringBuilder builder = new StringBuilder(in);

        while ( l < r ) {
            char lc = in.charAt(l);
            char rc = in.charAt(r);

            boolean lv = isVowel(lc);
            boolean rv = isVowel(rc);
            boolean swapped = lv && rv;

            if (swapped) {
                builder.setCharAt(l, rc);
                builder.setCharAt(r, lc);
            }

            if (!lv || swapped) l++;
            if (!rv || swapped) r--;
        }

        return builder.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        ReverseVowels v = new ReverseVowels();

        System.out.println("apple => " + v.reverseVowels("apple"));
        System.out.println("friend => " + v.reverseVowels("friend"));
    }
}
