package setAndMap;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main20920 {
    public static void main(String[]args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        HashMap<String, Integer> hm = new HashMap<>();

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        for(int i=0; i<N; i++){
            String str = bufferedReader.readLine();
            if(str.length() >=M ) {
                if(hm.containsKey(str))
                hm.put(str, hm.get(str)+1);
                else hm.put(str, 0);
            }
        }

        ArrayList<String> arrayList = new ArrayList<>();
        for(String str : hm.keySet()){
            arrayList.add(str);
        }
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (hm.get(o1) != hm.get(o2)){
                    return -(hm.get(o1)-hm.get(o2));
                }else if(o1.length()!=o2.length()){
                    return -(o1.length()-o2.length());
                }else{
                    for(int i=0; i<Math.min(o1.length(), o2.length()); i++){
                        if ( o1.charAt(i) == o2.charAt(i) ){
                            continue;
                        } else {
                            return o1.charAt(i)-o2.charAt(i);
                        }
                    }
                }
                return 0;
            }
        });
        for (String str : arrayList) {
            bufferedWriter.write(str+"\n");
        }
        bufferedWriter.flush();
    }
}
