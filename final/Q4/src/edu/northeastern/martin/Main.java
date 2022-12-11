package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] input1 = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println("Num of Unique path: " + numOfUniquePath(input1));

        int[][] input2 = {
                {0,1},
                {0,0}
        };
        System.out.println("Num of Unique path: " + numOfUniquePath(input2));
    }

    private static int num = 0;
    // Space complexity O(1)
    // Time complexity O(m*n)
    public static int numOfUniquePath(int[][] grid) {
        num = 0;
        recursion(grid,0,0);
        return num;
    }

    private static void recursion(int[][] grid, int i, int j){

        if(i == grid.length-1 && j == grid[0].length-1){
            num++;
            return;
        }
        //go bottom
        if(i != grid.length-1 && grid[i+1][j] != 1){
            recursion(grid,i+1,j);
        }
        //go right
        if(j != grid[0].length-1 && grid[i][j+1] != 1){
            recursion(grid,i,j+1);
        }
    }
}
