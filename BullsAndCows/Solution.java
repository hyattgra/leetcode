package BullsAndCows;

/**
 * Created by Alan on 12/9/2015.
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int[] secrets = new int[10];
        int[] guesses = new int[10];
        int bull = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                secrets[secret.charAt(i) - '0']++;
                guesses[guess.charAt(i) - '0']++;
            }
        }//

        for (int i = 0; i < secrets.length; i++) {
            cows += guesses[i] >= secrets[i] ? secrets[i] : guesses[i];
        }
        return bull + "A" + cows + "B";
    }
}
