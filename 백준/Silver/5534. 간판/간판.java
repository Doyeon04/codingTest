import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int N = Integer.parseInt(br.readLine());
        String name = br.readLine();
        int cnt=0;

        while (N-- > 0) {
            String oldName = br.readLine();
            loop: for (int i = 0; i < oldName.length(); i++) { // 시작값
                for(int k=1; k<oldName.length(); k++){
                    String newName = "";
                    for(int j=i; j<oldName.length(); j+=k){
                        newName += oldName.charAt(j);
                        if(newName.length() == name.length()) break;
                    }
                    if(newName.equals(name)){
                        cnt++;
                        break loop;
                    }
                }
            }
        }
        System.out.println(cnt);

    }
}

