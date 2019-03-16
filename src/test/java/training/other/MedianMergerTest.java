package training.other;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import training.other.MedianMerger;

public class MedianMergerTest {
    private MedianMerger medianMerger;

    @Before
    public void setUp() throws Exception {
        medianMerger = new MedianMerger();
    }

    @Test
    public void ensure_negative_1_1_2_3_works() {
        double median = medianMerger.findMedianSortedArrays(0, new int[]{1, 2}, new int[]{-1, 3});

        Assert.assertEquals(1.5, median, 0.001);
    }

    @Test
    public void ensureSingleAndEmptyValuesWork() {
        double median = medianMerger.findMedianSortedArrays(0, new int[]{1}, new int[]{});

        Assert.assertEquals(1, median, 0.001);
    }

    @Test
    public void ensureEmptyAndSingleValuesWork() {
        double median = medianMerger.findMedianSortedArrays(0, new int[]{}, new int[]{1});

        Assert.assertEquals(1, median, 0.001);
    }

    @Test
    public void ensureTwoLargerEvenNumberOfElementsWork() {
        double median = medianMerger.findMedianSortedArrays(0, new int[]{0, 0}, new int[]{1, 1, 2, 5, 5, 5});

        Assert.assertEquals(1.5, median, 0.001);
    }

    @Test
    public void ensureTwoLargerOddNumberOfElementsWork() {
        double median = medianMerger.findMedianSortedArrays(0, new int[]{0, 0}, new int[]{1, 1, 2, 5, 5, 5, 5});

        Assert.assertEquals(2, median, 0.001);
    }

    @Test
    public void ensureTwoSingleElementsWork() {
        double median = medianMerger.findMedianSortedArrays(0, new int[]{100000}, new int[]{100001});

        Assert.assertEquals(100000.5, median, 0.001);
    }
}