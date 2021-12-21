// Textbook Addition
class Solution {
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || sum > 0) {
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            result.append(sum % 2);
            sum /= 2;
        }
        return result.reverse().toString();
    }
}




// Bit Manipulation
import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            // x + y == x^y + (x&y)<<1
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }
}




// Notes about Integer and BigInteger

BigInteger bi = new BigInteger(String val, int radix)
int intV = bi.intValue()
long longV = bi.longValue()
String val = bi.toString(int radix)

Integer in = Integer.valueOf(int i)
Integer in = Integer.valueOf(String s)
Integer in = Integer.valueOf(String s, int radix)
int intV = in.intValue()
long longV = in.longValue()
String s = in.toString()
String s = Integer.toString(int i)
String s = Integer.toString(int i, int radix)
