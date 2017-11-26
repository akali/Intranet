public class Mark {
private int firstAttestation;
private int secondAttestation;
private int final1;

//private Course course;
private Student student;
public int points = 0;
public int mark;


public void setPoints(int points) {
	this.points = points;
}
public double getPoints() {
	return this.points;
}


public void setMark(int mark) {
	this.mark = mark;
}
public int getMark() {
	return this.mark;
}

public void calculateMark(){
	if(this.points >= 95){
        this.mark = Grade.A;
    }
	else if(this.points >= 90 && this.points < 95){
        	this.mark = Grade.A_minus;
    }
	else if(this.points >= 85 && this.points < 90){
        	this.mark = Grade.B_plus;
    }
	else if(this.points >= 80 && this.points < 85){
        	this.mark = Grade.B;
    }
	else if(this.points >= 75 && this.points < 80){
    		this.mark = Grade.B_minus;
    }
	else if(this.points >= 70 && this.points < 75){
			this.mark = Grade.C_plus;
    }
	else if(this.points >= 65 && this.points < 70){
    		this.mark = Grade.C;
    }
	else if(this.points >= 60 && this.points < 65){
			this.mark = Grade.C_minus;
    }
	else if(this.points >= 55 && this.points < 60){
			this.mark = Grade.D_plus;
    }
	else if(this.points >= 50 && this.points < 55){
			this.mark = Grade.D;
    }
	else if(this.points < 50 ){
			this.mark = Grade.F;
    }
}


public int getfinal1() {
    return 0;
}
public void setfinal1(int final1) {
}
public int getSecondAttestation() {
    return 0;
}
public void setSecondAttestation(int secondAttestation) {
}
public int getFirstAttestation() {
    return 0;
}
public void setFirstAttestation(int firstAttestation) {
}
public void putMark(Teacher t, Mark m) {
}
}

