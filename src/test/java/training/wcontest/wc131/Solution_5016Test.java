package training.wcontest.wc131;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Solution_5016Test {
    // solution object
    private Solution_5016 s = new Solution_5016();

    @Test
    public void ensure_it_works_when_input_is_1() {
        String result = s.removeOuterParentheses("(()())(())");

        assertThat(result, is("()()()"));
    }

    @Test
    public void ensure_it_works_when_input_is_0() {
        String result = s.removeOuterParentheses("(()())(())(()(()))");

        assertThat(result, is("()()()()(())"));
    }

    @Test
    public void ensure_it_works_when_input_is_null() {
        String result = s.removeOuterParentheses("()()");

        assertThat(result, is(""));
    }

    @Test
    public void ensure_it_works_when_input_is_single() {
        String result = s.removeOuterParentheses("()");

        assertThat(result, is(""));
    }

    @Test
    public void ensure_it_works_when_input_is_10() {
        String result = s.removeOuterParentheses("(((((((((())))))))))");

        assertThat(result, is("((((((((()))))))))"));
    }
}