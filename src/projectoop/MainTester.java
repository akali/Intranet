package projectoop;

import java.util.Scanner;

/**
 * Created by aqali on 26.11.2017.
 */
public class MainTester {
    public static void main(String[] argv) {
        StorageSingletone.setInstance(StorageSingletone.load());
        StorageSingletone storage = StorageSingletone.getInstance();

        System.out.println(storage);

        // init();

        Scanner sc = Util.getReadingScanner();

        Person p = null;
        String login;
        String password;
        while (true) {
            login = Util.askGet(sc, "id: ");
            password = Util.hashIt(Util.askGet(sc, "password: "));
            try {
                p = storage.getPerson(login);
                if (p.getPassword().equals(password))
                    break;
            } catch (UserNotFoundException ignored) {
            }
            System.out.println("Wrong login/password");
        }

        while (p.view());
        System.out.println("Bye!");
        StorageSingletone.getInstance().save();
    }

    private static void init() {
        Admin admin = new Admin();
        admin.setPassword("123");
        System.out.println(StorageSingletone.getInstance().insertAndGenerateId(admin));
    }
}
