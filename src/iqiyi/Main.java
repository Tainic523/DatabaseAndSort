package iqiyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Scanner scanner1 = new Scanner(System.in);
        int a[] = new int[N - 1];
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner1.nextInt();
        }
        int answer = fun(N, a);
        System.out.println(answer);

    }
    private static int fun(int N, int[] a) {
        double answer =0;
        int[]n = new int[N];
        for (int i=1;i<=N;i++){
            n[i-1] =i;
        }
        List<List<Integer>> ans =permute(n);
        for (List<Integer> an :ans){
            boolean b = fun2(an,a);
            if (b) answer++;
        }
        return (int) (answer%(Math.pow(10,9)+7));
    }

    private static boolean fun2(List<Integer> an,int[]a) {
        for (int i=0;i<a.length;i++){
            if (a[i] ==0){
                if (an.get(i)>an.get(i+1)){
                    return false;
                }
            }
            if (a[i]==1){
                if (an.get(i)<an.get(i+1)){
                    return false;
                }
            }
        }
        return true;
    }

    private static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> all=new ArrayList<List<Integer>>();
        allSort(nums, 0, nums.length-1, all);
        return all;
    }
    private static void allSort(int[] array, int begin, int end, List<List<Integer>> all)
    {
        if(begin==end){
            List<Integer> origi=new ArrayList<Integer>();
            for(int a:array)
            {
                origi.add(a);
            }
            all.add(origi);
            return;
        }

        for(int i=begin;i<=end;i++){
            swap(array,begin,i );
            allSort(array, begin+1, end,all);
            swap(array,begin,i );
        }

    }
    private static void swap(int[] array, int a, int b){
        int tem=array[a];
        array[a]=array[b];
        array[b]=tem;
    }

}




