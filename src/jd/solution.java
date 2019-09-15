package jd;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class solution {
    static boolean isRepeat(String s,int left, int right){
        Set<Character> set = new HashSet<>();
        for(int i= left;i<=right;i++){
            if(!set.contains(s.charAt(i))){
               set.add(s.charAt(i));
            }else{
                return true;
            }
        }
        return false;
    }
    static int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        int left = 0;
        int right =0;
        int max=0;
        for (int i=0;i<s.length();i++){
            if (!isRepeat(s,left,i)){
                right=i;
            }else{
                for (int j=left;j<=i;j++){
                    if (!isRepeat(s,j,i)){
                        left=j;
                        break;
                    }
                }
            }
            max = right-left+1>max ? right-left+1:max;
        }
        return max;
    }
    static float fun(int[]a){
        int m=a.length;
        float ans=0;
        int max=Integer.MIN_VALUE;
        for (int anA : a) {
            if (anA > max)
                max = anA;
        }
        for (int i=1;i<=max;i++){
            ans+=i*fun1(i,a);
        }
        return ans;
    }
    private static float fun1(int i, int[] a) {
        float ans =1;
        for (int j=0;j<a.length;j++){
            if (i<=a[j]){
                ans*=Math.floorDiv((1+a[j]-i),a[j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
       Scanner scanner = new Scanner(System.in);
       int[]s=new int[m];
        for (int i = 0; i < m-1;i++ ) {
            s[i] = scanner.nextInt();
        }
        float ans = fun(s);
        System.out.println(ans);

    }
}
