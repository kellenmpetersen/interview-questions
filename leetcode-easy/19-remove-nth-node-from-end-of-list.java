//  LeetCode - 19. Remove Nth Node From End of List
//  https://leetcode.com/problems/remove-nth-node-from-end-of-list
//  time to solve: 25:07 (Sep 18 2023)
//  solution consulted (for best time-complexity):
//  https://leetcode.com/problems/remove-nth-node-from-end-of-list/solutions/1164542/js-python-java-c-easy-two-pointer-solution-w-explanation/
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        *   brainstorm:
        *       consider a LinkedList of length x. the node to remove is indexed at x - n, 
        *       where n is the nth node from the end of the list. x can be calculated in one pass.
        *       perhaps x - n could be reached in one pass by adding a ".next" modifer to a variable
        *       that stores the head location but truncating it by n times once the curr variable
        *       reaches the end. a prev variable could store x - n - 1, in order to get the node
        *       before the variable storing the nth-node.
        *   trying to do this in one pass, the naive solution is obvious with two passes
        */
        ListNode fast = head, slow = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        if(fast == null){ 
            return head.next; 
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}