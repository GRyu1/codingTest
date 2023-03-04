package search.bfs;

import java.util.LinkedList;

public class Bfs {
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	static boolean[] visited = new boolean[9];
	
	public static void main(String[] args) {
		bfs(1);
	}

	private static void bfs(int i) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offer(i);
		visited[i] = true;
		
		while(!queue.isEmpty()) {
			int nodeIdx=queue.poll();
			System.out.print(nodeIdx+"->");
			
			for(int Linked : graph[nodeIdx]) {
				if(!visited[Linked]) {
					visited[Linked]=true;
					queue.offer(Linked);
				}
			}
		}
	}
}
