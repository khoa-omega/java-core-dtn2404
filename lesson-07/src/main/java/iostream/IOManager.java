package iostream;

import java.io.*;

public class IOManager {
    public static void writeBytes(
            String path,
            byte[] bytes,
            boolean append
    ) throws IOException {
        try (
                FileOutputStream fos = new FileOutputStream(path, append);
        ) {
            fos.write(bytes);
        }
    }

    public static String readBytes(String path) throws IOException {
        try (
                FileInputStream fis = new FileInputStream(path);
        ) {
            byte[] bytes = new byte[1024];
            int length = fis.read(bytes);
            return new String(bytes, 0, length);
        }
    }

    public static void writeObject(
            String path,
            Object object,
            boolean append
    ) throws IOException {
        try (
                FileOutputStream fos = new FileOutputStream(path, append);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(object);
        }
    }

    public static Object readObject(String path)
            throws IOException, ClassNotFoundException {
        try (
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return ois.readObject();
        }
    }
}
