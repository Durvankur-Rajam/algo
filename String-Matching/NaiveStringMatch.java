public class NaiveStringMatch {

    public static void naiveSearch(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        // Slide the pattern one by one over the text
        for (int i = 0; i <= n - m; i++) {
            int j;

            // For current index i, check for pattern match
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            // If pat[0...m-1] = txt[i...i+m-1]
            if (j == m) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }

    public static void main(String[] args) {
        String txt = "ababcabcabababd";
        String pat = "abab";
        naiveSearch(txt, pat);
    }
}

