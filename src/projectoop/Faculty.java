package projectoop;

public enum Faculty {
    FIT, BS, ISE;

    public static Faculty create() {
        return Faculty.values()[Util.pickView("faculty", (Object[]) values()) - 1];
    }
}
