package doIt.정수론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

//N - 1개의 비율로 N개의 재료 값을 알 수 있다.
//N - 1개의 엣지에 대한 가중치로 N개의 노드 값을 알 수 있다.
public class E1033_칵테일 {

    public static ArrayList<myNode>[] A; //인접 리스트
    public static boolean[] visited; //방문 배열
    public static long lcm; //최소 공배수
    public static long[] D; //정답 배열

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //static 변수 셋팅
        int N = Integer.parseInt(br.readLine()); //전체 재료 개수
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;

        //인접 리스트 초기화, 비에 대한 최소 공배수 계산
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            A[a].add(new myNode(b,p,q)); // A[a] = [도착 노드, 시작노드쪽 비, 도착노드쪽 비]
            A[b].add(new myNode(a,q,p));
            lcm *= (p * q / gcd(p, q));
        }

        D[0] = lcm; //시작 노드의 값을 최소 공배수로 설정
        DFS(0);
        long node_gcd = D[0]; //노드 값의 최대 공약수
        for (int i = 1; i < N; i++) {
            node_gcd = gcd(node_gcd, D[i]);
        }
        
        //결과 출력
        for (int i = 0; i < N; i++) {
            //노드값의 최소값을 출력하기 위해 노드 값의 최대 공약수로 나눈다.
            bw.write(D[i] / node_gcd + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    //DFS(깊이 우선 탐색) 구현
    private static void DFS(int node) {
        visited[node] = true; //방문 노드 기록
        for (myNode i : A[node]) {
            int next = i.getB();
            if (!visited[next]) { //인접 노드가 미방문 노드인 경우
                D[next] = D[node] * i.getQ() / i.getP(); //이전 노드의 값 * 이전 노드의 도착 비 / 이전 노드의 시작 비
                DFS(next);
            }
        }
    }

    //최대 공약수 계산 메서드
    private static long gcd(long p, long q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }
    
    //인접 리스트에서 제네릭에 대한 노드 클래스 작성
    private static class myNode {
        //field
        private int b; //도착 노드
        private int p; //시작쪽 비
        private int q; //도착쪽 비

        //arguments constructor
        public myNode(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }

        //getter
        public int getB() {return b;}
        public int getP() {return p;}
        public int getQ() {return q;}
    }
}
