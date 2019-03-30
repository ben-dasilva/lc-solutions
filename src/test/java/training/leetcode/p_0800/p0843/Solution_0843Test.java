package training.leetcode.p_0800.p0843;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class Solution_0843Test {
    public static class DefaultMaster implements Master {
        private String secret;
        Set<String> wordlist;

        private int attempts = 0;
        private boolean found = false;

        public DefaultMaster(String secret, String[] wordlist) {
            this.secret = secret;
            this.wordlist = new HashSet<>(Arrays.asList(wordlist));
        }

        @Override
        public int guess(String word) {
            attempts++;

            if (word.length() != secret.length()) return -1;
            if (!wordlist.contains(word)) return -1;

            int match = 0;

            for (int i = 0; i < secret.length(); i++) {
                if (word.charAt(i) == secret.charAt(i)) match++;
            }

            if (match == secret.length()) found = true;

            return match;
        }

        public int getAttempts() {
            return attempts;
        }

        public boolean isFound() {
            return found;
        }
    }

    // solution object
    private Solution_0843 s = new Solution_0843();

    @Test
    public void ensure_it_works_when_input_is_1() {
        String[] wordlist = {"ccbazz","eiowzz","abcczz", "acckzz"};
        DefaultMaster master = new DefaultMaster("acckzz", wordlist);
        s.findSecretWord(wordlist, master);

        assertThat("Master key was not found", master.isFound(), is(true));
        assertThat(master.getAttempts(), is(lessThan(10)));
    }

    @Test
    public void ensure_it_works_when_input_is_2() {
        String[] wordlist = {"gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos","acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla","ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy","novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp","jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"};
        DefaultMaster master = new DefaultMaster("hbaczn", wordlist);
        s.findSecretWord(wordlist, master);

        assertThat("Master key was not found", master.isFound(), is(true));
        assertThat(master.getAttempts(), is(lessThan(10)));
    }

    @Test
    public void ensure_it_works_when_input_is_3() {
        String[] wordlist = {"eykdft","gjeixr","eksbjm","mxqhpk","tjplhf","ejgdra","npkysm","jsrsid","cymplm","vegdgt","jnhdvb","jdhlzb","sgrghh","jvydne","laxvnm","xbcliw","emnfcw","pyzdnq","vzqbuk","gznrnn","robxqx","oadnrt","kzwyuf","ahlfab","zawvdf","edhumz","gkgiml","wqqtla","csamxn","bisxbn","zwxbql","euzpol","mckltw","bbnpsg","ynqeqw","uwvqcg","hegrnc","rrqhbp","tpfmlh","wfgfbe","tpvftd","phspjr","apbhwb","yjihwh","zgspss","pesnwj","dchpxq","axduwd","ropxqf","gahkbq","yxudiu","dsvwry","ecfkxn","hmgflc","fdaowp","hrixpl","czkgyp","mmqfao","qkkqnz","lkzaxu","cngmyn","nmckcy","alpcyy","plcmts","proitu","tpzbok","vixjqn","suwhab","dqqkxg","ynatlx","wmbjxe","hynjdf","xtcavp","avjjjj","fmclkd","ngxcal","neyvpq","cwcdhi","cfanhh","ruvdsa","pvzfyx","hmdmtx","pepbsy","tgpnql","zhuqlj","tdrsfx","xxxyle","zqwazc","hsukcb","aqtdvn","zxbxps","wziidg","tsuxvr","florrj","rpuorf","jzckev","qecnsc","rrjdyh","zjtdaw","dknezk"};
        DefaultMaster master = new DefaultMaster("cymplm", wordlist);
        s.findSecretWord(wordlist, master);

        assertThat("Master key was not found", master.isFound(), is(true));
        assertThat(master.getAttempts(), is(lessThan(10)));
    }
}