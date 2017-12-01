package projectoop;

import java.io.Serializable;

public class Mark implements Serializable, Viewable {
    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;
    private double total;

    public Mark() {
        firstAttestation = 0;
        secondAttestation = 0;
        finalExam = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark = (Mark) o;

        if (Double.compare(mark.firstAttestation, firstAttestation) != 0) return false;
        if (Double.compare(mark.secondAttestation, secondAttestation) != 0) return false;
        if (Double.compare(mark.finalExam, finalExam) != 0) return false;
        return Double.compare(mark.total, total) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(firstAttestation);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(secondAttestation);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(finalExam);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String toLetter() {
        if (retake()) return "F";
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

    private boolean retake() {
        return (firstAttestation + secondAttestation < 30) || (getFinalExam() < 20);
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

    public double toNumber() {
        if (getFinalExam() < 20) return 0;
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

    @Override
    public boolean view() {
        System.out.println(pretty());
        int num = Util.pickView("item",
                "First Attestation",
                "Second Attestation",
                "Final Exam",
                "Cancel");
        double d = Util.getReadingScanner().nextDouble();
        switch (num) {
            case 1:
                firstAttestation = d;
                break;
            case 2:
                secondAttestation = d;
                break;
            case 3:
                finalExam = d;
                break;
            case 4:
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "firstAttestation=" + firstAttestation +
                ", secondAttestation=" + secondAttestation +
                ", finalExam=" + finalExam +
                ", total=" + total +
                '}';
    }

    public String pretty() {
        return toString();
    }
}