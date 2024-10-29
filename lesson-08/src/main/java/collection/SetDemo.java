package collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        Set<Integer> set3 = new TreeSet<>();

        set3.add(5);
        set3.add(2);
        set3.add(8);
        set3.add(4);
        set3.add(7);
        set3.add(7);
        set3.add(7);
        System.out.println("set3 = " + set3);

        Set<Dog> set4 = new LinkedHashSet<>();
        set4.add(new Dog("B", 1));
        set4.add(new Dog("B", 1));
        set4.add(new Dog("B", 1));
        set4.add(new Dog("A", 3));
        set4.add(new Dog("C", 2));
        set4.add(new Dog("R", 4));
        for (Dog dog : set4) {
            System.out.println(dog);
        }
    }
}
