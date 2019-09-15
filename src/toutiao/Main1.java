package toutiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    public static HashMap<String, String> map = new HashMap<>();
    public static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("5", "E");
        map.put("6", "F");
        map.put("7", "G");
        map.put("8", "H");
        map.put("9", "I");
        map.put("10", "J");
        map.put("11", "K");
        map.put("12", "L");
        map.put("13", "M");
        map.put("14", "N");
        map.put("15", "O");
        map.put("16", "P");
        map.put("17", "Q");
        map.put("18", "R");
        map.put("19", "S");
        map.put("20", "T");
        map.put("21", "U");
        map.put("22", "V");
        map.put("23", "W");
        map.put("24", "X");
        map.put("25", "Y");
        map.put("26", "Z");
        for (int i = 1; i <= 26; i++) {
            set.add(String.valueOf(i));
        }
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ArrayList<ArrayList<String>> temp = fun(s);
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (ArrayList<String> aa : temp) {
            ArrayList<String> a = fun2(aa);
            ans.add(a);
        }
        for (ArrayList<String> aa : ans) {
            for (String ss : aa) {
                System.out.print(ss);
            }
            System.out.println("");
        }

    }

    // 转变数组为字母
    private static ArrayList<String> fun2(ArrayList<String> aa) {
        ArrayList<String> ans = new ArrayList<>();
        for (String s : aa) {
            ans.add(map.get(s));
        }
        return ans;
    }

    // 找出所有排列
    private static ArrayList<ArrayList<String>> fun(String s) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        fun3(ans, temp, s, 0);
        return ans;
    }

    private static void fun3(ArrayList<ArrayList<String>> ans, ArrayList<String> ss, String s, int i) {
        if (i >= s.length() - 1) {
            if (i == s.length() - 1) {
                ss.add(String.valueOf(s.charAt(i)));
            }
            ArrayList<String> te = new ArrayList<>(ss);
            ans.add(te);
            ss.clear();
            return;
        }
        if (s.charAt(i) != '1' && s.charAt(i) != '2') {
            ss.add(String.valueOf(s.charAt(i)));
            fun3(ans, ss, s, i + 1);
        } else {
            ArrayList<String> s2 = new ArrayList<>(ss);
            ss.add(String.valueOf(s.charAt(i)));
            fun3(ans, ss, s, i + 1);
            String temp = String.valueOf(s.charAt(i)) +
                    String.valueOf(s.charAt(i + 1));
            s2.add(temp);
            fun3(ans, s2, s, i + 2);
        }
    }

}
