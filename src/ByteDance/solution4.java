package ByteDance;

import java.util.*;
public class solution4 {
    private static int ans = Integer.MAX_VALUE;

    static int fun(int[][] weight) {
        int n = weight.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            fun1(weight, visited, n, i, i, 1, 0);
        }
        return ans;
    }

    static void fun1(int[][] weight, boolean[] visited, int n, int s, int start, int count, int price) {
        if (count == n) {
            price += weight[s][start];
            if (ans > price) ans = price;
        } else {
            for (int i = 0; i < n; i++) {
                if (i == s || visited[i]) {
                    continue;
                }
                visited[i] = true;
                price += weight[s][i];
                count++;

                fun1(weight, visited, n, i, start, count, price);

                visited[i] = false;
                price -= weight[s][i];
                count--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(fun(a));
    }
}

