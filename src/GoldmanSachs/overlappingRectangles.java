package GoldmanSachs;

// https://practice.geeksforgeeks.org/problems/overlapping-rectangles1924/1/
public class overlappingRectangles {
    public static void main(String[] args) {
        int[] L1={0,2}, R1={1,1}, L2={-2,-3}, R2={0,2};
        System.out.println(doOverlap(L1, R1, L2, R2));
    }

    public static int doOverlap(int L1[], int R1[], int L2[], int R2[]) {

        if(L1[0]>R2[0] || L2[0]>R1[0]) {
            return 0;
        }

        if(L1[1]<R2[1] || L2[1]<R1[1]) {
            return 0;
        }
        return 1;
    }
}
