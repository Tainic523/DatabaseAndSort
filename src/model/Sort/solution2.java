package model.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class solution2 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res=new ArrayList<>();
        ArrayList<Integer> ress=new ArrayList<>();

        if(input!=null && k<=input.length){
            for (Integer i:input
                 ) {res.add(i);
            }
            Collections.sort(res);
            for(int i=0;i<k;i++){
                ress.add(res.get(i));
            }
            return ress;
        }
        return ress;

    }

    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        if(array.length>0 && array!=null){
            int i;
            for (i=0;i< array.length;i++){
                if (hm.containsKey(array[i])){
                    int temp=hm.get(array[i]);
                    hm.put(array[i],temp+1);
                }
                else hm.put(array[i],1);
            }

        }
        for (Integer value:hm.keySet()
             ) { if (hm.get(value)>=array.length/2)
                 return value;
        }
         return 0;
    }
    public int[] multiply(int[] A) {// 构建乘法数组
        if (A==null) return null;
        int[] ans=new int[A.length];
        int[] left=new int[A.length];
        int[] right=new int[A.length];
        left[0]=1;right[A.length-1]=1;
        for (int i=1;i<left.length;i++){
            left[i]=left[i-1]*A[i-1];
        }
        for (int i=right.length-2;i>=0;i--){
            right[i]=right[i+1]*A[i+1];
        }
        for (int i=0;i<A.length;i++){
            ans[i]=left[i]*right[i];
        }
        return ans;
    }

    /* 讨论2种：先看 * 再看 匹配
     * 前提：当pattern遍历完，return取决于str是否遍历完，str恰好遍历完才返回true，再接下来讨论
     *  1.若当前字符存在下一个字符，看下一个字符是否是 '*'，如果是，有2种情况
     *      一：当前匹配
     *      1.1match(str,i + 1,pattern,j)//跳过str
     *      1.2match(str,i,pattern,j + 2)//跳过pattern
     *      1.3match(str,i + 1,pattern,j + 2)//这一种可以省略，相当于 1.1 + 1.2
     *      二：当前不匹配
     *      match(str,i,pattern,j + 2)//跳过pattern
     * 2.下一个不是 *
     *     当前匹配 return match(str,i + 1,pattern,j + 1)
     */
    public boolean match(char[] str, char[] pattern) //字符串匹配
    {    if(str == null || pattern == null)
        return false;
        return match1(str, 0, pattern, 0);
    }
    private  boolean match1(char[] str, int i, char[] pattern, int j) {
        if (j==pattern.length)
            return i==str.length;
        if (j<pattern.length-1 && pattern[j+1]=='*'){
            if (i!=str.length && (pattern[j]==str[i]|| pattern[j]=='.')){//当前相等
                return match1(str,i,pattern,j+2)||match1(str,i+1,pattern,j);
            } else return match1(str,i,pattern,j+2);
        }
        if (i!=str.length&& (str[i]==pattern[j]||pattern[j]=='.'))
            return match1(str,i+1,pattern,j+1);
        return false;
    }

    public boolean isNumeric(char[] str) {
        boolean pointcount=false,ecount=false,fcount=false;
        for (int i=0;i<str.length;i++){
            if (str[i]=='e' || str[i]=='E'){ // e必须出现在中间的位置
                if (i==str.length-1) return false;
                if (ecount) return false;
                ecount=true;
            }
            else if (str[i]=='+'||str[i]=='-'){
                if (fcount && str[i-1]!='e'&&str[i-1]!='E') return false;  // 正负号出现在e之后。的时候，符号前面应该紧接着是e
                if (!fcount && i>0 &&str[i-1]!='e'&&str[i-1]!='E') return false;// i>0 代表了正负号只能出现在第一个位置
                    fcount=true;
            }else if (str[i]=='.'){//如果在e出现之后出现了小数点，或者小数点有两个，那么返回false 因为指数不能代小数点
                if (ecount||pointcount) return false;
                pointcount=true;
            }else if (str[i]<'0'|| str[i]>'9')
                return false;
        }

            return true;
    }
}
