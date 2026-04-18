public int[][] generateMaze() {
    int[][] maze = new int[height][width];
        for (int i = 0; i < height; i++)
        for (int j = 0; j < width; j++)
            maze[i][j] = 1;

     Random rand = new Random();
               int r = rand.nextInt(height);
     while (r % 2 == 0) {
         r = rand.nextInt(height);
     }
          int c = rand.nextInt(width);
     while (c % 2 == 0) {
         c = rand.nextInt(width);
     }
          maze[r][c] = 0;

          recursion(r, c);

     return maze;
 }

 public void recursion(int r, int c) {
          int[] randDirs = generateRandomDirections();
          for (int i = 0; i < randDirs.length; i++) {

         switch(randDirs[i]){
         case 1:                           if (r - 2 <= 0)
                 continue;
             if (maze[r - 2][c] != 0) {
                 maze[r-2][c] = 0;
                 maze[r-1][c] = 0;
                 recursion(r - 2, c);
             }
             break;
         case 2:                           if (c + 2 >= width - 1)
                 continue;
             if (maze[r][c + 2] != 0) {
                 maze[r][c + 2] = 0;
                 maze[r][c + 1] = 0;
                 recursion(r, c + 2);
             }
             break;
         case 3:                           if (r + 2 >= height - 1)
                 continue;
             if (maze[r + 2][c] != 0) {
                 maze[r+2][c] = 0;
                 maze[r+1][c] = 0;
                 recursion(r + 2, c);
             }
             break;
         case 4:                           if (c - 2 <= 0)
                 continue;
             if (maze[r][c - 2] != 0) {
                 maze[r][c - 2] = 0;
                 maze[r][c - 1] = 0;
                 recursion(r, c - 2);
             }
             break;
         }
     }

 }

 
 public Integer[] generateRandomDirections() {
      ArrayList<Integer> randoms = new ArrayList<Integer>();
      for (int i = 0; i < 4; i++)
           randoms.add(i + 1);
      Collections.shuffle(randoms);

     return randoms.toArray(new Integer[4]);
 }