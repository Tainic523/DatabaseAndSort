package yuanfudao;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[]a =new int[n];
        for (int i=0;i<n;i++){
            a[i] = scanner.nextInt();
        }
        int ans = fun(a,s);
        System.out.println(ans);
    }

    private static int fun(int[] a, int s) {
        int ans = Integer.MIN_VALUE;
    for (int i=0;i<a.length;i++){
        int count =a[i];
        for (int j=i+1;j<a.length;j++){
            count+=a[j];
            if (count>s){
                int temp = j-i;
                if (temp>ans)
                    ans = temp;
                break;
            }
        }
    }
    return ans;
    }

    private static int fun2(int[] a, int left, int right) {
        int ans =0;
        for (int i=left;i<=right;i++){
            ans+=a[i];
        }
        return ans;
    }
}
