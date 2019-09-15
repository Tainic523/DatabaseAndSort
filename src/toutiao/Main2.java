package toutiao;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int a[][] = new int[M][2];
        for (int i=0;i<2*M;i++){

            if (i%2==0){
                a[i/2][0] = scanner.nextInt();
            }
            if (i%2==1){
                a[(i-1)/2][1] = scanner.nextInt();
            }
        }
        int ans = fun(N,a);
        System.out.println(ans);
    }

    private static int fun(int n, int[][] a) {
        int temp[] = new int[n];
        for (int i=0;i<n;i++){
            temp[i]=0;
        }

        for (int i=0;i<a.length;i++){
            int begin = a[i][0];
            int end = a[i][1];
            increment(temp,begin,end);
        }
        int ans = 0;
        for (int i=0;i<n;i++){
            if (temp[i]%2==1){
                ans++;
            }
        }
        return ans;

    }

    private static void increment(int[] temp, int begin, int end) {
        for (int i=begin;i<=end;i++){
            int tem = temp[i];
            tem++;
            temp[i] = tem;
        }
    }
}
