package search.dfs;
//https://codingnojam.tistory.com/44
// by recrusion

public class DfsRecrusion {
	static boolean[] visited = new boolean[9];
	static int[][] graph = {
			{} , {2,3,8} , {1,6,8}, {1,5} , {5,7} ,
			{3,4,7},{2},{4,5},{1,2}
	};
	
	public static void main(String[] args) {

		dfs(1);
	}
	
	private static void dfs (int nodeIdx) {
		visited[nodeIdx] = true;
		System.out.println(nodeIdx + "->" + "한글");
		for(int node : graph[nodeIdx]) {
			if(!visited[node])
			dfs(node);
		}
	}
	
}
