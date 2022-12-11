package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //
        char [][] input1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println("Number of islands: " + numIslands(input1));

        char [][] input2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + numIslands(input2));
    }

    private static boolean [][] passed;

    // Space complexity O(m*n), we need and additional boolean matrix to store visited information
    // Time complexity O(m*n), every dot in the matrix we will only visit once
    public static int numIslands(char[][] grid) {
        int num = 0;

        //reset matrix
        passed = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                //if current dot has been visited, continue
                if(passed[i][j]){
                    passed[i][j] = true;
                    continue;
                }

                //Not visited
                //then if it is a land
                //we increment the counter
                //Also call recursion to find other land and mark them
                if(grid[i][j] == '1'){
                    num++;
                    recursion(grid,i,j);
                }
            }
        }
        return num;
    }

    private static void recursion(char[][] grid, int i, int j){
        //mark current dot visited
        passed[i][j] = true;


        //mark up
        if(i != 0 && !passed[i-1][j] && grid[i-1][j] == '1'){
            recursion(grid,i-1,j);
        }

        //mark bottom
        if(i != grid.length-1 && !passed[i+1][j] && grid[i+1][j] == '1'){
            recursion(grid,i+1,j);
        }

        //mark left
        if(j != 0 && !passed[i][j-1] && grid[i][j-1] == '1'){
            recursion(grid,i,j-1);
        }

        //mark right
        if(j != grid[0].length-1 && !passed[i][j+1] && grid[i][j+1] == '1'){
            recursion(grid,i,j+1);
        }
    }
}
