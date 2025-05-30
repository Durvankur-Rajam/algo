public class KMPStringMatch {

    // Function to compute LPS (Longest Prefix Suffix) array
    public static void computeLPSArray(String pat, int[] lps) {
        int m = pat.length();
        int len = 0;  // length of the previous longest prefix suffix
        int i = 1;

        lps[0] = 0;  // LPS of first character is always 0

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];  // backtrack
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // KMP search algorithm
    public static void KMPSearch(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        int[] lps = new int[m];
        computeLPSArray(pat, lps);

        int i = 0; // index for txt
        int j = 0; // index for pat

        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];  // Continue to search for next match
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];  // Use LPS to skip characters
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String txt = "ababcabcabababd";
        String pat = "abab";
        KMPSearch(txt, pat);
    }
}

