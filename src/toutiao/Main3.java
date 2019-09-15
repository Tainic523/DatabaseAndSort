package toutiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        int[] ans = fun(a);
        for (int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }

    private static int[] fun(int[][] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (map.get(a[i][j]) == null) {
                    int temp = 1;
                    map.put(a[i][j], temp);
                } else {
                    map.put(a[i][j], map.get(a[i][j]) + 1);
                }
            }
        }
        int[] ans = new int[map.size()];
        int i=0;
        while (map.size()!=0){
            int max = Integer.MIN_VALUE;
            int index = -1;
            for (Map.Entry<Integer,Integer> entry:map.entrySet()){
                if (entry.getValue()>max){
                    max = entry.getValue();
                    index = entry.getKey();
                }
            }
            ans[i++] = index;
            map.remove(index);
        }
        return ans;
    }
}
