import java.util.*;

class rotten {
    static class Pair {
        int x;
        int y;
        int time;

        Pair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    // TC - O(M*N) SC - O(M*N)
    public int orangesRotting(int[][] grid) {
        // Initialize a queue that will store all the rotten oranges to be processed
        Queue<Pair> q = new LinkedList<>();

        // Add all the initial rotten oranges to this queue, their time will be 0 as
        // they are already rotteb from beginning
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        // Initialize lastTime, it will hold the value of time of the last rotten orange
        // processed
        int lastTime = 0;

        // We process all the rotten oranges until the queue becomes empty
        while (!q.isEmpty()) {
            // Pop a rotten orange from the queue
            Pair rottenOrange = q.poll();
            // Store its time
            lastTime = rottenOrange.time;

            // Check if x-1,y index is within bounds of matrix and is a fresh orange
            if (isSafe(grid, rottenOrange.x - 1, rottenOrange.y)) {
                // Make it a rotten orange
                grid[rottenOrange.x - 1][rottenOrange.y] = 2;
                // And add it to the queue to be processed
                q.add(new Pair(rottenOrange.x - 1, rottenOrange.y, rottenOrange.time + 1));
            }
            // Check if x+1,y index is within bounds of matrix and is a fresh orange
            if (isSafe(grid, rottenOrange.x + 1, rottenOrange.y)) {
                // Make it a rotten orange
                grid[rottenOrange.x + 1][rottenOrange.y] = 2;
                // And add it to the queue to be processed
                q.add(new Pair(rottenOrange.x + 1, rottenOrange.y, rottenOrange.time + 1));
            }
            // Check if x,y+1 index is within bounds of matrix and is a fresh orange
            if (isSafe(grid, rottenOrange.x, rottenOrange.y + 1)) {
                // Make it a rotten orange
                grid[rottenOrange.x][rottenOrange.y + 1] = 2;
                // And add it to the queue to be processed
                q.add(new Pair(rottenOrange.x, rottenOrange.y + 1, rottenOrange.time + 1));
            }
            // Check if x,y-1 index is within bounds of matrix and is a fresh orange
            if (isSafe(grid, rottenOrange.x, rottenOrange.y - 1)) {
                // Make it a rotten orange
                grid[rottenOrange.x][rottenOrange.y - 1] = 2;
                // And add it to the queue to be processed
                q.add(new Pair(rottenOrange.x, rottenOrange.y - 1, rottenOrange.time + 1));
            }

        }

        // After processing all the rotten oranges, check whether we have a fresh orange
        // left in the matrix,
        // If we have then return -1 since all the oranges have not been rotten
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        // Otherwise return the time of the last processed rotten orange
        return lastTime;
    }

    // Function that checks whether we are within the mound of the matrix and the
    // value at the index is 1
    public static boolean isSafe(int[][] matrix, int i, int j) {
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length && matrix[i][j] == 1) {
            return true;
        }
        return false;
    }
}