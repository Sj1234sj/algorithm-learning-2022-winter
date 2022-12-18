/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    //将链表头为 headhead 的链表进行扁平化，并将扁平化后的头结点进行返回
    public Node flatten(Node head) {
        //如果head空，整个链表就为空
        if (head == null){
           return null;
        }
        //head不为空
        //定义头结点（哨兵位）
        Node node = head;
        child(head);
        return head;
    }

    public Node child(Node node){
        //遍历终止条件: 1.有子节点  2.下一个节点为null说明已经在当前层级尾部了
        while(node.child != null || node.next != null){
            if(node.child != null){
                //有子结点就递归
                Node child = child(node.child);
                //返回的child就是子节点那个层级的最后一个结点
                if(node.next != null){
                    //我们需要把child和当前结点的下u一个基点关联起来
                    child.next = node.next;//node = head?
                    node.next.prev = child;
                }
//此时已经不需要子节点了 把子节点变成当前节点的下一个节点
                node.next = node.child;
                node.child.prev = node;
                node.child = null;
                //子节点设置好后 继续向后遍历
                node = child;
            } else {
                //没有子节点就往后遍历
                node = node.next;
        }
    }
    return node;
}
}