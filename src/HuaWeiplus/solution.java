package HuaWeiplus;

import java.util.ArrayList;
import java.util.Scanner;

public class solution {






    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> arrayList=new ArrayList<>();
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            if (s.equals(""))
                break;
            arrayList.add(s);
        }
         ArrayList<String> ans=fun(arrayList);
        for (String ss:ans){
            System.out.println(ss);
        }
    }
    private static ArrayList<String> fun(ArrayList<String> s) {
        ArrayList<String> ans=new ArrayList<>();
        for (int i=0;i<s.size();i++){
            if (!isDuiChen(s.get(i))){
                ans.add("false");
            }else {
                String ss=quchong(s.get(i));
                ans.add(ss);
            }
        }
        return ans;
    }
    private static String quchong(String s) {
        StringBuffer ss=new StringBuffer();
        for (int i=0;i<=(s.length()-2);i=i+2){
            ss.append(s.charAt(i));
        }
        return ss.toString();
    }

    private static boolean isDuiChen(String s) {
        if (s.length()%2==1)
            return false;
        for (int i=0;i<(s.length()/2);i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        for (int i=0;i<(s.length()-2);i=i+2){
            if (s.charAt(i+1)!=s.charAt(i))
                return false;
        }
        return true;
    }
}
