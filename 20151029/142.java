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
        if(head == null ||head.next == null){
            return null;
        }
        ListNode faster = head;
        ListNode slower = head;
        while(true){
            slower = slower.next;
            faster = faster.next;
            if(faster == null || faster.next == null){
                break;
            }
            faster = faster.next;
            if(faster == slower){
                faster = head;
                while(true){
                    //当链中只有两个元素时
                    if(faster == slower){
                        return faster;
                    }
                    faster = faster.next;
                    slower = slower.next;
                    if(faster == slower){
                        return faster;
                    }
                }
            }
        }
        return null;
    }
}