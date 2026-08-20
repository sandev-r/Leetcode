class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i, j, visited, grid, rows, cols);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int row, int col, boolean[][] visited, char[][] grid, int rows, int cols){
        if(row < 0 || col < 0 || row >= rows || col >= cols)
            return;
        
        if(visited[row][col])
            return;

        if(grid[row][col] == '0')
            return;


        visited[row][col] = true;

        dfs(row - 1 , col, visited, grid, rows, cols);
        dfs(row + 1 , col, visited, grid, rows, cols);
        dfs(row, col - 1, visited, grid, rows, cols);
        dfs(row, col + 1, visited, grid, rows, cols);
    }
}