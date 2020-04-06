public class ProbabilityOfAToWin {
  public static void probAWin(int a, int b, int n) {
    // if a and b alternated between winning until they were 1 away and someone wins the last one
    int games_left = (2 * n) - a - b - 1;
    // goal - how many already won
    int games_to_win = n - a;
    double[][] C = new double[games_left + 1][games_to_win + 1];
    // Base case 1 & 2:
    for (int i = 0; i <= games_left; i++) {
      // 1: if games to win is 0, probability is 100%
      C[i][0] = (double) 1;
      // 2: if games left = games to win, probability is 50% * C[i-1][i-1]
      // only if i is greater than 0 (base case 1) and only up to the num of games to win
      if (i > 0 && i <= games_to_win) {
        C[i][i] = .5 * C[i - 1][i - 1];
      }
    }
    for (int diff = 1; diff <= games_left - 1; diff++) {
      for (int i = 1; i <= games_to_win; i++) {
        // column or games_left is games to win + diff
        int col = i + diff;
        // probability is A or B where
        // A = win this game * C[games_left-1][games_to_win-1]
        // B = don't win this game * C[games_left-1][games_to_win]
        if (col <= games_left) {
          C[col][i] = (.5 * C[col - 1][i - 1]) + (.5 * C[col - 1][i]);
        }
      }
    }
    System.out.println("The probability of A winning the competition is: " + C[games_left][games_to_win]);
  }

  public static void main(String args[]){
    probAWin(9, 7, 10);
  }

}
