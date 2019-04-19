package xiecheng;
import java.util.*;
public class Solution {
    static LinkedList<Integer> fun(LinkedList<Integer> list,int k){
        if (list.size()==0|| k>list.size() ) return list;
        int start=0;
        for (int i=0;i<list.size();i++){
            if ((i+1)%k==0){
                reverse(list,start,i);
                start=i+1;
            }
        }
        return list;

    }
    static void reverse(LinkedList<Integer> list,int start,int end){
        for (int i=start,j=end;i<=j;i++,j--){
            int temp1=list.get(i);
            int temp2=list.get(j);
            list.set(i,temp2);
            list.set(j,temp1);

        }
    }
    public static void main(String[] args ){
        Scanner sc1=new Scanner(System.in);
        String s=sc1.nextLine();
        int k=sc1.nextInt();
        String ss=s.substring(1,s.length()-1);
        String[] str=ss.split(",");
        LinkedList<Integer> linkedList=new LinkedList<>();
        for (int i=0;i<str.length;i++){
            linkedList.add(Integer.parseInt(str[i]));
        }
        System.out.println(fun( linkedList, k));
}
}
