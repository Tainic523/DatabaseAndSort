package yuanfudao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [][]a = new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                a[i][j] = scanner.nextInt();
            }
        }
        ArrayList<Integer> arrayList  = fun(a);
        for (Integer aa: arrayList
             ) {
            System.out.print(aa+" ");
        }
    }

    private static ArrayList<Integer> fun(int[][]a) {
        ArrayList<Integer> res = new ArrayList<>();
        int row = a.length;
        int col = a[0].length;
        if (row==0 || col==0)
            return res;
            int left = 0 , right = col-1, bottom = row-1, top = 0;
            while (left<=right && top<=bottom){
                for (int i=top;i<=bottom;++i)
                    res.add(a[i][left]);
                for (int i=left+1;i<=right;++i)
                    res.add(a[bottom][i]);
                if (left!=right){
                    for (int i=bottom-1; i>=top; --i)
                        res.add(a[i][right]);
                }
                if (top!=bottom){
                    for (int i=right-1;i>=left+1;--i)
                        res.add(a[top][i]);
                }
                left++;right--;top++;bottom--;

            }
            return res;

    }
}
