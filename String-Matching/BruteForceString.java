  public class BruteForceString {
    public static void bruteForceSearch(String txt, String pat) {
        int n = txt.length();  
        int m = pat.length();

        // Loop through the text
        for (int i = 0; i <= n - m; i++) {
            int j;

            // Check for pattern match
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            // If full pattern was found
            if (j == m) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }

    public static void main(String[] args) {
        String txt = "ababcabcabababd";
        String pat = "abab";
        bruteForceSearch(txt, pat);
    }
}
