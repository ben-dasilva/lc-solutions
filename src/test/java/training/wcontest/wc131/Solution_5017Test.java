package training.wcontest.wc131;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Solution_5017Test {
    // solution object
    private Solution_5017 s = new Solution_5017();

    @Test
    public void ensure_it_works_when_input_is_22() {
        TreeNode exemple1 = TreeNode.of(new Integer[]{1, 0, 1, 0, 1, 0, 1});
        int result = s.sumRootToLeaf(exemple1);

        assertThat(result, is(22));
    }

    @Test
    public void ensure_it_works_when_input_is_9() {
        TreeNode exemple1 = TreeNode.of(new Integer[]{1, 0, null, 0, 1});

        int result = s.sumRootToLeaf(exemple1);

        assertThat(result, is(9));
    }

    @Test
    public void ensure_it_works_when_input_is_0() {
        TreeNode exemple1 = new TreeNode(0);

        int result = s.sumRootToLeaf(exemple1);

        assertThat(result, is(0));
    }

    @Test
    public void ensure_it_works_when_input_is_1() {
        TreeNode exemple1 = new TreeNode(1);

        int result = s.sumRootToLeaf(exemple1);

        assertThat(result, is(1));
    }

    @Test

    public void ensure_it_works_when_input_is_00() {
        TreeNode exemple1 = new TreeNode(0, new TreeNode(0), new TreeNode(0));

        int result = s.sumRootToLeaf(exemple1);

        assertThat(result, is(0));
    }

    // 111011100110101100101000000111

    @Test
    public void ensure_it_works_when_input_is_large() {
        int[] i = {1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1};

        TreeNode root = new TreeNode(i[0]);
        TreeNode current = root;

        for (int i1 = 1; i1 < i.length; i1++) {
            int bit = i[i1];
            current.right = new TreeNode(bit);
            current = current.right;
        }

        int result = s.sumRootToLeaf(root);

        assertThat(result, is(0));
    }

    @Test
    public void ensure_it_works_when_input_is_also_wrong() {
        TreeNode root = TreeNode.of(new Integer[] {
                0, null, 0, null, 1, null, 0, null, 1, null, 0, null, 1, null, 0,
                null, 0, null, 1, null, 1, null, 1, null, 1, null, 0, null, 1,
                null, 1, null, 0, null, 1, null, 1, null, 0, null, 1, null, 1,
                null, 0, null, 1, null, 0, null, 0, null, 0, null, 0, null, 0,
                null, 1, null, 0, null, 1, null, 1, null, 0, null, 0, null, 0,
                null, 1, null, 1, null, 1, null, 0, null, 1, null, 1, null, 0,
                null, 0, null, 1, null, 1, null, 0, null, 0, null, 0, null, 1,
                null, 0, null, 1, null, 0, null, 1, null, 0, null, 1, null, 1,
                null, 1, null, 0, null, 0, null, 1, null, 0, null, 0, null, 1,
                null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 0,
                null, 0, null, 0, null, 0, null, 1, null, 0, null, 0, null, 0,
                null, 0, null, 1, null, 1, null, 1, null, 1, null, 0, null, 0,
                null, 1, null, 0, null, 1, null, 0, null, 0, null, 0, null, 0,
                null, 0, null, 0, null, 0, null, 1, null, 1, null, 0, null, 0,
                null, 1, null, 0, null, 1, null, 0, null, 0, null, 0, null, 1,
                null, 0, null, 0, null, 1, null, 0, null, 0, null, 0, null, 1,
                null, 1, null, 0, null, 0, null, 0, null, 1, null, 1, null, 0,
                null, 0, null, 0, null, 0, null, 0, null, 1, null, 1, null, 0,
                null, 0, null, 1, null, 0, null, 1, null, 1, null, 0, null, 1,
                null, 1, null, 0, null, 0, null, 1, null, 1, null, 1, null, 0,
                null, 1, null, 0, null, 1, null, 0, null, 0, null, 0, null, 0,
                null, 0, null, 0, null, 1, null, 1, null, 1, null, 1, null, 0,
                null, 0, null, 1, null, 1, null, 0, null, 1, null, 1, null, 0,
                null, 1, null, 0, null, 1, null, 1, null, 0, null, 1, null, 1,
                null, 0, null, 0, null, 0, null, 0, null, 1, null, 1, null, 1,
                null, 1, null, 0, null, 1, null, 0, null, 0, null, 1, null, 1,
                null, 1, null, 0, null, 1, null, 1, null, 1, null, 1, null, 0,
                null, 0, null, 1, null, 1, null, 0, null, 0, null, 1, null, 1,
                null, 1, null, 0, null, 1, null, 0, null, 0, null, 1, null, 0,
                null, 1, null, 0, null, 0, null, 1, null, 1, null, 0, null, 1,
                null, 0, null, 0, null, 0, null, 0, null, 1, null, 1, null, 1,
                null, 1, null, 1, null, 1, null, 0, null, 1, null, 0, null, 1,
                null, 0, null, 1, null, 0, null, 1, null, 1, null, 0, null, 1,
                null, 1, null, 1, null, 0, null, 0, null, 1, null, 1, null, 0,
                null, 0, null, 1, null, 0, null, 0, null, 0, null, 0, null, 0,
                null, 1, null, 1, null, 1, null, 0, null, 1, null, 0, null, 1,
                null, 1, null, 1, null, 0, null, 0, null, 1, null, 0, null, 1,
                null, 1, null, 0, null, 0, null, 1, null, 0, null, 1, null, 1,
                null, 1, null, 1, null, 0, null, 0, null, 0, null, 0, null, 1,
                null, 0, null, 1, null, 0, null, 0, null, 1, null, 0, null, 1,
                null, 1, null, 1, null, 1, null, 0, null, 1, null, 0, null, 0,
                null, 0, null, 1, null, 1, null, 1, null, 0, null, 1, null, 0,
                null, 0, null, 1, null, 0, null, 0, null, 0, null, 0, null, 0,
                null, 1, null, 0, null, 0, null, 1, null, 1, null, 0, null, 0,
                null, 1, null, 0, null, 0, null, 1, null, 1, null, 0, null, 0,
                null, 1, null, 0, null, 0, null, 1, null, 0, null, 0, null, 1,
                null, 0, null, 0, null, 1, null, 1, null, 1, null, 1, null, 1,
                null, 0, null, 1, null, 1, null, 0, null, 1, null, 1, null, 0,
                null, 1, null, 0, null, 1, null, 0, null, 0, null, 1, null, 0,
                null, 1, null, 0, null, 1, null, 0, null, 1, null, 1, null, 1,
                null, 1, null, 0, null, 1, null, 1, null, 0, null, 1, null, 0,
                null, 1, null, 0, null, 0, null, 0, null, 1, null, 0, null, 1,
                null, 1, null, 1, null, 0, null, 0, null, 0, null, 1, null, 0,
                null, 0, null, 1, null, 1, null, 0, null, 0, null, 1, null, 0,
                null, 0, null, 1, null, 1, null, 0, null, 0, null, 0, null, 0,
                null, 1, null, 0, null, 0, null, 0, null, 0, null, 1, null, 1,
                null, 0, null, 1, null, 1, null, 1, null, 0, null, 1, null, 1,
                null, 1, null, 1, null, 1, null, 1, null, 0, null, 0, null, 1,
                null, 0, null, 1, null, 1, null, 0, null, 1, null, 1, null, 0,
                null, 1, null, 1, null, 0, null, 1, null, 0, null, 1, null, 1,
                null, 0, null, 1, null, 0, null, 1, null, 1, null, 1, null, 0,
                null, 1, null, 1, null, 1, null, 1, null, 0, null, 0, null, 0,
                null, 0, null, 0, null, 0, null, 0, null, 0, null, 1, null, 1,
                null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 0,
                null, 0, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1,
                null, 0, null, 1, null, 1, null, 0, null, 0, null, 1, null, 0,
                null, 1, null, 1, null, 0, null, 1, null, 1, null, 1, null, 0,
                null, 0, null, 1, null, 0, null, 0, null, 0, null, 1, null, 1,
                null, 1, null, 0, null, 0, null, 0, null, 0, null, 1, null, 0,
                null, 0, null, 0, null, 0, null, 1, null, 0, null, 0, null, 1,
                null, 0, null, 0, null, 1, null, 1, null, 1, null, 0, null, 0,
                null, 1, null, 1, null, 1, null, 0, null, 1, null, 1, null, 0,
                null, 1, null, 1, null, 1, null, 0, null, 1, null, 0, null, 0,
                null, 1, null, 0, null, 1, null, 1, null, 1, null, 1, null, 1,
                null, 0, null, 0, null, 0, null, 1, null, 0, null, 1, null, 0,
                null, 1, null, 0, null, 0, null, 0, null, 0, null, 0, null, 1,
                null, 0, null, 1, null, 1, null, 1, null, 1, null, 0, null, 0,
                null, 1, null, 0, null, 0, null, 0, null, 1, null, 0, null, 1,
                null, 0, null, 0, null, 1, null, 1, null, 0, null, 1, null, 1,
                null, 1, null, 1, null, 0, null, 0, null, 0, null, 0, null, 0,
                null, 0, null, 1, null, 0, null, 1, null, 1, null, 0, null, 0,
                null, 1, null, 0, null, 1, null, 0, null, 1, null, 1, null, 0,
                null, 0, null, 1, null, 1, null, 0, null, 0, null, 1, null, 1,
                null, 0, null, 0, null, 1, null, 0, null, 0, null, 0, null, 1,
                null, 1, null, 1, null, 0, null, 0, null, 0, null, 1, null, 0,
                null, 0, null, 1, null, 1, null, 1, null, 0, null, 0, null, 0,
                null, 1, null, 1, null, 1, null, 0, null, 0, null, 1, null, 1,
                null, 1, null, 1, null, 0, null, 0, null, 0, null, 0, null, 1,
                null, 0, null, 1, null, 1, null, 0, null, 1, null, 1, null, 1,
                null, 1, null, 1, null, 1, null, 0, null, 1, null, 0, null, 0,
                null, 1, null, 0, null, 0, null, 0, null, 1, null, 0, null, 1,
                null, 1, null, 0, null, 1, null, 0, null, 1, null, 1, null, 1,
                null, 1, null, 0, null, 1, null, 1, null, 1, null, 0, null, 0,
                null, 0, null, 1, null, 0, null, 0, null, 0, null, 0, null, 0,
                null, 1, null, 0, null, 0, null, 0, null, 1, null, 1, null, 1,
                null, 0, null, 0, null, 1, null, 0, null, 1, null, 1, null, 0,
                null, 0, null, 1, null, 1, null, 1, null, 1, null, 1, null, 0,
                null, 1, null, 0, null, 0, null, 1, null, 0, null, 1, null, 0,
                null, 1, null, 0, null, 1, null, 1, null, 0, null, 1, null, 0,
                null, 0, null, 1, null, 0, null, 1, null, 1, null, 0, null, 0,
                null, 0, null, 1, null, 0, null, 0, null, 1, null, 0, null, 0,
                null, 0, null, 1, null, 1, null, 0, null, 1, null, 0, null, 0,
                null, 0, null, 1, null, 0, null, 1, null, 0, null, 1, null, 0,
                null, 0, null, 1, null, 1, null, 0, null, 0, null, 1, null, 1,
                null, 0, null, 1, null, 0, null, 1, null, 0, null, 1, null, 1,
                null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 0,
                null, 1, null, 1, null, 0, null, 0, null, 1, null, 0, null, 0,
                null, 0, null, 1, null, 0, null, 1, null, 1, null, 0, null, 1,
                null, 1, null, 1, null, 0, null, 0, null, 1, null, 1, null, 1,
                null, 0, null, 1, null, 0, null, 0, null, 0, null, 1, null, 0,
                null, 1, null, 1, null, 0, null, 0, null, 1, null, 0, null, 1,
                null, 0, null, 0, null, 0, null, 1, null, 1, null, 0, null, 0,
                null, 0, null, 1, null, 0, null, 0, null, 0, null, 1, null, 0,
                null, 0, null, 0, null, 0, null, 1, null, 0, null, 0, null, 1,
                null, 0, null, 0, null, 0, null, 1, null, 1, null, 0, null, 0,
                null, 0, null, 0, null, 0, null, 0, null, 1, null, 0, null, 1,
                null, 1, null, 1, null, 1, null, 0, null, 0, null, 0, null, 0,
                null, 0, null, 0, null, 0, null, 1, null, 0, null, 0, null, 0,
                null, 1, null, 0, null, 1, null, 0, null, 1, null, 0, null, 0,
                null, 0, null, 1, null, 0, null, 0, null, 1, null, 1, null, 1,
                null, 1, null, 1, null, 1, null, 0, null, 1, null, 0, null, 0,
                null, 1, null, 0, null, 1, null, 0, null, 1, null, 1, null, 1,
                null, 0, null, 1, null, 0, null, 1, null, 0, null, 0, null, 0,
                null, 0, null, 1, null, 1, null, 0, null, 1, null, 0, null, 0,
                null, 0, null, 1, null, 0, null, 1, null, 0, null, 1, null, 1,
                null, 0, null, 0, null, 1, null, 1, null, 0, null, 1, null, 0,
                null, 0, null, 0, null, 1, null, 0, null, 1, null, 1, null, 1,
                null, 1, null, 1, null, 0, null, 1, null, 0, null, 1, null, 1,
                null, 0, null, 1, null, 0, null, 1, null, 0, null, 1, null, 0,
                null, 1, null, 0, null, 1, null, 0, null, 0, null, 0, null, 1,
                null, 0, null, 1, null, 0, null, 1, null, 1, null, 1, null, 0,
                null, 1, null, 1, null, 1, null, 1, null, 0, null, 1, null, 0,
                null, 0, null, 1, null, 1, null, 0, null, 0, null, 1, null, 1,
                null, 1, null, 1, null, 0, null, 0, null, 0, null, 0, null, 1,
                null, 1, null, 0, null, 0, null, 1, null, 0, null, 0, null, 1,
                null, 0, null, 1, null, 0, null, 1, null, 1, null, 1, null, 0,
                null, 1, null, 1, null, 1, null, 1, null, 0, null, 1, null, 0,
                null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0,
                null, 1, null, 0, null, 0, null, 1, null, 1, null, 0, null, 1,
                null, 0, null, 0, null, 0, null, 1, null, 1, null, 0, null, 1,
                null, 1, null, 0, null, 0, null, 1, null, 1, null, 1, null, 1,
                null, 0, null, 1, null, 0, null, 0, null, 1, null, 1, null, 1,
                null, 1, null, 0, null, 0, null, 1, null, 0, null, 0
        });

        int result = s.sumRootToLeaf(root);

        assertThat(result, is(292_313_012));
    }

    @Test
    public void ensure_it_works_when_input_is_22_failed() {
        TreeNode exemple1 = TreeNode.of(new Integer[]{
                1, 1, 1, 0, null, 1, null, 1, null, 0, null, 1, null, 0, null,
                0, null, 0, null, 1, null, 0, null, 0, null, 1, null, 0, null,
                0, null, 1, null, 0, 1, 0, null, 1, null, 1, null, 0, null, 0,
                null, 1, null, 1, null, 0, null, 0, 1, 0, null, 1, null, 0,
                null, 1, 1, 1, 0, 0, null, 0, null, 1, 1, 0, null, 1, 0, 1,
                null, 1, null, 1, null, 0, null, 1, null, 0, null, 0, null, 0,
                null, 1, null, 0, null, 1, 0, 0, null, 0, 1, 1, 1, 0, null, 1,
                null, 0, null, 0, null, 0, 1, 0, null, 0, null, 1, null, 1,
                null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, 0, 1,
                null, 1, null, 1, null, 0, null, 0, 0, 1, null, 0, 1, 1, null,
                1, null, 1, null, 0, 1, 0, null, 0, null, 0, 1, 1, 1, 0, 1, 1,
                null, 1, null, 0, 1, 1, 0, 1, null, 0, null, 1, 1, 1, null, 0,
                null, 1, null, 0, null, 0, null, 1, null, 1, null, 0, null, 1,
                null, 1, 1, 1, null, 1, null, 1, 0, 1, 1, 1, null, 1, 0, 0,
                null, 0, 1, 0, null, 1, null, 0, null, 1, null, 1, null, null,
                1, 1, null, 0, null, 1, 1, 0, null, 1, 0, 1, null, 0, null, 0,
                null, 1, null, 1, 0, 1, 0, 1, null, 0, null, 1, 1, 0, 0, 0,
                null, 1, null, 1, null, 1, null, 1, null, 1, null, 0, null, 0,
                null, 1, null, 0, null, 1, null, null, 1, 0, null, 1, null, 0,
                null, 0, null, 0, null, 1, 1, 1, null, 1, null, 1, null, 1,
                null, 1, null, 1, null, 0, null, 1, null, 1, null, 1, null, 1,
                0, 0, null, 0, 0, 1, 1, 1, 0, 0, null, null, 0, null, null, 1,
                null, 0, null, 0, null, 1, null, 1, 0, 1, null, 1, null, 1,
                null, null, null, null, 0, 1, 1, 0, 0, 1, 1, 1, null, null, 1,
                1, 0, 0, null, 0, null, 0, null, 1, null, 0, 0, 0, null, 0, 0,
                0, null, 1, null, 0, 1, 1, 1, 0, 1, 1, null, 0, null, 1, null,
                1, null, 1, 0, 1, null, 0, 1, 0, null, 0, null, 0, 1, 1, null,
                0, 0, 0, null, 0, null, 0, null, 0, null, 0, null, 0, 1, 0,
                null, 0, null, null, 0, 1, null, 0, 0, 0, null, null, null,
                null, 0, 0, null, 0, null, null, null, null, null, 0, 1, 0, 0,
                null, null, 0, 1, 1, null, 0, 0, 1, null, 0, null, 1, 0, 1,
                null, 1, null, 0, 1, 0, null, 1, null, 0, null, 0, 1, 0, null,
                0, null, 0, null, null, null, null, 0, 1, 0, 1, 0, 0, 0, 0,
                null, 1, null, 1, 0, null, null, 0, 1, null, null, 1, null, 0,
                null, 1, null, 0, null, 1, 0, 1, null, 1, null, 1, null, 0,
                null, null, null, null, null, null, null, null, null, null, 1,
                0, null, null, null, null, null, null, null, 0, null, 0, null,
                0, null, null, null, 0, 1, 0, null, 1, 1, 0, null, 1, null, 1,
                1, 0, null, 0, 1, 0, 1, 1, null, null, null, 1, null, 1, null,
                1, 0, 0, 1, 0, null, 0, 0, 1, 1, 0, null, null, null, 0, null,
                1, null, 1, 0, 1, null, 1, 0, 1, null, null, null, 0, null,
                null, null, 0, null, null, null, 0, 0, 1, 0, 1, null, 1, null,
                1, null, 0, null, 1, null, 1, 1, 0, null, 0, null, 0, null, 1,
                null, 1, null, 0, null, null, null, null, null, 0, null, 0,
                null, 1, null, 1, null, 0, null, 1, null, 1, null, null, null,
                0, null, 1, null, 0, null, 0, null, 1, null, 0, null, 0, null,
                0, null, 0, 1, 1, 1, 1, null, 1, null, 1, 0, 0, 1, 1, null, 0,
                0, 1, null, 1, 0, 1, null, 0, null, 1, null, 0, null, 1, null,
                1, null, 1, null, 1, null, null, null, 0, null, 1, null, null,
                1, 0, null, 1, 1, null, null, null, null, null, null, 0, null,
                1, null, null, null, 0, null, 1, null, 1, null, 0, null, 1,
                null, 0, null, 0, 0, 0, null, 0, 1, 0, null, 1, null, null,
                null, 0, null, 1, 0, null, null, 0, 0, 0, null, null, null, 0,
                null, 1, null, 0, 0, 0, null, 1, null, 1, null, 0, null, 0,
                null, 1, null, 0, null, 1, null, 1, 0, 0, null, 1, 1, 1, null,
                1, null, 1, null, 0, null, 0, 0, 1, 1, 1, 0, 0, 1, 0, null, 1,
                1, 0, null, 0, null, 1, null, 0, null, 1, null, null, null, 0,
                null, null, null, 0, null, 0, null, 1, null, null, null, 1, 0,
                0, null, 1, null, null, null, 0, null, 1, null, 1, 0, null,
                null, 1, 0, 1, null, 0, null, 0, 0, 0, null, null, null, null,
                null, 0, null, 1, null, 1, null, 1, null, 0, 0, null, null, 1,
                1, 0, null, null, null, 0, null, 0, null, 0, null, 0, 0, null,
                null, null, null, 1, null, 0, null, 0, 1, 0, null, 0, 0, 1,
                null, 0, null, 1, null, 1, null, 1, null, 1, null, 0, null, 0,
                1, 0, null, 0, 1, 1, null, 1, null, 0, null, 1, null, 1, null,
                0, null, 0, null, 1, 1, 1, null, 0, 0, null, null, 0, 1, 1,
                null, 0, null, null, null, null, null, 1, 0, 1, null, null,
                null, null, null, null, null, 0, null, 1, 1, null, null, null,
                null, 1, 1, 0, null, 0, null, 0, 1, 1, 0, 0, null, 1, 1, 0, 0,
                1, null, 0, null, 1, 0, null, null, null, null, 0, 0, 1, null,
                1, null, null, 0, null, null, 1, 1, 0, 1, 1, null, null, null,
                null, null, 0, null, 1, null, 0, null, null, null, 0, null,
                null, null, 0, 1, null, null, null, null, 0, null, 1, null, 1,
                null, 1, null, 0, 0, 0, 0, 1, null, 1, null, 0, null, 1, null,
                1, null, 0, 1, 1, 0, 1, 0, 1, null, 0, null, 0, null, 0, null,
                0, 0, 0, null, 0, null, 0, 1, 0, null, 0, null, 0, null, 0,
                null, 0, 1, 0, null, null, 1, null, 1, 0, null, null, null, 1,
                null, 0, 1, 0, null, 0, null, 0, 0, 1, null, 1, null, 0, null,
                1, 1, 0, null, 1, null, 1, null, 1, null, 0, null, null, null,
                null, null, null, null, 0, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, 1, null, null, null,
                null, null, null, null, 0, null, 1, 0, 1, null, 0, 0, 1, 0, 0,
                null, 0, 0, 0, 0, 1, null, 1, null, 0, null, 1, null, 1, null,
                1, 0, 1, null, 0, null, 1, null, 0, null, 0, 1, null, null, 0,
                1, 1, null, 0, null, 1, null, null, null, 1, 1, 0, null, 1,
                null, 0, null, 1, null, 1, null, 0, 1, 0, null, null, 0, null,
                null, 0, null, 1, 0, null, null, null, null, 0, null, null, 1,
                null, null, 0, null, 0, null, 1, null, 1, null, 0, null, 0,
                null, 1, null, 0, null, 0, null, null, null, null, null, 0, 1,
                0, null, null, null, 1, null, 0, null, 1, null, 0, null, 1,
                null, 1, 0, 1, null, 1, 0, null, null, 0, null, 0, null, 0,
                null, 0, null, 1, null, 1, 1, 0, null, 0, null, 1, 1, 0, null,
                0, null, 0, null, 1, null, 1, null, 1, 0, 0, null, 1, null, 1,
                null, 1, 1, 1, null, 1, null, 1, null, 0, null, null, null,
                null, null, 0, null, 1, null, 0, 1, 1, 0, 0, null, null, null,
                1, 0, 0, 0, 0, null, null, null, 0, null, null, null, null,
                null, 0, null, 0, null, 0, null, 1, null, 1, null, null, null,
                0, null, 0, 1, null, null, 0, null, 0, null, null, null, null,
                null, null, null, 1, null, null, null, 1, null, 1, null, null,
                null, 0, null, 0, null, null, null, 0, 0, 0, null, null, null,
                null, null, null, null, 1, null, 0, null, null, null, null,
                null, 0, null, 0, null, 0, null, 0, 0, 1, null, 0, null, 1,
                null, 1, 0, 0, null, 0, null, 1, null, 1, null, null, null,
                null, null, 0, null, 1, null, 1, null, null, null, 0, 0, null,
                null, null, null, 1, null, 1, 0, 1, 0, 1, null, 1, 0, 0, null,
                1, 1, 0, null, 1, null, 1, 1, 1, 1, null, 0, 0, null, null,
                null, 0, 0, null, null, 1, null, 0, null, null, null, null,
                null, 1, null, 0, null, null, null, 1, null, 1, null, 0, null,
                null, null, 0, null, 0, null, 1, null, null, null, null, null,
                1, null, 1, null, 0, 1, 0, null, 0, null, 1, null, null, null,
                0, null, null, null, 1, null, 1, null, 1, 1, 1, 1, 0, null,
                null, null, null, null, 1, null, 1, null, null, null, 0, null,
                1, 1, 0, null, null, null, 0, 1, 1, 1, 0, null, 1, null, 0,
                null, 1, null, null, 0, 1, 1, null, null, 0, null, null, null,
                0, null, 1, null, 0, 1, 0, 1, null, null, 1, null, 0, null, 0,
                0, null, null, null, null, null, null, 0, 1, 0, 1, 1, null, 0,
                0, 1, 0, null, null, 1, null, null, null, 1, null, 1, null, 0,
                null, 1, null, 1, null, null, null, 0, null, null, null, null,
                null, null, null, 0, null, 0, null, null, null, null, 0, null,
                null, 1, null, null, 0, 0, null, 0, 1, null, 1, 0, 1, 0, null,
                null, 1, 0, 0, 0, null, 0, null, null, null, 1, null, 1, 0,
                null, null, 0, null, 1, 1, 1, null, null, null, null, null,
                null, null, 0, null, null, null, 1, null, null, null, 0, null,
                0, null, 0, null, null, null, null, null, null, null, 1, null,
                0, null, 1, null, null, null, null, null, null, null, 1, null,
                1, null, 1, 0, 1, 0, 1, null, null, null, 0, null, null, null,
                null, null, null, null, 0, null, null, 1, null, null, 1, null,
                null, null, null, null, null, null, 1, null, 1, null, null,
                null, 1, 1, 0, null, 1, 0, null, null, 1, null, 0, 0, 1, null,
                1, null, null, null, null, 1, null, null, 1, 0, 0, null, null,
                0, 1, null, null, null, 0, null, null, null, 1, 1, 1, null, 0,
                null, 1, 1, 1, null, null, 1, 0, null, null, null, null, 0, 1,
                null, 1, 0, null, null, null, null, 0, null, 0, 0, 0, null,
                null, null, 0, 1, 1, null, 0, null, null, null, null, null, 1,
                null, null, 1, null, null, 1, null, null, null, null, 1, null,
                null, 0, null, 0, 0, 1, null, null, null, null, null, 1, 1,
                null, null, null, null, null, null, null, null, 0, 0, null,
                null, 0, null, null, null, null, null, 0, null, 0, null, 1,
                null, 0, null, 1, null, 0, null, null, null, null, null, null,
                null, null, null, null, null, 1, null, null, null, null, 0,
                null, null, 0, null, 1, null, null, null, null, null, 1, null,
                1, null, 0, null, null, null, 0, null, 1, null, 0, null, null,
                null, null, null, null, 0, null, null, null, 1, null, null, 1,
                null, null, null, null, null, 1, 0
        });

        int result = s.sumRootToLeaf(exemple1);

        assertThat(result, is(113_317_057));
    }
}