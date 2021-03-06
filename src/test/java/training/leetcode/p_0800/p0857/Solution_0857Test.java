package training.leetcode.p_0800.p0857;

import org.junit.Test;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class Solution_0857Test {
    // solution object
    private Solution_0857 s = new Solution_0857();

    @Test
    public void ensure_it_works_when_input_is_1_1_1() {
        double result = s.mincostToHireWorkers(new int[]{1, 1, 2}, new int[]{1, 1, 1}, 2);

        assertThat(result, is(2.0));
    }

    @Test
    public void ensure_it_works_when_input_is_70_50_30() {
        double result = s.mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2);

        assertThat(result, is(105.0));
    }

    @Test
    public void ensure_it_works_when_input_is_4__7() {
        double result = s.mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3);

        assertThat(result, is(closeTo(30.66667, 0.01)));
    }

    @Test
    public void ensure_it_works_when_input_does_not_have_enough_workers() {
        double result = s.mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 7);

        assertThat(result, is(closeTo(-1, 0.01)));
    }

    @Test
    public void ensure_it_works_when_input_does_has_exact_number_of_workers() {
        double result = s.mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 5);

        assertThat(result, is(closeTo(200, 0.01)));
    }

    @Test
    public void ensure_it_works_when_input_does_has_too_many_workers() {
        int[] quality = {192,268,359,111,48,322,170,498,51,147,452,153,12,19,437,437,261,484,401,229,277,306,259,135,268,387,174,9,133,20,204,41,322,182,274,302,296,189,93,187,238,234,41,479,203,192,197,135,133,259,428,405,6,329,13,85,57,132,226,345,137,447,352,129,132,478,4,159,112,71,261,39,231,165,427,260,76,145,419,295,340,233,273,491,77,66,401,486,488,447,240,354,205,413,281,196,485,58,200,142,389,133,361,60,484,39,247,268,112,462,207,81,466,433,106,40,430,82,269,222,457,381,213,3,195,87,218,458,462,256,112,158,81,172,399,367,217,388,352,322,142,39,99,464,240,475,382,453,490,38,246,316,237,13,147,398,256,192,134,88,11,281,229,41,392,487,252,146,294,281,63,168,312,388,203,340,334,134,364,279,450,301,364,252,241,491,216,151,301,343,362,226,325,395,339,260,320,32,137,352,188,328,453,492,19,414,5,250,101,375,301,423,270,60,11,372,18,298,217,203,78,427,57,272,389,494,33,436,217,115,366,498,398,409,210,302,11,28,98,312,470,375,52,304,273,240,218,441,188,101,354,98,298,261,217,125,406,355,317,76,484,292,401,89,234,373,50,227,452,23,445,437,366,477,304,98,447,94,408,451,432,247,204,279,319,138,459,420,337,285,409,217,242,242,413,359,100,58,465,476,80,421,409,40,233,87,90,212,297,169,181,367,348,88,9,144,405,232,292,336,418,83,115,196,135,269,182,120,77,418,107,469,123,266,219,51,208,480,164,177,392,328,419,283,464,257,80,167,418,314,215,192,180,257,321,46,460,87,9,60,257,431,494,344,222,144,265,388,260,434,56,323,184,445,228,326,219,40,2,84,143,489,471,280,33,32,278,25,431,314,480,241,223,286,334,76,271,205,461,202,15,248,462,232,4,237,272,100,93,98,346,233,102,475,51,453,158,99,484,350,174,218,216,110,278,79,24,127,26,350,329,125,386,229,355,257,8,382,251,291,400,400,437,171,478,21,3,303,419,99,5,189,71,247,274,497,163,109,160,117,28,408,84,381,300,81,360,218,145,253,119,75,254,498,139,171,167,415,242,39,222,406,355,97,93,376,61,355,10,499,295,303,90,73,453,114,392,238,43,115};
        int[] wage = {360,268,132,295,144,189,478,104,143,135,427,193,324,11,498,236,227,93,308,295,350,114,288,279,264,48,92,60,81,106,167,98,134,349,366,196,471,449,116,51,395,4,190,109,15,358,347,322,192,98,434,2,334,407,176,42,187,87,67,326,378,288,488,46,369,55,64,203,265,422,246,428,391,415,351,333,426,257,33,35,9,275,334,230,70,412,77,200,388,192,35,269,483,474,456,42,361,402,485,382,500,463,498,184,372,414,204,344,282,342,262,482,479,267,78,68,150,275,158,404,259,195,296,286,253,34,109,490,304,291,291,410,146,28,191,480,61,366,452,337,431,137,470,183,160,195,142,416,144,142,173,145,426,61,103,112,232,445,264,55,500,232,467,351,288,80,88,471,391,126,36,159,465,220,349,278,248,279,208,369,209,477,113,131,215,187,40,108,25,207,318,43,304,294,127,278,339,366,254,241,361,472,490,449,459,212,322,203,150,72,74,121,69,152,129,344,387,158,74,465,71,476,42,378,470,282,375,403,43,426,258,336,420,99,488,114,415,428,79,320,93,422,48,281,43,477,313,79,287,212,108,126,206,166,138,349,366,478,42,235,162,288,76,120,161,322,452,305,320,356,498,19,164,378,488,106,495,411,385,3,227,458,115,473,34,460,370,76,321,260,5,242,96,115,390,222,145,358,67,123,405,183,406,282,18,37,66,406,161,117,227,153,136,39,112,386,296,340,429,2,483,96,381,325,165,141,350,10,458,454,64,107,261,358,462,86,209,285,97,320,77,74,59,138,466,206,332,331,196,216,401,45,364,26,430,378,394,280,389,452,269,102,307,224,299,383,294,203,118,265,343,283,265,100,385,120,361,439,417,298,315,125,463,112,326,129,213,463,286,109,405,35,143,423,179,239,319,404,141,194,126,490,470,492,61,435,372,189,266,27,34,33,36,361,42,493,56,359,46,453,9,426,44,485,81,394,250,465,481,346,240,10,342,419,137,63,453,370,35,232,205,51,292,266,229,172,489,322,309,350,307,209,135,264,124,279,328,282,112,49,264,46,200,169,16,105,154,449,140,175,500,479,157,197,272,84,201,260,327,181,412,495,328,465,146,109,188,58,366,444,238,427,282,230,432,278,249,89,80,91};
        double result = s.mincostToHireWorkers(quality, wage, 25);

        assertThat(result, is(closeTo(1063.5625, 0.01)));
    }

    @Test
    public void ensure_it_works_when_input_does_has_too_many_workers2() throws Exception {
        URI uri = this.getClass().getResource("/p_0800/p0857/large-input.txt").toURI();

        List<String> lines = Files.readAllLines(Paths.get(uri));
        int[] quality = parseIntArray(lines.get(0));
        int[] wage    = parseIntArray(lines.get(1));
        int workers = parseInt(lines.get(2));

        double result = s.mincostToHireWorkers(quality, wage, workers);

        assertThat(result, is(closeTo(67078.64639913525, 0.01)));
    }

    // Expect 113.10714
    @Test
    public void ensure_it_works_when_output_is_113() throws Exception {
        URI uri = this.getClass().getResource("/p_0800/p0857/10.txt").toURI();

        List<String> lines = Files.readAllLines(Paths.get(uri));
        int[] quality = parseIntArray(lines.get(0));
        int[] wage    = parseIntArray(lines.get(1));
        int workers = parseInt(lines.get(2));

        double result = s.mincostToHireWorkers(quality, wage, workers);

        assertThat(result, is(closeTo(113.10714, 0.01)));
    }

    // Expect 113.10714
    @Test
    public void ensure_it_works_when_size_is_175() throws Exception {
        URI uri = this.getClass().getResource("/p_0800/p0857/11.txt").toURI();

        List<String> lines = Files.readAllLines(Paths.get(uri));
        int[] quality = parseIntArray(lines.get(0));
        int[] wage    = parseIntArray(lines.get(1));
        int workers = parseInt(lines.get(2));

        double result = s.mincostToHireWorkers(quality, wage, workers);

        assertThat(result, is(closeTo(38691.27272727273, 0.01)));
    }
    // Expect 113.10714

    @Test
    public void ensure_it_works_when_size_is_7285() throws Exception {
        URI uri = this.getClass().getResource("/p_0800/p0857/12.txt").toURI();

        List<String> lines = Files.readAllLines(Paths.get(uri));
        int[] quality = parseIntArray(lines.get(0));
        int[] wage    = parseIntArray(lines.get(1));
        int workers = parseInt(lines.get(2));

        double result = s.mincostToHireWorkers(quality, wage, workers);

        assertThat(result, is(closeTo(83858002.51784, 0.01)));
    }

    private int[] parseIntArray(String s) {
        s = s.replaceAll("^\\s*\\[", "");
        s = s.replaceAll("]\\s*$", "");
        return Arrays.stream(s.split("\\s*,\\s*")).mapToInt(Integer::valueOf).toArray();
    }
}