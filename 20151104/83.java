/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode currentNode = head;
        ListNode nextNode = head.next;
        while(nextNode != null){
            if(currentNode.val == nextNode.val){
                currentNode.next = nextNode.next;
                nextNode = nextNode.next;
            }else{
                currentNode = nextNode;
                nextNode = nextNode.next;
            }
        }
        return head;
    }
    // public ListNode deleteDuplicates(ListNode head) {
    //     if(head==null || head.next==null){
    //         return head;
    //     }
    //     //ListNode result= null;
    //     ListNode current = head;
    //     while(current.next != null){
    //         if(current.val == current.next.val){
    //             //result.add(current);
    //             current.next = current.next.next;
    
    //         }
    //         current = current.next;
    //     }
    //   // result.add(current);
    //     return head;
    // }
}