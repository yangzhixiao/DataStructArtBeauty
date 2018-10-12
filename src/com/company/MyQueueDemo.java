package com.company;

public class MyQueueDemo {

    private String[] items;

    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private int n = 8;

    public MyQueueDemo(int capacity) {
        n = capacity;
        items = new String[n];
    }

    public boolean enqueue(String item) {
        // 队满
        if (size == n) {
            System.out.println("队满");
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        size++;
        return true;
    }

    public String dequeue() {
        // 队空
        if (size == 0) {
            System.out.println("队空");
            return null;
        }
        String item = items[head];
        items[head] = null;
        head = (head + 1) % n;
        size--;
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String item : items) {
            if (item == null) {
                sb.append("0 -> ");
            } else {
                sb.append(item.toString() + " -> ");
            }
        }
        return sb.toString() + " total：" + size;
    }

    public static void main(String[] args) {
        MyQueueDemo queue = new MyQueueDemo(3);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        queue.dequeue();

        queue.enqueue("d");
        queue.enqueue("aa");
        queue.enqueue("ee");

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.dequeue();
        queue.enqueue("3");
    }

}
