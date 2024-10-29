package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        list1.add("A");
        list1.add("A");
        list1.add("A");
        list1.add("B");
        list1.add("C");
        System.out.println("list1 = " + list1);

        list1.add(0, "Z");
        System.out.println("list1 = " + list1);

        System.out.println("list1.size() = " + list1.size());
        System.out.println("list1.isEmpty() = " + list1.isEmpty());

        System.out.println("list1.contains(\"C\") = " + list1.contains("C"));
        System.out.println("list1.get(1) = " + list1.get(1));
        System.out.println("list1.indexOf(\"A\") = " + list1.indexOf("A"));

        list1.remove(2);
        list1.remove("Z");

        list1.clear();
        System.out.println("list1.size() = " + list1.size());
        System.out.println("list1.isEmpty() = " + list1.isEmpty());
    }
}
