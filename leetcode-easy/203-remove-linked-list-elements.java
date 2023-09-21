//  LeetCode - 203. Remove Linked List Elements
//  https://leetcode.com/problems/remove-linked-list-elements
//  time to solve: 24:45 (Sep 20 2023)
//  optimized solution consulted:
//  https://leetcode.com/problems/remove-linked-list-elements/solutions/1572932/java-three-simple-clean-solutions-w-explanation-iterative-recursive-beats-100/
//  TODO:   simplify problem to its essence (too concerned about edge cases)
//          consider loop invarients
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
    public ListNode removeElements(ListNode head, int val) {
        /*
        *   iterate over linkedList with two pointers, check curr status and remove if val
        */
        while(head != null && head.val == val){
            head = head.next;
        }
        ListNode curr = head, prev = null;
        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}