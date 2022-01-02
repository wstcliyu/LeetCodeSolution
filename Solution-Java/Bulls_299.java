// My one pass solution
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            if (cs == cg) {
                bulls++;
            } else {
                if (count[cs - '0']++ < 0) cows++;
                if (count[cg - '0']-- > 0) cows++;
            }
        }

        return bulls + "A" + cows + "B";
    }
}