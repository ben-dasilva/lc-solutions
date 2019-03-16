package training.leetcode.p_0900.p0904;

public class Solution_0904 {
    public int totalFruit(int[] tree) {
        int[] basket = {-1, -1};
        int max = 0;
        int consecutive = 0;
        int previousFruit = -1;
        int start = 0;

        for (int i = 0; i < tree.length; i++) {
            int currentFruit = tree[i];

            boolean contains =
                    basket[0] != -1 && basket[0] == currentFruit || basket[1] != -1 && basket[1] == currentFruit;

            if (contains) {
                consecutive = currentFruit == previousFruit ? consecutive + 1 : 1;

                previousFruit = currentFruit;
                continue;
            }

            if (basket[0] != -1 && basket[1] != -1) {
                int candidateMax = i - start;

                if (candidateMax > max) max = candidateMax;

                start = i - consecutive;

                basket[0] = currentFruit;
                basket[1] = previousFruit;
            } else {
                boolean isBasketFull = basket[0] == -1;

                basket[isBasketFull ? 0 : 1] = currentFruit;
            }

            consecutive = 1;

            previousFruit = currentFruit;
        }

        int candidateMax = tree.length - start;

        if (candidateMax > max) max = candidateMax;

        return max;
    }
}
