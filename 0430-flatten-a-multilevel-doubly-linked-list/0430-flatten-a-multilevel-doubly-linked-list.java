/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        
        while (curr != null) {
            // If there is no child, we just move to the next node
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }
            
            // If there is a child, we find the tail of this child list
            Node childTail = curr.child;
            while (childTail.next != null) {
                childTail = childTail.next;
            }
            
            // Connect the child tail to the current node's next node
            childTail.next = curr.next;
            if (curr.next != null) {
                curr.next.prev = childTail;
            }
            
            // Connect the current node to the child head
            curr.next = curr.child;
            curr.child.prev = curr;
            
            // Clear the child pointer since it's now flattened
            curr.child = null;
            
            // Move forward
            curr = curr.next;
        }
        
        return head;
    }
}