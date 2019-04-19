package ByteDance;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> lists=new ArrayList<>();
        sc.nextLine();
        for (int i=0;i<2*n;i++){
            String[] s=sc.nextLine().split(" ");
            List<Integer> list=new ArrayList<>();
            for (String ss:s){
                list.add(Integer.parseInt(ss));
            }
            lists.add(list);
        }
    }
}
