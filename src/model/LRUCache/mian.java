package model.LRUCache;

import org.apache.ibatis.javassist.bytecode.Descriptor;

import java.util.Iterator;
import java.util.Map;

public class mian {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        for (String a: cache.values()){
            System.out.println(a);

        }
//        System.out.println(cache.keySet());

        LRU<Integer,String> lru=new LRU<>(5);
        lru.put(1,"a");
        lru.put(2,"b");
        lru.put(3,"c");
        lru.put(4,"d");
        lru.put(5,"e");
        lru.get(1);
        lru.put(6,"f");
        Iterator iterator=lru.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"  ");
        }
    }
}
