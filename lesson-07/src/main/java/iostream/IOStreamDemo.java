package iostream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class IOStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "abc.txt";

        byte[] bytes = "Java Core".getBytes(StandardCharsets.UTF_8);
        IOManager.writeBytes(path, bytes, true);
        IOManager.writeBytes(path, bytes, true);
        IOManager.writeBytes(path, bytes, false);

        String content = IOManager.readBytes(path);
        System.out.println("content = " + content);

        Car car = new Car("Vinfast", "Black");
        IOManager.writeObject(path, car, false);
        Car object = (Car) IOManager.readObject(path);
        System.out.println("object = " + object);
    }
}
