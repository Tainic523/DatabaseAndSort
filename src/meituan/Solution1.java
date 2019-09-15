package meituan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution1 {
    static  int fun(int[]a,int[]b){
        int count=0; int index=2;
        for (int i=0;i<a.length;i++){
            for (int j=0;j<b.length;j++){
                if (a[i]==a[j]){
                    int temp=a[i];
                    a[i]=temp;
                    b[j]=b[j];
                    count++;
                }
                else {
                    int temp=a[i];
                    a[i]=temp;
                    b[j]=b[j];
                    count++;
                }
            }
        }
        return index;
    }


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []a=new int[n-1];
        int []b=new int[n];
        for (int i=0;i<n-1;i++){
            a[i]=sc.nextInt();
        }
        for (int i=0;i<n;i++){
            b[i]=sc.nextInt();
        }

        System.out.println(fun(a,b));
    }

}
