package RectangleArea;

/**
 * Created by Alan on 8/20/15.
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (C - A) * (D - B) + (G - E) * (H - F);
        if (overlap(A, C, E, G) > 0 && overlap(B, D, F, H) > 0) {
            total -= overlap(A, C, E, G) * overlap(B, D, F, H);
        }
        return total;
    }

    private int overlap(int s1, int e1, int s2, int e2) {
        if (s2 > e1 || s1 > e2) {
            return 0;
        }
        return Math.min(e1, e2) - Math.max(s1, s2);
    }

}
