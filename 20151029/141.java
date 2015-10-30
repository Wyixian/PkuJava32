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
    public boolean hasCycle(ListNode head) {
        //without using extra space
        //faster每次走两步， slower每次走一步，若有环 一定会相遇
        //第一种情况：faster=i+1,slower=i,后退一步均为i-1,相遇了
        //第二种情况：faster=i+2,slower=i,后退一步分别为i,i-1，回到第一种情况,相遇了
        boolean result = false;
        // if(head == null || head.next == null ){
        //     result = false;
        // }else{
        //     ListNode faster = head;
        //     ListNode slower = head;
        //     //if(slower.next != null && faster.next.next != null){
        //     while(slower.next != null && faster.next.next != null){
        //         slower = slower.next;
        //         faster = faster.next.next;
        //         if(slower == faster){
        //             result =  true;
        //             break;
        //         }
        //     //}
        //     }
        // }
        ListNode faster = head;
        ListNode slower = head;
        while(faster != null && slower != null){
            slower = slower.next;
            faster = faster.next;
            if(faster == null || faster.next == null){
                break;
            }else{
                faster = faster.next;
                if(faster == slower){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}