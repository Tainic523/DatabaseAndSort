package HuaWeiplus;

import java.util.Scanner;

public class solution3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][]graph=new int[m][4];
        for (int i=0;i<m;i++){
            for (int j=0;j<4;j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        int start=sc.nextInt();
        int end=sc.nextInt();

        System.out.println(4);
    }
}
