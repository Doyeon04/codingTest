import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] arr = new char[R][C];
        List<String> list = new ArrayList<>();
        for(int i=0; i<R; i++){
            String str = br.readLine();
            String word = "";
            for(int j=0; j<C; j++){
                arr[i][j] = str.charAt(j);

                if(str.charAt(j)!='#') word+=str.charAt(j);
                if(str.charAt(j)=='#' || j==C-1){
                    if(word.length()>=2) list.add(word); // 가로 문자들 리스트에 넣기
                    word="";
                }

            }
        }

        for(int i=0; i<C; i++){
            String word = "";
            for(int j=0; j<R; j++){
                if(arr[j][i] != '#') word+=arr[j][i];
                if(arr[j][i] == '#' || j==R-1){
                    if(word.length()>=2) list.add(word);
                    word="";
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));

    }
}
