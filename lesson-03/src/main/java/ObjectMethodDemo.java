import java.util.Objects;

public class ObjectMethodDemo {
    public static void main(String[] args) {
        // toString
        Dog dog = new Dog();
        dog.age = 1;
        dog.name = "ABC";
        System.out.println(dog);

        // equals
        Dog dog2 = new Dog();
        dog2.age = 2;
        dog2.name = "ABC";
        System.out.println(dog.equals(dog2));

        // hashCode
        // 1. Hai đối tượng equals bằng nhau thì có hashCode bằng nhau
        // 2. Hai đối tượng có hashCode bằng nhau thì chưa chắc equals bằng nhau
        System.out.println("dog.hashCode() = " + dog.hashCode());
        System.out.println("dog2.hashCode() = " + dog2.hashCode());
    }
}

class Dog {
    String name;
    int age;

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Dog)) return false;
        Dog thatDog = (Dog) that;
        return name.equals(thatDog.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
