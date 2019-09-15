package huya;
import java.util.*;
public class Solution1 {
    public static ArrayList<String> fun(ArrayList<String> ans){
        ArrayList<String> a=new ArrayList<>();
        for (int i=0;i<ans.size();i++){
            String temp=ans.get(i).trim();
            StringBuffer s=new StringBuffer();
            for (int j=0;j<temp.length();j++){
                s.append(temp.charAt(i));
                if (j==5)
                    s.append(" ");
                if (j==13)
                    s.append(" ");
            }
            a.add(s.toString());
        }
            return a;
    }
    public static void main(String[] args) {
    ArrayList<String> ans =new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    while (sc.hasNextLine()){
        String s = sc.nextLine();
        ans.add(s);
    }
    ArrayList<String> a=fun(ans);
    System.out.println(a);
    }
}
