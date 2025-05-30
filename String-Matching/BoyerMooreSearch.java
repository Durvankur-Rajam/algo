public class BoyerMooreSearch {

    static final int ALPHABET_SIZE = 256; // For extended ASCII

    // The preprocessing function for Bad Character Heuristic
    static void badCharHeuristic(String pat, int[] badChar) {
        int m = pat.length();

        // Initialize all occurrences as -1
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            badChar[i] = -1;
        }

        // Fill the actual value of last occurrence of a character
        for (int i = 0; i < m; i++) {
            badChar[pat.charAt(i)] = i;
        }
    }

    // Function to perform Boyer Moore search
    static void boyerMooreSearch(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        int[] badChar = new int[ALPHABET_SIZE];

        // Preprocess the pattern
        badCharHeuristic(pat, badChar);

        int s = 0; // s is the shift of the pattern with respect to text
        while (s <= (n - m)) {
            int j = m - 1;

            // Keep reducing j while characters match
            while (j >= 0 && pat.charAt(j) == txt.charAt(s + j)) {
                j--;
            }

            // If the pattern is present at current shift
            if (j < 0) {
                System.out.println("Pattern found at index " + s);

                // Shift pattern so next character in text aligns with last occurrence of it in pattern
                // or shift by 1 if no such character
                s += (s + m < n) ? m - badChar[txt.charAt(s + m)] : 1;
            } else {
                // Shift the pattern to align the bad character
                s += Math.max(1, j - badChar[txt.charAt(s + j)]);
            }
        }
    }

    public static void main(String[] args) {
        String txt = "ababcabcabababd";
        String pat = "abab";
        boyerMooreSearch(txt, pat);
    }
}

