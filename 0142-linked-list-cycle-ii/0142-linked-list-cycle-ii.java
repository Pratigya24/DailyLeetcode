/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /////Approch 1
        // Set<ListNode> set = new HashSet<>();
        // ListNode curr = head;
        // while(curr != null){
        //     if(set.contains(curr)){
        //         return curr;
        //     }
        //     set.add(curr);
        //     curr=curr.next;
        // }
        // return null;

        //Approch 2
        if(head==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
       while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { 
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; 
            }
        }
        return null; 
    }
}