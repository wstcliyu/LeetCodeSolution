// Approach #1 Brute Force [Time Limit Exceeded]
// Time: O(3^n)
// Space: O(n^n)
public class Solution {
    int count,M=1000000007;
    public int checkRecord(int n) {
        count = 0;
        gen("", n);
        return count;
    }
    public void gen(String s, int n) {
        if (n == 0 && checkRecord(s))
            count=(count+1)%M;
        else if (n > 0) {
            gen(s + "A", n - 1);
            gen(s + "P", n - 1);
            gen(s + "L", n - 1);
        }
    }
    public boolean checkRecord(String s) {
        int count = 0;
        for (int i = 0; i < s.length() && count < 2; i++)
            if (s.charAt(i) == 'A')
                count++;
        return s.length() > 0 && count < 2 && s.indexOf("LLL") < 0;
    }
}




// Approach #2 Using Recursive formulae [Time Limit Exceeded]
// Time: O(2^n)
// Space: O(n)
public class Solution {
    int M=1000000007;
    public int checkRecord(int n) {
        int[] f =new int[n+1];
        f[0]=1;
        for(int i=1;i<=n;i++)
            f[i]=func(i);
        int sum=func(n);
        for(int i=1;i<=n;i++){
            sum+=(f[i-1]*f[n-i])%M;
        }
        return sum%M;
    }
   public int func(int n)
   {    
       if(n==0)
            return 1;
        if(n==1)
            return 2;
        if(n==2)
            return 4;
        if(n==3)
            return 7;
        return (2*func(n-1) - func(n-4))%M;
   }
}




// Approach #3 Using Dynamic Programming [Accepted]
// Time: O(n)
// Space: O(n)
public class Solution {
    long M = 1000000007;
    public int checkRecord(int n) {
        long[] f = new long[n <= 5 ? 6 : n + 1];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;
        for (int i = 4; i <= n; i++)
            f[i] = ((2 * f[i - 1]) % M + (M - f[i - 4])) % M;
        long sum = f[n];
        for (int i = 1; i <= n; i++) {
            sum += (f[i - 1] * f[n - i]) % M;
        }
        return (int)(sum % M);
    }
}




// Approach #4 Dynamic Programming with Constant Space [Accepted]
// Time: O(n)
// Space: O(1)
public class Solution {
    long M = 1000000007;
    public int checkRecord(int n) {
        long a0l0 = 1;
        long a0l1 = 0, a0l2 = 0, a1l0 = 0, a1l1 = 0, a1l2 = 0;
        for (int i = 0; i < n; i++) {
            long new_a0l0 = (a0l0 + a0l1 + a0l2) % M;
            long new_a0l1 = a0l0;
            long new_a0l2 = a0l1;
            long new_a1l0 = (a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % M;
            long new_a1l1 = a1l0;
            long new_a1l2 = a1l1;
            a0l0 = new_a0l0;
            a0l1 = new_a0l1;
            a0l2 = new_a0l2;
            a1l0 = new_a1l0;
            a1l1 = new_a1l1;
            a1l2 = new_a1l2;
        }
        return (int)((a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % M);
    }
}




// Approach #5 Using less variables [Accepted]
// Time: O(n)
// Space: O(1)
public class Solution {
    long M = 1000000007;
    public int checkRecord(int n) {
        long a0l0 = 1, a0l1 = 0, a0l2 = 0, a1l0 = 0, a1l1 = 0, a1l2 = 0;
        for (int i = 0; i <= n; i++) {
            long a0l0_ = (a0l0 + a0l1 + a0l2) % M;
            a0l2 = a0l1;
            a0l1 = a0l0;
            a0l0 = a0l0_;
            long a1l0_ = (a0l0 + a1l0 + a1l1 + a1l2) % M;
            a1l2 = a1l1;
            a1l1 = a1l0;
            a1l0 = a1l0_;
        }
        return (int) a1l0;
    }
}