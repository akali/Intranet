import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by aqali on 26.11.2017.
 */
public class Util {
    static int pickView(Vector vector, String name) {
        System.out.println("Pick " + name + "s");
        int cnt = 1;
        for (Object o : vector) {
            System.out.println(cnt++ + ". " + o);
        }
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.close();
        return x;
    }

    static int pickView(String name, Object... items) {
        System.out.println("Pick " + name + "s");
        int cnt = 1;
        for (Object o : items) {
            System.out.println(cnt++ + ". " + o);
        }
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.close();
        return x;
    }
    public static String askGet(Scanner sc, String message) {
        System.out.println(message);
        return sc.next();
    }

    public static String hashIt(String s) {
        return String.valueOf(Objects.hash(s));
    }
    static void Serialize(Object o, String filename) {
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(o);
            oout.close();
            fout.close();
        } catch(Exception e) {

        }
    }
    static Object Deserialize(String filename) {
        Object result = null;
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream oin = new ObjectInputStream(fis);
            result = oin.readObject();
            oin.close();
            fis.close();
        } catch(Exception e) {

        }
        return result;
    }
}
