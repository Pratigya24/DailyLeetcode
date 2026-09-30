class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1); // Head of our new sorted list
        ListNode curr = head;              // Node we want to insert right now

        while (curr != null) {
            // 1. Save the next node to process before we change curr.next
            ListNode nextNode = curr.next;

            // 2. Start from the dummy to find where 'curr' fits in the sorted list
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // 3. Insert 'curr' between 'prev' and 'prev.next'
            curr.next = prev.next;
            prev.next = curr;

            // 4. Move to the next node in the original list
            curr = nextNode;
        }

        return dummy.next;
    }
}