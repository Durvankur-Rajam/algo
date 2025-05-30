public class RabinKarpSearch {
    public final static int d = 256; // number of characters in the input alphabet
    public final static int q = 101; // A prime number (used as modulus for hashing)

    public static void rabinKarpSearch(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt window
        int h = 1;

        // The value of h would be "pow(d, m-1)%q"
        for (int i = 0; i < m - 1; i++)
            h = (h * d) % q;

        // Calculate hash value for pattern and first window of text
        for (int i = 0; i < m; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= n - m; i++) {
            // Check the hash values of current window of text and pattern
            if (p == t) {
                // If the hash values match, check for characters one by one
                int j;
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

                // If p == t and pat[0...m-1] = txt[i...i+m-1]
                if (j == m)
                    System.out.println("Pattern found at index " + i);
            }

            // Calculate hash value for next window of text
            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;

                // We might get negative value of t, converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }
    }

    public static void main(String[] args) {
        String txt = "ababcabcabababd";
        String pat = "abab";
        rabinKarpSearch(txt, pat);
    }
}

