public class BreakingAString {

  public static void main(String args[]) {
    int m = 2;
  //  int cuts[] = new int[]{2,8, 10};
    int cuts[] = new int[]{3, 10};

    String s = "PleaseBreakTheSenten";
    int n = s.length();
    int cost[][] = new int[m][m];
    //System.out.println(cutString(cuts,0,m,0,20));
    System.out.println(get_min_cost(cuts,20,2));
    /*for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 && j == 0) {
          cost[i][j] = n;
        } else {
          cost[i][j] = cost[i - 1][j - 1] + (n - cuts[j]);
        }
      }
    }*/
  }

  private static Integer  cutString(int cuts[], int i, int j, int l, int r){
    if (l == r) {
      return 0;
    }
  Integer minCost = Integer.MAX_VALUE;
    for(int k=i; k<=j;k++) {
      if (l + r +
          cutString(cuts, i, k, l, cuts[k]) +  cutString(cuts, k, j, cuts[k], j) < minCost) {
        minCost =
            r - l + cutString(cuts, i, k, l, cuts[k]) + cutString(cuts, k + 1, j, cuts[k],
                j);
      }
    }
    return(minCost);
}

private static int get_min_cost( int y[], int n, int m )
{
  int new_y[] =  new int[m + 2];
  int M[][]= new int [m+2][m+2];

  // move things up a bit
  new_y[0] = 0;
  for (int i = 0; i < m; i++) {
    new_y[i + 1] = y[i];
  }
  new_y[m + 1] = n;

  for(int w = 0; w <= m+1; w++){
    System.out.print(new_y[w]+ " ");
  }

  // set the central diagonal to all 0
  // this loop below is really not needed
  // as the values of this diagonal are not used
  // to calculate anything
  for( int i = 0; i <= m + 1; i++ )
  {
    M[i][i] = 0;
  }

  // set the diagonal next to it to all 0
  for( int i = 0; i <= m; i++ )
  {
    M[i][i+1] = 0;
  }

  // fill in the rest of diagonals
  for( int incr = 2; incr <= m + 1; incr++ )
  {
    for( int i = 0; i <= m + 1 - incr; i++ )
    {
      int j = i + incr;
      int min_cost = Integer.MAX_VALUE;
      int first_cut = new_y[j] - new_y[i];
      System.out.println("FirstCut:"+ first_cut);
      for( int l = i + 1; l < j; l++ )
      {
        int cost = M[i][l] + M[l][j];
        if( cost < min_cost )
        {
          min_cost = cost;
        }
      }
      if( min_cost == Integer.MAX_VALUE )
      {
        min_cost = first_cut;
      }
      else
      {
        min_cost = first_cut + min_cost;
      }
      M[i][j] = min_cost;
    }
  }
  return M[0][m+1];
}

}
