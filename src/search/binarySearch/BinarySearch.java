package search.binarySearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class BinarySearch {
    static ArrayList<Integer> al;
    static int targetIdx;
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        al = new ArrayList<>();
        while(hs.size()<100){
            hs.add((int)(Math.random()*150)+1);
        }
        Iterator<Integer> iterator = hs.iterator();
        while(iterator.hasNext()) {
            al.add(iterator.next());
        }
        int target = (int)(Math.random()*150) +1;
        int endIdx = al.size()-1;

        binarySearch(target , 0 , endIdx);

        System.out.println(targetIdx);
    }

    public static void binarySearch(int target , int start ,int endIdx) {
        if(start==endIdx){
            if(target == al.get(start)){
                targetIdx = start;
                return;
            }
            else {
                targetIdx = -1;
                return;
            }
        }else {
            int mid = (start + endIdx) / 2;
            if (target < al.get(mid)) {
                binarySearch(target, start, mid - 1);
            } else if (target > al.get(mid)) {
                binarySearch(target, mid + 1, endIdx);
            } else if (target == al.get(mid)) {
                targetIdx=mid;
                return ;
            }
        }
    }
}