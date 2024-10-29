package generic;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        // Generic: Lập trình tổng quát
        // T: Type
        // E: Element
        // N: Number
        // K: Key
        // V: Value

        // Generic method
        printAny(4);
        printAny(4.4);
        printAny(LocalDate.now());

        // Generic class
        Circle<Integer> c1 = new Circle<>(1, "Red");
        System.out.println("c1 = " + c1);
        Circle<Double> c2 = new Circle<>(2.0, "Blue");
        System.out.println("c2 = " + c2);

        // Wild card
        // N extends Number: N là con của Number
        // Circle<String> c3 = new Circle<>("abc", "Green");
        // System.out.println("c3 = " + c3);
        // N extends Number & Comparable<N>: N là con của Number và Comparable<N>
        int max = max(1, 100);
        System.out.println("max = " + max);

        // ? super E: List<?> là cha List<E>
        // ? extends E: List<?> là con List<E>
        List<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        List<Number> numbers = new LinkedList<>();
        add(integers, numbers);
        System.out.println("numbers = " + numbers);

        // ?: Không quan tâm kiểu dữ liệu (Kiểu bất kì)
        printSize(numbers);
    }

    public static void printSize(List<?> list) {
        System.out.println(list.size());
    }

    public static <E> void add(List<? extends E> from, List<E> to) {
        for (E element : from) {
            to.add(element);
        }
    }

    public static <N extends Number & Comparable<N>> N max(N a, N b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    public static <T> void printAny(T a) {
        System.out.println(a);
    }
}
