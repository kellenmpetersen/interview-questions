//  Leetcode - 19. Remove Nth Node From End of List
//  https://leetcode.com/problems/remove-nth-node-from-end-of-list
//  time problem solving: ~20m
//  solution consulted:
//  https://leetcode.com/problems/remove-nth-node-from-end-of-list/solutions/1164542/js-python-java-c-easy-two-pointer-solution-w-explanation/
//  TODO:   fast and slow nodes can mean different things . . . don't try and pigeonhole them into functioning the same way every problem.
//          also if you're type-casting like crazy to try and get your code to run that's probably:
//              1. not the solution
//              2. going to take too much time to compile to be worthwhile trying
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
class IncorrectFirstASolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        *   brainstorm:
        *       consider a LinkedList of length x. the node to remove is indexed at x - n, 
        *       where n is the nth node from the end of the list. x can be calculated in one pass.
        *       perhaps x - n could be reached in one pass by adding a ".next" modifer to a variable
        *       that stores the head location but truncating it by n times once the curr variable
        *       reaches the end. a prev variable could store x - n - 1, in order to get the node
        *       before the variable storing the nth-node.
        */
        ListNode curr = head, prev = head, nthNode = head;
        String prevModifier = "", nthNodeModifer = "";
        while(curr != null){
            prevModifier.concat(".next");
            nthNodeModifer.concat(".next");
            curr = curr.next;
        }
        if(prevModifier.length() > 0 && nthNodeModifer.length() > 0){
            prev = (ListNode)(Object) "prev".concat(prevModifier.substring(0,prevModifier.length()-(5*(n+1))));
            nthNode = (ListNode)(Object) "nthNode".concat(nthNodeModifer.substring(0,nthNodeModifer.length()-(5*n)));
        }
        prev.next = nthNode.next;
        return head;
    }
}