package training.leetcode.p_0900.p0975;

import org.junit.Test;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Solution_0975Test {
    // solution object
    Solution_0975 s = new Solution_0975();

    @Test
    public void ensure_it_works_when_input_is_1() {
        int result = s.oddEvenJumps(new int[] {1});

        assertEquals(1, result);
    }

    @Test
    public void ensure_2_jumps_when_input_is_10_13_12_14_15() {
        int result = s.oddEvenJumps(new int[] {10, 13, 12, 14, 15});

        assertEquals(2, result);
    }

    @Test
    public void ensure_3_jumps_when_input_is_2_3_1_1_4() {
        int result = s.oddEvenJumps(new int[] {2, 3, 1, 1, 4});

        assertEquals(3, result);
    }

    @Test
    public void ensure_3_jumps_when_input_is_1_2_3_1_1_4() {
        int result = s.oddEvenJumps(new int[] {1, 2, 3, 1, 1, 4});

        assertEquals(4, result);
    }

    @Test
    public void ensure_3_jumps_when_input_is_a_large_file() throws Exception {
        URI uri = this.getClass().getResource("/p_0900/p0975/large_list.txt").toURI();

        List<String> lines = Files.readAllLines(Paths.get(uri));
        int[] ints = lines.stream().mapToInt(Integer::valueOf).toArray();
        int result = s.oddEvenJumps(ints);

        assertEquals(2819, result);
    }

}