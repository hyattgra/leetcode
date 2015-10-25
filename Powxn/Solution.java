package Powxn;

/**
 * Created by Alan on 11/8/14.
 */
public class Solution {
    public static void main(String[] args) {

    }

    public double pow(double x, int n) {
        double temp = x;
        if (n == 0) {
            return 1;
        }
        temp = pow(x, n / 2);
        if (n % 2 == 0)
            return temp * temp;
        else {
            if (n > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }
}
