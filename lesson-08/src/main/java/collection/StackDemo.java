package collection;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        // Last In - First Out
        Stack<Integer> stack = new Stack<>();

        // Thêm phần tử vào đỉnh stack
        stack.add(1);
        System.out.println("stack = " + stack);
        stack.add(2);
        System.out.println("stack = " + stack);
        stack.add(3);
        System.out.println("stack = " + stack);
        stack.add(4);
        System.out.println("stack = " + stack);

        // Xem phần tử ở đỉnh
        Integer peek = stack.peek();
        System.out.println("peek = " + peek);
        System.out.println("stack = " + stack);

        // Lấy phần tử ở đỉnh
        Integer pop = stack.pop();
        System.out.println("pop = " + pop);
        System.out.println("stack = " + stack);

        // Lặp
        while (!stack.empty()) {
            Integer top = stack.pop();
            System.out.println("top = " + top);
            System.out.println("stack = " + stack);
        }
    }
}
