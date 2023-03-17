import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        Lecture[] arr = new Lecture[N];
        ArrayList<Lecture> al = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer( br.readLine() , " ");
            arr[i]=(new Lecture(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Arrays.sort(arr, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if(o1.end == o2.end) return o1.start-o2.start;
                return o1.end-o2.end;
            }
        });

        int idx = 0;
        int count = 0 ;
        int min = Integer.MAX_VALUE;

        int time=arr[0].start;
        for(Lecture act : arr){
            if(time <= act.start){
                time = act.end;
                al.add(act);
            }
        }
        System.out.println(al.size());
    }
}

class Lecture{
    int start;
    int end;

    Lecture(){}

    Lecture(int start , int end){
        this.start = start;
        this.end = end;
    }

}