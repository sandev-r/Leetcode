class Solution {
    static List<List<Integer>> graph;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        graph = new ArrayList<>();

        for(int i = 0;i < n;i++)
            graph.add(new ArrayList());

        for(int i = 0;i < edges.length;i++){
            addEdge(edges[i][0], edges[i][1]);
        }

        boolean[] visited = new boolean[n];

        

        return dfs(source, visited, destination);
        
    }

    private void addEdge(int v, int u){
        graph.get(v).add(u);
        graph.get(u).add(v);
    }

    private boolean dfs(int node, boolean[] visited, int destination){
        visited[node] = true;

        boolean found = false;

        if(node == destination)
            return true;

        for(int neighbour: graph.get(node)){
            if(!visited[neighbour]){
                found = dfs(neighbour, visited, destination);
            }

            if(found){
                return true;
            }
        }

        return false;
    }
}