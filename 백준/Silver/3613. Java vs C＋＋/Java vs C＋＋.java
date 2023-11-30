import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String str = br.readLine();
        String ans="";

        if(Character.isUpperCase(str.charAt(0)) // 대문자로 시작하거나 시작이나 끝이 _ 라면 에러
        || str.startsWith("_") || str.endsWith("_")){
            System.out.println("Error!");
            return;
        }

        boolean error = false;
        if(str.contains("_")){
            if(str.indexOf("__") > 0) error =true;
            boolean isUnder = false;
            for(char c : str.toCharArray()){
                if(Character.isUpperCase(c)){  // _ 와 대문자가 같이 나오면 에러
                    error= true;
                    break;
                }
                if(isUnder) ans+=Character.toUpperCase(c);
                else if(c!='_') ans+=c;

                if(c=='_') {
                    isUnder=true;
                }
                else isUnder=false;
            }
        }else{

            for(char c : str.toCharArray()){
                if(Character.isUpperCase(c)){
                    ans = ans + "_" + Character.toLowerCase(c);
                }else ans+=c;
            }
        }

        System.out.println(error ? "Error!" : ans);
    }
}

