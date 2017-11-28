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
        Admin a = new Admin("1", "!", "1", 1);
//        a.view();
        Scanner sc = new Scanner(System.in);

        Person p = null;
        String login;
        String password;
        while (true) {
            login = Util.askGet(sc, "id: ");
            password = Util.hashIt(Util.askGet(sc, "password: "));
            try {
                p = Storage.getPerson(login);
                if (p.getPassword().equals(password))
                    break;
            } catch (UserNotFoundException ignored) {}
            System.out.println("Wrong login/password");
        }

        while (true) {
            if (!p.view()) {
                break;
            }
        }
        System.out.println("Bye!");
    }
}
