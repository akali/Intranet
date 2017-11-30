package projectoop;

import java.util.Scanner;

public class Admin extends Employee {
    StorageSingletone storage = StorageSingletone.getInstance();
    public void createEntity() {
        int num = Util.pickView("entity",
                "Student",
                "Teacher",
                "Admin",
                "Manager",
                "Executor",
                "Cancel");
        if (num > 6) System.out.println("Wrong input");
        if (num >= 6) return;
        Person p = null;
        if (num == 1) p = new Student();
        if (num == 2) p = new Teacher();
        if (num == 3) p = new Admin();
        if (num == 4) p = new Manager();
        if (num == 5) p = new Executor();
        if (p != null) {
            p.create(p);
            String login = storage.insertAndGenerateId(p);
            p.setLogin(login);
            System.out.println("New entity with login = " + login + " have been created");
        }
    }

    public void removeEntity() {
        Scanner sc = Util.getReadingScanner();
        System.out.println("Enter login: ");
        String login = sc.next();
        storage.removeEntity(login);
    }

    public void updateEntity() throws UserNotFoundException {
        Scanner sc = Util.getReadingScanner();
        System.out.println("Enter login: ");
        String login = sc.next();
        Person p = storage.getPerson(login);
        p.update();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Admin admin = (Admin) o;

        return storage != null ? storage.equals(admin.storage) : admin.storage == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (storage != null ? storage.hashCode() : 0);
        return result;
    }

    @Override
    public boolean view() {
        switch (Util.pickView("action",
                "Create",
                "Update",
                "Delete",
                "Exit")) {
            case 1:
                createEntity();
                break;
            case 2:
                try {
                    updateEntity();
                } catch (UserNotFoundException e) {
                    // e.printStackTrace();
                    System.out.println("No such user");
                }
                break;
            case 3:
                removeEntity();
                break;
            case 4:
                return false;
            default:
                System.out.println("Incorrect command!");
                break;
        }
        return true;
    }

}

