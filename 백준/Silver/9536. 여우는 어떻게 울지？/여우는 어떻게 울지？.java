import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] sounds = br.readLine().split(" ");
            while (true) {
                String str = br.readLine();
                if (str.equals("what does the fox say?")) break;
                String animalSound = str.split(" ")[2];
                for (int i = 0; i < sounds.length; i++) {
                    if (sounds[i].equals(animalSound)) sounds[i] = "";
                }

            }
            String ans = "";
            for (String s : sounds) {
                if (!s.equals("")) ans += s + " ";
            }
            System.out.println(ans);
        }
    }
}

