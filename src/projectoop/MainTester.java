package projectoop;

import java.util.Scanner;

/**
 * Created by aqali on 26.11.2017.
 */
public class MainTester {
    public static void main(String[] argv) {
        /**
         *
         * Do deserialization stuff
         */
        Scanner sc = new Scanner(System.in);

        Person p = null;
        String login;
        String password;
        while (true) {
            login = Util.askGet(sc, "id: ");
            password = Util.hashIt(Util.askGet(sc, "password: "));
            try {
                p = StorageSingletone.getPerson(login);
                if (p.getPassword().equals(password))
                    break;
            } catch (UserNotFoundException ignored) {
            }
            System.out.println("Wrong login/password");
        }

        while (p.view()) ;
        System.out.println("Bye!");
    }
}
