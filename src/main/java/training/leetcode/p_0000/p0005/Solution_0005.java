package training.leetcode.p_0000.p0005;

public class Solution_0005 {
    public String longestPalindrome(String s) {
        int inputLen = s.length();
        boolean[][] palindromeRepository = new boolean[inputLen][inputLen];

        char[] str = s.toCharArray();

        // find all 1-letter palindromes (hint: ALL 1-letter words are palindromes)
        markSingleLettersAsPalindrome(palindromeRepository);

        String longestPalindrome = s.substring(0, Math.min(1, s.length()));

        longestPalindrome = checkTwoLettersForPalindromes(str, longestPalindrome, palindromeRepository);

        // find n-letter palindromes (n > 1)
        for (int n = 3; n <= inputLen; n++) {
            longestPalindrome = markPalindromesOfSize(n, str, palindromeRepository, longestPalindrome);
        }

        return longestPalindrome;
    }

    private String checkTwoLettersForPalindromes(char[] str, String longestPalindrome, boolean[][] repo) {
        boolean found = false;

        for (int i = 0; i < repo.length-1; i++) {
            boolean isPalindrome = str[i] == str[i + 1];

            repo[i][i+1] = isPalindrome;

            if (!found && isPalindrome) {
                found = true;
                longestPalindrome = String.copyValueOf(str, i, 2);
            }
        }

        return longestPalindrome;
    }

    private String markPalindromesOfSize(int n, char[] s, boolean[][] repo, String longestPalindrome) {
        // iterate in chunks of size n

        String newLongest = longestPalindrome;

        for (int i = 0; i+n <= repo.length; i++) {
            int start = i;
            int end   = i+n-1;

            // is palidrome if:
            //   [1] string between start and end is palindrome
            //   [2] s[start] == s[end]

            boolean isCorePalindrome = isKnownPalindrome(repo, start+1, end-1);

            if (!isCorePalindrome) continue;

            boolean isPalindrome = s[start] == s[end];

            repo[start][end] = isPalindrome;

            if (repo[start][end] && end-start >= newLongest.length()) {
                newLongest = String.copyValueOf(s, start, end+1-start);
            }
        }

        return newLongest;
    }

    private boolean isKnownPalindrome(boolean[][] repo, int start, int end) {
        if (start+1 > end) return true;
        return repo[start][end];
    }

    private void markSingleLettersAsPalindrome(boolean[][] repo) {
        for (int i = 0; i < repo.length; i++) {
            repo[i][i] = true;
        }
    }
}
