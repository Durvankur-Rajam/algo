public class KaratsubaMultiplication {

    // Multiply two large numbers represented as strings
    public static String multiply(String num1, String num2) {
        // Base case for recursion
        if (num1.length() == 1 && num2.length() == 1) {
            int product = (num1.charAt(0) - '0') * (num2.charAt(0) - '0');
            return Integer.toString(product);
        }

        // Make lengths equal by padding zeros
        int maxLen = Math.max(num1.length(), num2.length());
        if (maxLen % 2 != 0) maxLen++; // make even length for easy splitting

        num1 = padLeftZeros(num1, maxLen);
        num2 = padLeftZeros(num2, maxLen);

        int n = maxLen;
        int half = n / 2;

        // Split numbers into two halves
        String a = num1.substring(0, half);
        String b = num1.substring(half);
        String c = num2.substring(0, half);
        String d = num2.substring(half);

        // Recursively calculate ac, bd, and (a+b)*(c+d)
        String ac = multiply(a, c);
        String bd = multiply(b, d);
        String aPlusb = addStrings(a, b);
        String cPlusd = addStrings(c, d);
        String abcd = multiply(aPlusb, cPlusd);

        // Compute (a+b)*(c+d) - ac - bd
        String adbc = subtractStrings(subtractStrings(abcd, ac), bd);

        // Shift ac by 2 * half digits, adbc by half digits
        String acShift = ac + zeros(2 * half);
        String adbcShift = adbc + zeros(half);

        // Result = acShift + adbcShift + bd
        String result = addStrings(addStrings(acShift, adbcShift), bd);

        // Remove leading zeros
        return stripLeadingZeros(result);
    }

    // Helper to add two number strings
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }

        return sb.reverse().toString();
    }

    // Helper to subtract two number strings (num1 >= num2)
    public static String subtractStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int borrow = 0, i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0) {
            int x = num1.charAt(i) - '0' - borrow;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;

            if (x < y) {
                x += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            sb.append(x - y);
            i--;
            j--;
        }

        // Remove leading zeros
        return stripLeadingZeros(sb.reverse().toString());
    }

    // Pad a string with leading zeros to the left until it reaches length n
    public static String padLeftZeros(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i < n; i++)
            sb.append('0');
        sb.append(s);
        return sb.toString();
    }

    // Generate a string of zeros of length n
    public static String zeros(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append('0');
        return sb.toString();
    }

    // Remove leading zeros from a string number
    public static String stripLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0')
            i++;
        return s.substring(i);
    }

    // Main method to test
    public static void main(String[] args) {
        String num1 = "3141592653589793238462643383279502884197169399375105820974944592";
        String num2 = "2718281828459045235360287471352662497757247093699959574966967627";

        String product = multiply(num1, num2);
        System.out.println("Product:\n" + product);
    }
}
