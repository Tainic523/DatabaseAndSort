package bilibili;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int ans = fun(s1,s2);
        System.out.println(ans);
    }

    private static int fun(String s1, String s2) {
        s1=s1.replaceAll(" ","");
        s2 = s2.replaceAll(" ","");
        if (s1.length() ==0 ){
            return s2.length();
        }
        if (s2.length() ==0){
            return s1.length();
        }
        if (s1.length() == s2.length()){
            int ans = 0 ;
            for (int i=0;i<s1.length();i++){
                if (s1.charAt(i) != s2.charAt(i)){
                    ans++;
                }
            }
            return ans;
        }
        // 数量不一样长的时候 求最长公共子串
        int length = fun2(s1,s2);
        if (length!=0){
            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            for (int i=0;i<s1.length();i++){
                set1.add(s1.charAt(i));
            }
            for (int i=0;i<s2.length();i++){
                set2.add(s2.charAt(i));
            }
            set1.retainAll(set2);
            return Math.max(s1.length(),s2.length()) - set1.size();
        }
        return Math.max(s1.length(),s2.length())-length;
    }

    private static int fun2(String s1, String s2) {
        s1=s1.replaceAll(" ","");
        s2 = s2.replaceAll(" ","");
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int temp[][] = new int[str1.length][str2.length];
        int length = 0;
        for (int i=0;i<str1.length;i++){
            for (int j=0;j<str2.length;j++){
                if (str1[i] == str2[j]){
                    if (i>0 && j>0){
                        temp[i][j] = temp[i-1][j-1]+1;
                    }else {
                        temp[i][j] =1;
                    }

                    if (temp[i][j]>length){
                        length = temp[i][j];
                    }
                }else {
                    temp[i][j] =0;
                }
            }
        }
        return length;
    }
}
