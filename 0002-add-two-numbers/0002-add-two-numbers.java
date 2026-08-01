/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Initialize a dummy node to simplify handling the head of the result list [1].
        ListNode current = dummyHead;
        int carry = 0; // Initialize carry to 0 [1].

        // Iterate through both linked lists and the carry [1].
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0; // Get digit from l1, or 0 if l1 is exhausted.
            int y = (l2 != null) ? l2.val : 0; // Get digit from l2, or 0 if l2 is exhausted.

            int sum = x + y + carry; // Calculate the sum of current digits and carry [1].
            carry = sum / 10; // Update the carry for the next calculation [1].

            current.next = new ListNode(sum % 10); // Create a new node with the digit part of the sum.
            current = current.next; // Move to the next node in the result list.

            if (l1 != null) {
                l1 = l1.next; // Move to the next node in l1.
            }
            if (l2 != null) {
                l2 = l2.next; // Move to the next node in l2.
            }
        }
        return dummyHead.next; // The result list starts from the node after the dummy head.
    }
}