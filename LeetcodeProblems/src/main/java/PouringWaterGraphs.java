import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PouringWaterGraphs{


  static HashSet<State> usedStates = new HashSet<State>();
  static HashMap<State,State> prev = new HashMap<State, State>();
  static ArrayDeque<State> queue = new ArrayDeque<State>();
  static short[] limits = new short[]{700,400,1000};

  public static void main(String[] args){

    State initialState = new  State(new Short[]{700,400,0});
    usedStates.add(initialState);
    queue.add(initialState);
    prev.put(initialState,null);
    boolean solutionFound = false;


    while(!queue.isEmpty()){
      State curState = queue.poll();
      if(curState.isWinning()){
        printSolution(curState);
        solutionFound = true;
        break; //stop BFS even if queue is not empty because solution already found
      }
      // go to all possible states

      for(int i=0;i<curState.getGlasses().length;i++)
        for(int j=0;j<curState.getGlasses().length;j++) {
          if (i != j) { //pouring from i-th glass to j-th glass, can't pour to itself
            short glassI = curState.getGlasses()[i];
            short glassJ = curState.getGlasses()[j];
            short possibleToPour = (short)(limits[j]-glassJ);
            short amountToPour;
            if(glassI<possibleToPour) amountToPour = glassI; //pour total i-th glass
            else amountToPour = possibleToPour; //pour i-th glass partially
            if(glassI!=0){ //prepare new state
              Short[] newGlasses = Arrays.copyOf(curState.getGlasses(), curState.getGlasses().length);
              newGlasses[i] = (short)(glassI-amountToPour);
              newGlasses[j]  = (short)(newGlasses[j]+amountToPour);
              State newState = new State(newGlasses);
              if(!usedStates.contains(newState)){ // if new state not handled before mark it as used and add to queue for future handling
                usedStates.add(newState);
                prev.put(newState, curState);
                queue.add(newState);
              }
            }
          }
        }
    }
    if(!solutionFound) System.out.println("Solution does not exist");

  }

  private static void printSolution(State curState) {
    System.out.println("below is 'reversed' solution. In order to get solution from initial state read states from the end");
    while(curState!=null){
      System.out.println("("+curState.getGlasses()[0]+","+curState.getGlasses()[1]+","+curState.getGlasses()[2]+")");
      curState = prev.get(curState);
    }

  }

  static class State{

    private Short[] glasses;

    public State(Short[] glasses){
      this.glasses = glasses;
    }

    public boolean isWinning() {

      return glasses[0]==200 || glasses[1]==200;
    }

    public Short[] getGlasses(){
      return glasses;
    }

    @Override
    public boolean equals(Object other){
      return Arrays.equals(glasses,((State)other).getGlasses());
    }

    @Override
    public int hashCode(){
      return Arrays.hashCode(glasses);
    }
  }
}