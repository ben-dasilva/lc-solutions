package training.wcontest.wc128;

public class Solution_1012 {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;

        int complement = 0;
        int pos = 0;

        boolean skipping = true;

        while (N > 0) {
            int bit = (N & 1) == 1 ? 0 : 1;

            complement |= (bit << pos);

            pos++;

            N >>= 1;
        }

        return complement;
    }
}
