import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.next();

        int[] arr=new int[26];
        Arrays.fill(arr, -1);

        for(int i=0; i<s.length(); i++){
            int num=s.charAt(i)-97;
            if(arr[num]!=-1) continue;
            arr[num] = i;
        }
        for(int x : arr){
            System.out.print(x+ " ");
        }
    }
}