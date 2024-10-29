package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        // Last In - Last Out
        Queue<Integer> queue = new LinkedList<>();

        // Thêm phần tử vào cuối queue
        queue.offer(1);
        System.out.println("queue = " + queue);
        queue.offer(2);
        System.out.println("queue = " + queue);
        queue.offer(3);
        System.out.println("queue = " + queue);
        queue.offer(4);
        System.out.println("queue = " + queue);

        // Xem phần tử ở đầu queue
        Integer peek = queue.peek();
        System.out.println("peek = " + peek);
        System.out.println("queue = " + queue);

        // Lấy phần tử ở đầu queue
        Integer poll = queue.poll();
        System.out.println("poll = " + poll);
        System.out.println("queue = " + queue);

        // Lặp
        while (!queue.isEmpty()) {
            Integer first = queue.poll();
            System.out.println("first = " + first);
            System.out.println("queue = " + queue);
        }
    }
}
