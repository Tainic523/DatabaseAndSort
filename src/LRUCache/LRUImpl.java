package LRUCache;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class LRUImpl<K,V>  {

    private List<K> LRU = new LinkedList<>();
    private  LinkedHashMap<K,V> map = new LinkedHashMap<>();
    private int maxSize ;
    public LRUImpl(int maxSize){
        this.maxSize = maxSize;
    }
    public synchronized void put(K key, V value){
        if (LRU.size()==this.maxSize){
            removeOldest();
            putNew(key,value);
        }else {
            putNew(key, value);
        }
    }
    public synchronized V get(K key){
        if (map.get(key)==null){
            return null;
        }
        V val = removeAccess(key);
        putNew(key,val);
        return map.get(key);
    }

    public synchronized void print(){
        for (K key: LRU
             ) {
            System.out.print(key+": "+map.get(key));
            System.out.println();
        }
    }
    private void removeOldest(){
        K oldKey = LRU.get(0);
        map.remove(oldKey);
        LRU.remove(0);
    }
    private void putNew(K key, V value){
        LRU.add(key);
        map.put(key,value);
    }
    private V removeAccess(K key){
        V val = map.remove(key);
        LRU.remove(key);
        return val;
    }

}
