package meituan;

import java.util.*;

public class Solution {
    public static int fun(ArrayList<Integer> ans,int[][]a,int n,int m){
        int min=1000000;
        if (ans.size()==1) return (n*m)/2;
            int black=ans.get(0);
            int white=ans.get(1);
            int count1=fun1(a,n,m,black,white);
            int count2=fun1(a,n,m,white,black);
            int count=count1>count2 ? count2:count1;
            if (count<min){
                min=count;
            }
             return min;
    }
    static int fun1(int[][]a,int n,int m,int black,int white){
        int count=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if ((i+j)%2==0){
                    if (a[i][j]!=black){
                        count++;
                    }
                }
                else {
                    if (a[i][j]!=white){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ans =new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][]a=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                int temp=sc.nextInt();
                a[i][j]=temp;
                if (map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                }
                else map.put(temp,1);
            }
        }
        int max1=0,max2=0;int index=0;
        for (Integer i:map.keySet()){
            if (map.get(i)>max1) {
                max1=map.get(i);
                index=i;
             }
        }
        ans.add(index);
        for (Integer i:map.keySet()){
            if (map.get(i)>max2 && map.get(i)!=max1 ){
                max2=map.get(i);
                index=i;
            }

        }
        ans.add(index);

        System.out.println(fun(ans,a,n,m));

        }
    }



