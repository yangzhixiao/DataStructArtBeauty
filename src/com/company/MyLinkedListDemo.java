package com.company;

public class MyLinkedListDemo {

    private Integer capacity;
    private Node head;
    private Node tail;

    public MyLinkedListDemo() {
        this.capacity = 0;
        this.head = null;
        this.tail = null;
    }

    public void insertBefore(Object before, Object data) {
        Node targetNode = findNode(before);
        if (targetNode == head) {
            prepend(data);
            return;
        }

        capacity ++;
        Node node = new Node();
        node.data = data;

        Node prevNode = targetNode.prev;

        targetNode.prev = node;
        node.next = targetNode;
        node.prev = prevNode;
        prevNode.next = node;

    }

    public void append(Object data) {
        capacity ++;
        Node node = new Node();
        node.data = data;

        // 第一个节点
        if (head == null && tail == null) {
            head = node;
            tail = node;
            return;
        }

        // 接到尾部
        tail.next = node;
        node.prev = tail;

        if (tail == head) {
            tail.prev = node;
        }

        // 重制尾部节点
        tail = node;
    }

    public void prepend(Object data) {
        capacity ++;
        Node node = new Node();
        node.data = data;

        node.next = head;
        head.prev = node;

        head = node;
    }

    public void remove(Object data) {
        if (getCapacity() == 0) {
            return;
        }

        if (getCapacity() == 1) {
            head = null;
            tail = null;
            capacity --;
            return;
        }

        Node node = findNode(data);
        Node prevNode = node.prev;
        Node nextNode = node.next;

        if (prevNode != null) {
            prevNode.next = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }
        capacity --;
    }

    public Node findNode(Object data) {
        Node node = head;
        while (node != null) {
            if (node.data.equals(data)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    @Override
    public String toString() {
        if (getCapacity() == 0) {
            return "空";
        }
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null) {
            if (node.next == null) {
                sb.append(node.data.toString());
            } else {
                sb.append(node.data.toString() + " -> ");
            }
            node = node.next;
        }
        return sb.toString();
    }

    class Node {
       private Node prev;
       private Node next;
       private Object data;

       public Node() {
       }

       public Node(Node prev, Node next, Object data) {
           this.prev = prev;
           this.next = next;
           this.data = data;
       }

       public Node getPrev() {
           return prev;
       }

       public void setPrev(Node prev) {
           this.prev = prev;
       }

       public Node getNext() {
           return next;
       }

       public void setNext(Node next) {
           this.next = next;
       }

       public Object getData() {
           return data;
       }

       public void setData(Object data) {
           this.data = data;
       }
   }

    public static void main(String[] args) {
        MyLinkedListDemo linkedList = new MyLinkedListDemo();
        linkedList.append("1");
        linkedList.append("iii");
        linkedList.append("3");
        linkedList.prepend("0");
        linkedList.insertBefore("3", "2");
        linkedList.remove("iii");
        System.out.println(linkedList);

        System.out.println(isRW("我去你去我"));
        System.out.println(isRW("我去你去我哦"));
        System.out.println(isRW("我去你暗我"));
        System.out.println(isRW("我暗你暗我"));

        MyLinkedListDemo linkedList2 = new MyLinkedListDemo();
        linkedList2.append("1");
        linkedList2.append("2");
        System.out.println(linkedList2);
        linkedList2.remove("1");
        linkedList2.remove("2");
        System.out.println(linkedList2);

    }

    /**
     * 判断是否为回文字符串
     */
    public static boolean isRW(String str) {
        MyLinkedListDemo linkedList = new MyLinkedListDemo();
        for (Character c : str.toCharArray()) {
            linkedList.append(c);
        }
        if (linkedList.getCapacity() % 2 == 0) {
            return false;
        }

        MyLinkedListDemo.Node head = linkedList.getHead();
        MyLinkedListDemo.Node tail = linkedList.getTail();
        for (int i = 0; i < linkedList.getCapacity() / 2; i++) {
            if (head.getData().equals(tail.getData())) {
                head = head.getNext();
                tail = tail.getPrev();
            } else {
                return false;
            }
        }

        return true;
    }

}
