/*
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PouringWater {

  public static void main(String[] args) throws Exception {
    State initialState = new State(null, 0, 7, 4);

    Set<State> reached = new HashSet<>();
    Queue<State> pending = new ArrayDeque<>();
    pending.add(initialState);
    while (!pending.isEmpty()) {
      State state = pending.remove();

      if (isGoal(state)) {
        System.out.println("Last:"+state);
        printPathTo(state);
        return;
      }

      for (State s : state.adjacentStates()) {
        if (!reached.contains(s)) {
          reached.add(s);
          pending.add(s);
        }
      }
    }

    System.out.println("There appears to be no solution.");
  }

  private static boolean isGoal(State state) {
    for (int a : state.content) {
      if (a == 2) {
        return true;
      }
    }
    return false;
  }

  private static void printPathTo(State state) {
    if (state != null) {
      printPathTo(state.previous);
      System.out.println(state);
    }
  }
}

class State {

  final static int[] capacity = { 10, 7, 4 };

  final int[] content;
  final State previous;

  public State(State previous, int... content) {
    this.content = content;
    this.previous = previous;
  }

  Iterable<State> adjacentStates() {
    List<State> result = new ArrayList<>();
    for (int i = 0; i < content.length; i++) {
      for (int j = 0; j < content.length; j++) {
        if (i != j) {
          int[] newContent = Arrays.copyOf(content, content.length);
          int movedQuantity = Math.min(content[i], capacity[j] - content[j]);
          newContent[i] -= movedQuantity;
          newContent[j] += movedQuantity;
          result.add(new State(this, newContent));
        }
      }
    }
    return result;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(content);
  }

  @Override
  public boolean equals(Object obj) {
    return Arrays.equals(content, ((State) obj).content);
  }

  @Override
  public String toString() {
    return Arrays.toString(content);
  }
}*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PouringWater {

  public static void main(String[] args) throws Exception {
    State initialState = new State(null, 0, 7, 4);

    if (findUsingBFS(initialState)) {
      return;
    }

    System.out.println("There appears to be no solution.");
  }

  private static boolean findUsingBFS(State initialState) {
    Set<State> reached = new HashSet<>();
    Queue<State> pending = new ArrayDeque<>();
    pending.add(initialState);
    while (!pending.isEmpty()) {
      State state = pending.remove();

      if (isGoal(state)) {
        printPathTo(state);
        return true;
      }

      for (State s : state.adjacentStates()) {
        if (!reached.contains(s)) {
          reached.add(s);
          pending.add(s);
        }
      }
    }
    return false;
  }

  private static boolean isGoal(State state) {
    for (int a : state.content) {
      if(state.content[1] == 2 || state.content[2] ==2)
       {
        return true;
      }
    }
    return false;
  }

  private static void printPathTo(State state) {
    if (state != null) {
      printPathTo(state.previous);
      System.out.println(state);
    }
  }
}

class State {

  final static int[] capacity = { 10, 7, 4 };

  final int[] content;
  final State previous;

  public State(State previous, int... content) {
    this.content = content;
    this.previous = previous;
  }

  Iterable<State> adjacentStates() {
    List<State> result = new ArrayList<>();
    for (int i = 0; i < content.length; i++) {
      for (int j = 0; j < content.length; j++) {
        if (i != j) {
          int[] newContent = Arrays.copyOf(content, content.length);
          int movedQuantity = Math.min(content[i], capacity[j] - content[j]);
          newContent[i] -= movedQuantity;
          newContent[j] += movedQuantity;
          result.add(new State(this, newContent));
        }
      }
    }
    return result;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(content);
  }

  @Override
  public boolean equals(Object obj) {
    return Arrays.equals(content, ((State) obj).content);
  }

  @Override
  public String toString() {
    return Arrays.toString(content);
  }
}
