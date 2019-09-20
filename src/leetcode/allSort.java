package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class allSort {
    public static void main(String[] args) {
        String s= "cba";
        char[] c = s.toCharArray();
//        StringBuffer s = new StringBuffer("cba");
        Arrays.sort(c);
        String ss = new String(c);
        ss.contains(ss);
        System.out.println(ss);
    }
}
