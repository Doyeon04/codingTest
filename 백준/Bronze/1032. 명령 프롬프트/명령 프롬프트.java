import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0; i<arr.length; i++){
            arr[i]=br.readLine();
        }
        String ans = "";
        for(int i=0; i<arr[0].length(); i++){
            boolean same = true;
            char compared = arr[0].charAt(i);
            for(int j=0; j<arr.length; j++){
                char current = arr[j].charAt(i);
                if(compared != current){
                    same = false;
                    break;
                }
            }
            if(same) ans+=arr[0].charAt(i);
            else ans+='?';
        }
        System.out.println(ans);
    }
}
