package projectoop;

import java.io.*;
import java.util.*;

/**
 * Created by aqali on 26.11.2017.
 */
public class Util {
    static class Scanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public Scanner(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
    private static Scanner readingScanner = new Scanner(System.in);

    static int pickView(Collection vector, String name) {
        System.out.println("Pick " + name + "s");
        int cnt = 1;
        for (Object o : vector) {
            System.out.println(cnt++ + ". " + o);
        }
        Scanner sc = Util.getReadingScanner();//new Scanner(System.in);
        return sc.nextInt();
    }

    static int pickView(String name, Object... items) {
        return pickView(new Vector(Arrays.asList(items)), name);
    }
    public static String askGet(Scanner sc, String message) {
        System.out.println(message);
        return sc.next();
    }

    public static String hashIt(String s) {
        return String.valueOf(Objects.hash(s));
    }
    static void Serialize(StorageSingletone o, String filename) {
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(o);
            oout.close();
            fout.close();
        } catch(Exception ignored) {

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
        } catch(Exception ignored) {

        }
        return result;
    }

    public static Scanner getReadingScanner() {
        return readingScanner;
    }

    public static Object getPicked(Set s, int num) {
        Iterator it = s.iterator();
        while (it.hasNext() && num-- > 0) {
            it.next();
        }
        return it.next();
    }
}
