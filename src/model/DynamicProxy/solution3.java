package model.DynamicProxy;

import java.util.*;
import java.util.Collections;

public class solution3 {

    static int GetUglyNumber_Solution(int index) {
        if(index==0)return 0;
        ArrayList<Integer> res=new ArrayList<Integer>();
        res.add(1);
        int i2=0,i3=0,i5=0;
        while(res.size()<index)
        {
            int m2=res.get(i2)*2;
            int m3=res.get(i3)*3;
            int m5=res.get(i5)*5;
            int min=Math.min(m2,Math.min(m3,m5));
            res.add(min);
            if(min==m2)i2++;
            if(min==m3)i3++;
            if(min==m5)i5++;
        }
        return res.get(res.size()-1);
    }


    static String PrintMinNumber(int [] numbers) {
        ArrayList<String> array=new ArrayList<>();
        StringBuffer min=new StringBuffer();
        for (int i=0;i<numbers.length;i++){
            array.add(String.valueOf(numbers[i]));
        }
        Collections.sort(array, (String o1,String o2)->{
                String c1=o1+o2;
                String c2=o2+o1;
                return c1.compareTo(c2);
        });
        for (int i=0;i<array.size();i++){
            min.append(array.get(i));
        }
    return  min.toString();

    }

    static int FirstNotRepeatingChar(String str) {
        if(! str.isEmpty()){
            int[] count=new int[52];
            HashMap<Character, Integer> hashMap=new HashMap<>();
            for (int i=0;i<str.length();i++){
                if(str.charAt(i)<='Z'){
                    count[str.charAt(i)-'A']++;
                }else{
                    count[str.charAt(i)-'a'+26]++;
                }
                hashMap.put(str.charAt(i),i);
            }

            for (int i=0;i<count.length;i++){
                if (count[i]==1){
                    if (i<=25){
                        return hashMap.get((char)('A'+i))+1;
                    }else
                        return hashMap.get((char)('a'+i-26))+1;
                }
            }
        }
        return 0;
    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null|| length<0) return false;
        for (int i=0;i<length;i++){
            while(numbers[i]!=i)
            {
                if(numbers[i]==numbers[numbers[i]])
                {
                    duplication[0] = numbers[i];
                    return true;
                }
                //交换numbers[i]和numbers[numbers[i]]
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;

    }
    public static void main(String[] args) throws ClassNotFoundException{
//        int[] arr={3,32,321};
//        String a="a";
//       System.out.println(PrintMinNumber(arr));
//        System.out.println(GetUglyNumber_Solution(2));
//        System.out.println(FirstNotRepeatingChar("abbccad"));
        JdkProxyExample jdk=new JdkProxyExample();
        HelloWorld proxy =(HelloWorld) jdk.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
        Class c=Class.forName("model.DynamicProxy.solution3");

        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c); // true
    }
}