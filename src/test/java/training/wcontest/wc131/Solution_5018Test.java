package training.wcontest.wc131;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Solution_5018Test {
    // solution object
    private Solution_5018 s = new Solution_5018();

    @Test
    public void ensure_it_works_when_input_is_1() {
        String[] queries = {
                "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"
        };

        List<Boolean> result = s.camelMatch(queries, "FB");
        List<Boolean> booleans = Arrays.asList(true, false, true, true, false);
        assertThat(result, is(booleans));

    }

    @Test
    public void ensure_it_works_when_input_is_2() {
        String[] queries = {
                "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"
        };

        List<Boolean> result = s.camelMatch(queries, "FoBa");
        List<Boolean> booleans = Arrays.asList(true, false, true, false, false);
        assertThat(result, is(booleans));

    }

    @Test
    public void ensure_it_works_when_input_is_3() {
        String[] queries = {
                "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"
        };

        List<Boolean> result = s.camelMatch(queries, "FoBaT");
        List<Boolean> booleans = Arrays.asList(false, true, false, false, false);
        assertThat(result, is(booleans));

    }

    @Test
    public void ensure_it_works_when_input_is_4() {
        String[] queries = {
                "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack", "aaaaFaooboBaaaiedaTFaa"
        };

        List<Boolean> result = s.camelMatch(queries, "FoBaT");
        List<Boolean> booleans = Arrays.asList(false, true, false, false, false, true);
        assertThat(result, is(booleans));

    }
}