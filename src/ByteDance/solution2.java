package ByteDance;

import java.util.ArrayList;
import java.util.Scanner;

public class solution2 {
    private static ArrayList<ArrayList<int[]>> list = new ArrayList<>();

    static int fun(int listIndex) {
        int max = 0;
        int sum;
        boolean flag;
        for (int index = 0; index < list.get(listIndex).size(); index++) {
            int[] array = list.get(listIndex).get(index);
            sum = 0;
            for (int i = listIndex; i < list.size(); i++) {
                flag = false;
                for (int[] testArrays : list.get(i)) {
                    if (testArrays[0] == array[0] && testArrays[1] == array[1]) {
                        flag = true;
                        sum++;
                        break;
                    }
                }
                if (!flag)
                    break;
            }
            max = sum > max ? sum : max;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            int len = sc.nextInt();
            for (int i = 0; i < len; i++) {
                ArrayList<int[]> temp = new ArrayList<>();
                int p = sc.nextInt();
                for (int j = 0; j < p; j++) {
                    int[] a = new int[2];
                    a[0] = sc.nextInt();
                    a[1] = sc.nextInt();
                    temp.add(a);
                }
                list.add(temp);
            }
            int max = 0;
            for (int i = 0; i < len; i++) {
                int t = fun(i);
                if (t > max)
                    max = t;
            }
            System.out.println(max);
            n--;
        }
    }
}

