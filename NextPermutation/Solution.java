package NextPermutation;

/**
 * Created by Alan on 10/14/14.
 */
public class Solution {
    public static void main(String[] args) {

    }

    public static void nextPermutation(int[] num) {
        int a = num.length - 2;

        while (a >= 0 && num[a] >= num[a + 1]) {
            a--;
        }
        if (a == -1) {
            swap(num, 0, num.length - 1);
            return;
        }

        int b = num.length-1;
        while(num[b] <= num[a]){
            b--;
        }

        int t = num[a];
        num[a] = num[b];
        num[b] = t;

        swap(num, a+1, num.length-1);


    }

    public static void swap(int[] num, int start, int end) {
        /*for (int i = 0; i <= (end - start) / 2; i++) {
            int t = num[end-i];
            num[end -i] = num[start + i];
            num[start + i] = t;
        }*/
        for (int i = start, j = end; i <= j; i++, j--) {
            int t = num[j];
            num[j] = num[i];
            num[i] = t;
        }
    }

}
