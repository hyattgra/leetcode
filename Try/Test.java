package Try;

import java.util.Arrays;

/**
 * Created by Alan on 9/16/14.
 */
public class Test {

    public static void main(String[] args) {

        System.out.println(find(100));

    }

    public static int find(int n){
        int[] dyn = new int[n + 1];
        Arrays.fill(dyn, 0);
        dyn[0] = 1;
        for (int i = 1;  i <= n; i++) dyn[i] += dyn[i - 1];
        for (int i = 5;  i <= n; i++) dyn[i] += dyn[i - 5];
        for (int i = 10; i <= n; i++) dyn[i] += dyn[i - 10];
        for (int i = 25; i <= n; i++) dyn[i] += dyn[i - 25];
        return dyn[n];

    }

//    public static int find(int n, int m){
//        int[] coins = {1,5,10,25};
//        if(){
//
//        }
//
//    }
}
