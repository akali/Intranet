package projectoop;

import java.io.File;
import java.util.Scanner;

/**
 * Created by aqali on 26.11.2017.
 */
public class MainTester {
    public static void main(String[] argv) {
        StorageSingletone.setInstance(StorageSingletone.load());
        StorageSingletone storage = StorageSingletone.getInstance();

        System.out.println(storage);

        if (!(new File("save").exists()))
            init();

        Util.Scanner sc = Util.getReadingScanner();

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
        System.out.println(p.toString());
        while (p.view());
        System.out.println("Bye!");
        StorageSingletone.getInstance().save();
    }

    private static void init() {
        Admin admin = new Admin();
        admin.setPassword("1");
        Student student = new Student();
        student.setPassword("1");
        student.setFaculty(Faculty.FIT);

        Person manager = new Manager();
        manager.setPassword("1");
        Executor executor = new Executor();
        executor.setPassword("1");
        Teacher teacher = new Teacher();
        teacher.setPassword("1");

        System.out.println(StorageSingletone.getInstance().insertAndGenerateId(admin));
        System.out.println(StorageSingletone.getInstance().insertAndGenerateId(student));
        System.out.println(StorageSingletone.getInstance().insertAndGenerateId(manager));
        System.out.println(StorageSingletone.getInstance().insertAndGenerateId(executor));
        System.out.println(StorageSingletone.getInstance().insertAndGenerateId(teacher));

        Course c = new Course("OOP",
                "OOP",
                (Teacher) StorageSingletone.getInstance().getTeachers().toArray()[0],
                3,
                Faculty.FIT);
        StorageSingletone.getInstance().addCourse(c);
    }
}
