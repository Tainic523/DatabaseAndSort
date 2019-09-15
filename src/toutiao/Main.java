package toutiao;


import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    if (n<=0){
        return;
    }
    int a[] = new int[n];
//    Scanner scanner1 = new Scanner(System.in);
    for (int i=0;i<n;i++){
        a[i] = scanner.nextInt();
    }
    int ans = fun(n,a);
        System.out.println(ans);
}

    private static int fun(int n, int[] a) {
        int score[] = new int[n];
        for (int i=0;i<score.length;i++){
            score[i]=0;
        }
        for (int i=a.length-1;i>=1;i--){
            for (int j=i-1;j>=0;j--){
                if (a[j]>=a[i]){
                    int temp = score[j];
                    temp++;
                    score[j]=temp;
                    break;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int ans = -1;
        for (int i=0;i<score.length;i++){
            if (score[i]>max){
                max = score[i];
                ans = a[i];
            }
        }
        return ans;
    }
}
