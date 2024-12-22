package doIt.그래프.유니온파인드;

import java.util.ArrayList;
import java.util.Scanner;

public class E1043_거짓말 {

    public static int[] parent; //대표 노드 배열
    public static int[] trueP; //진실을 아는 사람(노드) 배열
    public static ArrayList<Integer>[] party; //파티(그래프) 데이터
    public static int result = 0; //참석 가능한 파티의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //전체 사람(노드) 수
        parent = new int[N + 1];
        for (int i = 0; i < N; i++) {
            parent[i] = i; //대표 노드 초기화
        }

        int M = sc.nextInt(); //파티 수
        party = new ArrayList[M];

        int T = sc.nextInt(); //진실을 아는 사람(노드) 수
        trueP = new int[T];
        for (int i = 0; i < T; i++) {
            trueP[i] = sc.nextInt(); //진실을 아는 사람(노드) 저장
        }

        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            int party_size = sc.nextInt();
            for (int j = 0; j < party_size; j++) {
                party[i].add(sc.nextInt());
            }
        }

        //각 파티에 참여한 사람들을 같은 그룹으로 만들기
        for (int i = 0; i < M; i++) {
            int first_people = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(first_people, party[i].get(j));
            }
        }

        //각 파티의 대표 노드 vs 진실을 아는 사람들의 대표 노드 : 같은 경우 과장 X
        for (int i = 0; i < M; i++) {
            boolean isPossible = true;
            int cur = party[i].get(0);
            for (int j = 0; j < trueP.length; j++) {
                if (find(cur) == find(trueP[j])) { //대표 노드가 같음
                    isPossible = false; //과장 불가능
                    break;
                }
            }
            if (isPossible) result++; 
        }
        System.out.println(result);
    }

    private static void union(int a, int b) {
        int a_root = find(a);
        int b_root = find(b);
        if (a_root != b_root) parent[b_root] = a_root; //루트 노드가 다른 경우
    }

    private static int find(int a) {
        if (a == parent[a]) return a; //루트 노드에 도달한 경우
        else return parent[a] = find(parent[a]); //루트 노드에 도달하지 못한 경우
    }

}
