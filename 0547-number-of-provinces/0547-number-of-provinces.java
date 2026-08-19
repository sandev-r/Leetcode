class Solution {
    static List<List<Integer>> graph;
    public int findCircleNum(int[][] isConnected) {
        graph = new ArrayList<>();
        for(int i = 0;i < isConnected.length;i++)
            graph.add(new ArrayList<>());
        
        for(int i = 0;i < isConnected.length;i++){
            for(int j = 0;j < isConnected[i].length;j++){
                if(isConnected[i][j] == 1 && i != j){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        boolean[] isVisited = new boolean[isConnected.length];

        int count = 0;

        for(int i = 0;i < isConnected.length;i++){
            if(!isVisited[i]){
                dfs(i, isVisited);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node, boolean[] isVisited){
        isVisited[node] = true;

        for(int n: graph.get(node)){
            if(!isVisited[n]){
                dfs(n, isVisited);
            }
        }
    }

    
}