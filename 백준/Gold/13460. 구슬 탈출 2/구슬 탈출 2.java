import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	public static int[] dx = {0, 0, 1, -1}; // 동서남북
	public static int[] dy = {1, -1, 0, 0};
	public static char[][] board;
	public static boolean[][][][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		
		board = new char[N][M];
		visit = new boolean[N][M][N][M];
		
		Node node = new Node();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
				
				if(str.charAt(j) == 'R') { // R의 초기 좌표값
					node.rx = i; node.ry = j;
				} else if(str.charAt(j) == 'B') { // B의 초기 좌표값
					node.bx = i; node.by = j;
				}
			}
		}
		
		System.out.println(bfs(node));
	}
	
	static int bfs(Node ball) {
		Queue<Node> q = new LinkedList<>();
		
		q.offer(ball);
		visit[ball.rx][ball.ry][ball.bx][ball.by] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
            
            if(node.cnt >= 10) return -1;
			
			for(int i = 0; i < 4; i++) {
				int rx = node.rx;
				int ry = node.ry;
				int bx = node.bx;
				int by = node.by;
				int cnt = node.cnt;
                
				while(board[rx + dx[i]][ry + dy[i]] != '#') {
					rx += dx[i];
					ry += dy[i];
					
					if(board[rx][ry] == 'O') {
						break;
					}
				}
					
				while(board[bx + dx[i]][by + dy[i]] != '#') {
					bx += dx[i];
					by += dy[i];
					
					if(board[bx][by] == 'O') {
						break;
					}
				}
				
				if(board[bx][by] == 'O') {
					continue;
				}
				
				if(board[rx][ry] == 'O') {
					return cnt + 1;
				}
				
				if(rx == bx && ry == by) {
					int rd = Math.abs(node.rx - rx) + Math.abs(node.ry - ry);
					int bd = Math.abs(node.bx - bx) + Math.abs(node.by - by);
					
					if(rd < bd) {
						bx -= dx[i];
						by -= dy[i];
					} else {
						rx -= dx[i];
						ry -= dy[i];
					}
				}
					
				if(visit[rx][ry][bx][by] == false) {
					visit[rx][ry][bx][by] = true;
					q.offer(new Node(rx, ry, bx, by, cnt + 1));
				}
			}
		}
		
		return -1;
	}
	
	static class Node {
		int rx; // R의 좌표
		int ry;
		int bx; // B의 좌표
		int by;
		int cnt; // 움직인 횟수
		
		Node(int a, int b, int c, int d, int cnt) {
			this.rx = a;
			this.ry = b;
			this.bx = c;
			this.by = d;
			this.cnt = cnt;
		}

		Node() {
			
		}
	}
 }