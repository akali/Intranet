import java.util.HashMap;

/**
 * Created by aqali on 27.11.2017.
 */
public class Storage {
    private static HashMap<String, Person> people = new HashMap<>();


    public static Person getPerson(String login) throws UserNotFoundException {
        if (!people.containsKey(login))
            throw new UserNotFoundException();
        return people.get(login);
    }

    public static void removePerson(String id) {
    }
}
