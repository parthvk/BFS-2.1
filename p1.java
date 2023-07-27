// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Using BFS

class Solution {
    public int orangesRotting(int[][] grid) {
        //Getting the number of rows and columns
        int m = grid.length;
        int n = grid[0].length;

        //Queue to store the 2's and process them and then store the 1's that turned to 2
        Queue<int[]> q = new LinkedList<>();
        //Count to store the number of 1's
        int count = 0;

        //Loop to go over all elements and add 2's to the queue and count the number of 1's
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    count++;
                }
            }
        }

        //Variable to count the number of mins
        int min = 0;

        //If there are no 1's return 0;
        if(count == 0)return min;

        //Direction array to process the four adjoining cells
        int[][] dirs = new int[][]{{0,-1},{-1,0}, {0,1}, {1,0}};

        //Loop to process all the cells in queue
        while(q.peek() != null){
            int size = q.size();
            min++;
            //Get the cells from queue
            for(int i=0; i<size; i++){
                int[] temp = q.remove();
                //Process each cell and check if they have adjoining 1
                //If they have adjoining 1, make it to 2 and add it to queue and decrease the count for number of 1's
                for(int[] dir: dirs){
                    int j = temp[0] + dir[0];
                    int k = temp[1] + dir[1];
                    if(j>=0 && k>=0 && j<m && k<n && grid[j][k] == 1){
                        count--;
                        q.add(new int[]{j,k});
                        grid[j][k] = 2;
                        
                    }
                }
            }
            //When all the 1's become 2, return the number of mins
            if(count == 0)return min;
        }
        //Else return -1
        return -1;
    }
}