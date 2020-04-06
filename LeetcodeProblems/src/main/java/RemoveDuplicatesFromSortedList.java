/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
 //Approach 1
class SortedList {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode curr = head;
    ListNode result = head;
    while(curr!= null){
      ListNode temp = curr;
      while(temp!=null && curr!=null && temp.val==curr.val){
        temp = temp.next;
      }
      result = curr;
      curr.next = temp;
      curr = curr.next;

    }
    return head;
  }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AnotherSolution {
  public ListNode deleteDuplicates(ListNode head) {
    if(head == null || head.next == null)
      return head;

    ListNode p = head;

    while( p!= null && p.next != null){
      if(p.val == p.next.val){
        p.next = p.next.next;
      }else{
        p = p.next;
      }
    }

    return head;

  }
}
public class RemoveDuplicatesFromSortedList{
  public static void main(String args[]){

  }
}