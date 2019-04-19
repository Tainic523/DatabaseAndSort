package ByteDance;

import java.util.Scanner;

public class solution3 {
    static int fun(int[] a) {
        if (a.length == 1) return a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min)
                min = a[i];
        }
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        int i = min;
        while (i < 2 * max) {
            int e = i;
            for (int j = 0; j < a.length; j++) {
                if (e < a[j])
                    e = e - Math.abs(e - a[j]);

                else e = e + Math.abs(e - a[j]);
                if (e < 0) {
                    i++;
                    break;
                }
            }
            if (e == 0)
                break;
        }
        return i;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.print(fun(a));

    }
}
