package training.leetcode.p_0800.p0843;

import java.util.*;

interface Master {
    public int guess(String word);
}

public class Solution_0843 {
    public void findSecretWord(String[] wordlist, Master master) {
        int[][] lettersAreHere = new int[26][wordlist[0].length()];
        int[][] lettersNotHere = new int[26][wordlist[0].length()];

        int guess = 0;

        PriorityQueue<String> sortedWords = new PriorityQueue<>(Comparator.comparingInt(a -> score(a, lettersAreHere)));
        sortedWords.addAll(Arrays.asList(wordlist));

        while (!sortedWords.isEmpty()){

            String word = sortedWords.remove();
            int ls;
            if ((ls = lowestScore(word, lettersNotHere)) < -1000) {
                continue;
            }

            int result = master.guess(word);

            // 0: C=1, none of the letters is correct
            // 1: C=6, one of them is correct, 5 of them are not
            // 2: C=15, five include the right letter, 10 are not
            switch (result) {
                case 0:
                    flag(word, lettersAreHere, -10000, 0, 1, 2, 3, 4, 5);
                    flag(word, lettersNotHere, -10000, 0, 1, 2, 3, 4, 5);
                     break;
                case 1:
                    flag(word, lettersNotHere, -6, 0, 1, 2, 3, 4, 5);
                    flag(word, lettersAreHere, +1, 0, 1, 2, 3, 4, 5);
                    break;
                case 2:
                    flag(word, lettersNotHere, -4, 0, 1, 2, 3, 4, 5);
                    flag(word, lettersAreHere, +2, 0, 1, 2, 3, 4, 5);
                    break;
                case 3:
                    flag(word, lettersNotHere, -3, 0, 1, 2, 3, 4, 5);
                    flag(word, lettersAreHere, +3, 0, 1, 2, 3, 4, 5);
                    break;
                case 4:
                    flag(word, lettersNotHere, -2, 0, 1, 2, 3, 4, 5);
                    flag(word, lettersAreHere, +4, 0, 1, 2, 3, 4, 5);
                    break;
                case 5:
                    flag(word, lettersNotHere, -1, 0, 1, 2, 3, 4, 5);
                    flag(word, lettersAreHere, +7, 0, 1, 2, 3, 4, 5);
                    break;

            }

            if (result == 6) /* yay! */ return;

            guess++;

            PriorityQueue<String> tmp = new PriorityQueue<>(Comparator.comparingInt(a -> score(a, lettersNotHere)));
            tmp.addAll(sortedWords);
            sortedWords = tmp;
        }

        dump(lettersAreHere);
        System.out.println("----------------------");
        dump(lettersNotHere);
    }

    private int score(String a, int[][] letters) {
        char[] chars = a.toCharArray();

        double score = 0;

        int negatives = 0;

        for (int i = 0; i < chars.length; i++) {
            if (letters[chars[i]-'a'][i] < 0) negatives++;
            score += (0.0 + letters[chars[i]-'a'][i]);
        }

        return (int) (score * (1 + negatives / 4.0));
    }

    private int lowestScore(String a, int[][] letters) {
        char[] chars = a.toCharArray();

        int score = 0;

        int negatives = 0;

        for (int i = 0; i < chars.length; i++) {
            int v = letters[chars[i] - 'a'][i];
            if (v < 0) negatives++;
            if (score > v)
                score = v;
        }

        return score;
    }

    private void dump(int[][] letters) {
        for (int i = 0; i < letters.length; i++) {
            int[] letter = letters[i];
            if (allZero(letter)) continue;
            System.out.printf("| %c ", i+'a');
            for (int value : letter) {
                System.out.printf("| %6d ", value);
            }
            System.out.println("|");
        }
    }

    private boolean allZero(int[] letter) {
        for (int i : letter) {
            if (i != 0) return false;
        }

        return true;
    }

    private void flag(String word, int[][] letters, int val, int... i) {
        for (int pos : i) {
            letters[word.charAt(pos)-'a'][pos] += val;
        }
    }
}
