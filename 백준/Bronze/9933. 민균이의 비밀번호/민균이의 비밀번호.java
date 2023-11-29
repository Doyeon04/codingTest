import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        String ans = "";
        while(N-->0){
            String password = br.readLine();
            String reversed = new StringBuilder(password).reverse().toString();
            if(password.equals(reversed)){
                ans = password;
                break;
            }
            if(set.contains(reversed)){
                ans = password;
                break;
            }else set.add(password);
        }
        System.out.print(ans.length() + " " + ans.charAt((ans.length()-1)/2));
    }
}
