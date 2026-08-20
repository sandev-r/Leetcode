class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;

        int orginalColor = image[sr][sc];

        dfs(sr, sc, image, orginalColor, color,  rows,cols);

        return image;
    }

    private void dfs(int row, int col, int[][] image,int orginalColor, int color ,int rows, int cols){
        if(row < 0 || col < 0 || row >= rows || col >= cols)
            return;
        if(image[row][col] == color)
            return;

        if(image[row][col] != orginalColor)
            return;

        image[row][col] = color;

        dfs(row - 1, col, image, orginalColor, color, rows, cols);
        dfs(row + 1, col, image, orginalColor, color, rows, cols);
        dfs(row, col - 1, image, orginalColor, color, rows, cols);
        dfs(row, col + 1, image, orginalColor, color, rows, cols);
    }
}