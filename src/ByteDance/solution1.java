package ByteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class solution1 {
    static int fun(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int res = 0;
        boolean[][] visited = new boolean[n][m];
        while (true) {
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == 2 && !visited[i][j]) {
                        visited[i][j] = true;
                        if (i != 0) {
                            if (a[i - 1][j] == 1) {
                                a[i - 1][j] = 2;
                                flag = true;
                            }
                        }
                        if (j != 0) {
                            if (a[i][j - 1] == 1) {
                                a[i][j - 1] = 2;
                                flag = true;
                            }
                        }
                        if (j != m - 1) {
                            if (a[i][j + 1] == 1) {
                                a[i][j + 1] = 2;
                                flag = true;
                            }
                        }
                        if (i != n - 1) {
                            if (a[i + 1][j] == 1) {
                                a[i + 1][j] = 2;
                                flag = true;
                            }
                        }
                    }

                }
            }
            if (flag) {
                res++;
            }
            return res == 0 ? -1 : res;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.equals("")) {
                break;
            }
            String[] temp = s.split(" ");
            List<Integer> a = new ArrayList<>();
            for (String ss : temp) {
                a.add(Integer.parseInt(ss));
            }
            list.add(a);
        }
        int n = list.size();
        int m = list.get(0).size();
        int[][] num = new int[n][m];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                num[i][j] = list.get(i).get(j);
            }
        }
        System.out.println(fun(num));

    }
}

