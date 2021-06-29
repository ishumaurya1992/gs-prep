package gsprep.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class LargestTree {

    static void addEdge(List<Integer> adj[],int i,int j){
        adj[i].add(j);
        adj[j].add(i);
    }


    static int DFSUtil(int u, List<Integer> adj[],boolean[] visited)
    {
        visited[u] = true;
        int count  = 1;

        for (int i = 0; i <adj[u].size() ; i++) {
            if(visited[adj[u].get(i)]==false){
                count+=DFSUtil(adj[u].get(i), adj,visited);
            }
        }
        return count;


    }

    static int largestTree(List<Integer> adj[], int V)
    {
        boolean [] visited = new boolean[V];
        int answer = 0;
        for (int u = 0; u < V; u++)
        {
            if (visited[u] == false)
            {
                answer = Math.max(answer,DFSUtil(u, adj, visited));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int V = 5;
        List<Integer> adj[] = new List[5];
        for (int i = 0; i < adj.length; i++)
            adj[i] = new ArrayList<>();

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,3,4);

        System.out.println(largestTree(adj,5));

    }

}
