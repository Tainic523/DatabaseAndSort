package leetcode;

import java.util.*;

public class solution1 {
    public static Map<String,String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("1","壹");
        map.put("2","贰");
        map.put("3","叁");
        map.put("4","肆");
        map.put("5","伍");
        map.put("6","陆");
        map.put("7","柒");
        map.put("8","捌");
        map.put("9","玖");
        map.put("0","零");
        map.put("10","十");
        map.put("100","百");
        map.put("1000","千");
        map.put("10000","万");
        map.put("100000000","亿");

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ArrayList<String> ans = fun(s);
        System.out.println(ans.toString());
        ArrayList<String> res = new ArrayList<>();
        for (String ss: ans
             ) {
            String tran = fun2(ss);
            res.add(tran);

        }
        System.out.println(res.toString());
        // ["200.00","201.15","1015","200001010200"]
    }

    private static String fun2(String ss) {

        return null;
    }

    private static ArrayList<String> fun(String s) {
        ArrayList<String> ans = new ArrayList<>();
        String temp = s.substring(1,s.length()-1);
        String temp1=temp.replaceAll("\"","");
        String[] nums = temp1.split(",");
        for (String num: nums
             ) {
            ans.add(num);
        }
        return ans;
    }
}
