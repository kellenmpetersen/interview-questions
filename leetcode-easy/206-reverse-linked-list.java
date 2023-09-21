//  LeetCode - 206. Reverse Linked List
//  https://leetcode.com/problems/reverse-linked-list
//  time to solve: ~30:00 (Sep 20 2023)
//  optimized solution consulted:
//  https://leetcode.com/problems/reverse-linked-list/solutions/2682085/java-0ms-100-easy-understanding/
//  TODO:   simplify problem to its essence (too much concern about edge cases)
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
class BestSolution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
class MySolution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        int len = 1;
        if(curr == null){
            return null;
        }
        while(curr != null){
            prev = curr;
            curr = curr.next;
            len++;
        }
        ListNode newHead = prev;
        for(int i = len; i >= 0; i--){
            prev = null;
            curr = head;
            for(int j = 0; j < i; j++){
                if(curr == null){
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
            if(curr != null){
                curr.next = prev;
            }
        }
        return newHead;
    }
}