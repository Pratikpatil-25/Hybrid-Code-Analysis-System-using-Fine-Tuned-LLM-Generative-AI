package Algorithm.solved;



import java.io.*;

import java.util.StringTokenizer;



public class 유기농_배추_1012 {

    static int N, M;

    static boolean[][] visited;

    static int[][] arr;

    static int[] dr = {-1, 1, 0, 0};

    static int[] dc = {0, 0, -1, 1};



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int testcase = Integer.parseInt(br.readLine());



        for (int i = 0; i < testcase; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());



            M = Integer.parseInt(st.nextToken());

            N = Integer.parseInt(st.nextToken());

            int K = Integer.parseInt(st.nextToken());



            arr = new int[N][M];

            visited = new boolean[N][M];



            for (int j = 0; j < K; j++) {

                st = new StringTokenizer(br.readLine());



                int x = Integer.parseInt(st.nextToken());

                int y = Integer.parseInt(st.nextToken());



                arr[y][x] = 1;

            }



            int cnt = 0;



            for (int j = 0; j < N; j++) {

                for (int k = 0; k < M; k++) {

                    if (arr[j][k] == 1 && !visited[j][k]) {

                        cnt++;

                        dfs(j, k);

                    }

                }

            }



            bw.write(cnt + "");

            bw.newLine();

        }



        bw.flush();

        bw.close();

    }



    static void dfs(int r, int c) {

        visited[r][c] = true;



        for (int i = 0; i < 4; i++) {

            int rd = r + dr[i];

            int cd = c + dc[i];



            if (rd >= 0 && rd < N && cd >= 0 && cd < M && !visited[rd][cd] && arr[rd][cd] == 1) {

                dfs(rd, cd);

            }

        }

    }

}