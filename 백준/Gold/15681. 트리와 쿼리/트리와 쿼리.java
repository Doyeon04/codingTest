import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> connect;
    static ArrayList<ArrayList<Integer>> child;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        connect = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            connect.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            connect.get(u).add(v);
            connect.get(v).add(u);
        }
        child = new ArrayList<>();
        for (int j = 0; j <= n; j++) {
            child.add(new ArrayList<>());
        }
        size = new int[n + 1];
        makeTree(r, -1); // root번 정점을 루트로 하는 트리 구성
        countSubTreeNodes(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int root = Integer.parseInt(br.readLine());
            sb.append(size[root]).append("\n");
        }
        System.out.println(sb);
    }

    private static void countSubTreeNodes(int currentNode) {
        size[currentNode] = 1;
        for (int node : child.get(currentNode)) {
            countSubTreeNodes(node);
            size[currentNode] += size[node];
        }
    }

    private static void makeTree(int currentNode, int parent) {
        for (int node : connect.get(currentNode)) {
            if (node != parent) {
                child.get(currentNode).add(node);
                makeTree(node, currentNode);
            }
        }
    }


}

