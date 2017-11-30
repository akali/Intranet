package projectoop;

import java.util.*;
import java.util.function.Predicate;

public class Manager extends Employee {
    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        OfficeRegister, Department
    }

    private Type type;

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Manager manager = (Manager) o;

        return type == manager.type;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public void update() {
        super.update();
        switch (Util.pickView("Manager type",
                "Office Register",
                "Department")) {
            case 1:
                setType(Type.OfficeRegister);
                break;
            case 2:
                setType(Type.Department);
                break;
            default:
                break;
        }
    }

    public Manager() {
        super();
    }

    public Manager(String id, String password, String name, int salary, Type type) {
		super(id, password, name, salary);
		this.type = type;
	}

	public void addNews() {
        StorageSingletone.getInstance().addNews(News.create(this));
    }
    
    public void removeNews(News n) {
        StorageSingletone.getInstance().removeNews(n);
    }

    @Override
    public boolean view() {
        switch (Util.pickView("action",
                "View registrations",
                "Create report",
                "Manage news",
                "Exit")) {
            case 1:
                viewRegistrations();
                break;
            case 2:
                System.out.println(createReport());
                break;
            case 3:
                manageNews();
                break;
            case 4:
                return false;
            default:
                break;
        }
        return true;
    }

    private void manageNews() {
        switch (Util.pickView("action",
                "View news",
                "Add news",
                "Cancel")) {
            case 1:
                viewNews();
                break;
            case 2:
                addNews();
                break;
            case 3:
                manageNews();
                break;
            default:
                break;
        }
    }

    private void viewNews() {
        TreeSet<News> news = StorageSingletone.getInstance().getNews();
        int num = Util.pickView(news, "news") - 1;
        if (num < 0 || num >= news.size()) {
            System.out.println("Wrong input");
            return;
        }
        News picked = (News) Util.getPicked(news, num);
        switch (Util.pickView("action",
                "Remove",
                "Cancel")) {
            case 1:
                removeNews(picked);
                break;
            default:
                break;
        }
    }

    private String createReport() {
        int numberOfRetakers =
                (int) StorageSingletone.getInstance()
                .getStudents()
                        .stream()
                .filter(student -> {
                    for (Course c : student.getCourses())
                        if (student.getMark(c).getTotal() < 50)
                            return true;
                    return false;
                }).count();
        return "numberOfRetakers = " + numberOfRetakers;
    }

    private void viewRegistrations() {
        HashSet<Registration> registrations = StorageSingletone.getInstance().getRegistrations();
        int num = Util.pickView(registrations, "registration") - 1;
        if (num < 0 || num >= registrations.size()) {
            System.out.println("Wrong input");
            return;
        }
        Registration picked = (Registration) Util.getPicked(registrations, num);
        switch (Util.pickView("action", "Accept",
                "Reject",
                "Cancel")) {
            case 1:
                acceptRegistration(picked);
                break;
            case 2:
                rejectRegistration(picked);
                break;
            default:
                break;
        }
    }

    private void rejectRegistration(Registration picked) {
        picked.rejectRegitration();
        StorageSingletone.getInstance().removeRegistration(picked);
    }

    private void acceptRegistration(Registration picked) {
        Object[] teachers =
                StorageSingletone.getInstance().getTeachers().stream().filter(
                        teacher -> (teacher.getCourses().contains(picked.getCourse()))
                ).toArray();
        int num = Util.pickView("teacher", teachers) - 1;
        if (num < 0 || num >= teachers.length) {
            System.out.println("Wrong input");
            return;
        }
        Teacher pickedTeacher = (Teacher) teachers[num];
        picked.acceptRegistration(pickedTeacher);
        StorageSingletone.getInstance().removeRegistration(picked);
    }
}

