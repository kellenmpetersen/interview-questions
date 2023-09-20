# Two-Pointer in Linked List

##  Template

    // Initialize slow & fast pointers
    ListNode slow = head;
    ListNode fast = head;
    /**
    * Change this condition to fit specific problem.
    * Attention: remember to avoid null-pointer error
    **/
    while (slow != null && fast != null && fast.next != null) {
        slow = slow.next;           // move slow pointer one step each time
        fast = fast.next.next;      // move fast pointer two steps each time
        if (slow == fast) {         // change this condition to fit specific problem
            return true;
        }
    }
    return false;   // change return value to fit specific problem

##  Remember

1. Examine if a node is null before calling .next on it (node.next is a node in and of itself)
2. Verify loop termination conditions

## Time and Space Analysis

Time Complexity: O(n)   (usually)

Space Complexity: O(1)  (if no extra space used other than the two pointers)

## Source

https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1216/