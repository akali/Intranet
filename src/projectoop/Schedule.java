package projectoop;

import java.io.Serializable;
import sun.util.calendar.BaseCalendar.Date;

public class Schedule implements Serializable {
    private DAYS day;
    private Date time;
    
	public Schedule(DAYS day, Date time) {
		super();
		this.day = day;
		this.time = time;
	}

	public Schedule() {
		super();
	}
//methods:
	public DAYS getDay() {
		return day;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		if (day != other.day)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	public void setDay(DAYS day) {
		this.day = day;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

