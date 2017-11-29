package projectoop;

public class Mark {


    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;
    private double total;

    public Mark() {
        firstAttestation = -1;
        secondAttestation = -1;
        finalExam = -1;
    }

    public String toLetter() {
        if (getTotal() > 95) return "A";
        else if (getTotal() > 90 && getTotal() < 95) return "-A";
        else if (getTotal() > 85 && getTotal() < 90) return "+B";
        else if (getTotal() > 80 && getTotal() < 85) return "B";
        else if (getTotal() > 75 && getTotal() < 80) return "-B";
        else if (getTotal() > 70 && getTotal() < 75) return "+C";
        else if (getTotal() > 65 && getTotal() < 70) return "C";
        else if (getTotal() > 60 && getTotal() < 65) return "-C";
        else if (getTotal() > 55 && getTotal() < 60) return "D";
        else if (getTotal() > 50 && getTotal() < 55) return "-D";
        else return "FAIL";
    }

    public double getFinalExam() {
        return finalExam;
    }

    public double getTotal() {
        return total;
    }

    public double getFirstAttestation() {
        if (firstAttestation == -1) return 0;
        else return firstAttestation;
    }

    public double getSecondAttestation() {
        if (secondAttestation == -1) return 0;
        else return secondAttestation;
    }

    public void addMark(double points) {
        if (getFirstAttestation() == -1) {
            total = +points;
            firstAttestation = points;
        } else if (getFirstAttestation() > -1 && getSecondAttestation() == -1) {
            total = +points;
            secondAttestation = points;
        } else if (getFirstAttestation() > -1 && getSecondAttestation() > -1 && getFinalExam() == -1) {
            total = +points;
            finalExam = points;
        }
    }

    public String toString() {
        if (firstAttestation == -1) return "1.0" + "  " + "2.0" + " " + "3.0";
        else if (firstAttestation > -1 && secondAttestation == -1)
            return "1." + firstAttestation + " " + "2.0" + " " + "3.0";
        else if (firstAttestation > -1 && secondAttestation > -1 && finalExam == -1)
            return "1." + firstAttestation + " " + "2." + secondAttestation + " " + "3.0";
        else if (firstAttestation > -1 && secondAttestation > -1 && finalExam > -1)
            return "1." + firstAttestation + " " + "2." + secondAttestation + " " + "3." + finalExam;
        else return "1.0" + "  " + "2.0" + " " + "3.0";
    }

    public double toNumber() {
        if (getTotal() > 95) return 4.0;
        else if (getTotal() > 90 && getTotal() < 95) return 3.67;
        else if (getTotal() > 85 && getTotal() < 90) return 3.33;
        else if (getTotal() > 80 && getTotal() < 85) return 3.0;
        else if (getTotal() > 75 && getTotal() < 80) return 2.67;
        else if (getTotal() > 70 && getTotal() < 75) return 2.33;
        else if (getTotal() > 65 && getTotal() < 70) return 2.0;
        else if (getTotal() > 60 && getTotal() < 65) return 1.67;
        else if (getTotal() > 55 && getTotal() < 60) return 1.33;
        else if (getTotal() > 50 && getTotal() < 55) return 1.0;
        else return 0;
    }
}