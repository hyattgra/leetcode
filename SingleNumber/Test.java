package SingleNumber;

/**
 * Created by Alan on 9/7/14.
 */
public class Test {
    public static void main(String[] args) {
//        int[] A = {1,2,1,3,3,4,5,6,4,6,5};
//
//        int LEN = A.length - 1;
//        int i, j;
//        for(i=0;i<=LEN-1;i++){
//            for(j=i+1;j<=LEN;j++){
//                if(A[i] != A[j]){
//                    continue;
//                }else{
//                    A[i] = -1;
//                    A[j] = -1;
//                    break;
//                }
//            }
//        }
//
//        for(int n : A){
//            if(n != -1){
//                System.out.print(n);
//            }
//        }

        int[] A = {1,2,1,3,2,4,5,6,4,6,5};
        int x = 0;
        for(int n : A){
            x = x ^ n;
        }
        System.out.print(x);

    }

}
