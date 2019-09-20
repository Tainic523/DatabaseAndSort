package leetcode;

import java.util.Scanner;

public class solution {
    public static void main(String[] args) { // 回文子串的数目
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int ans = countSubstrings(s);
        System.out.println(ans);
    }
        static int num =0;
    public static int countSubstrings(String s){
        for (int i=0;i<s.length();i++){
            count(s,i,i);
            count(s,i,i+1);
        }
        return num;
    }
    public  static void count(String s,int start,int end){
        while (start>=0&& end<s.length() && s.charAt(start)==s.charAt(end)){
            num++;
            start--;
            end++;
        }
    }
}
