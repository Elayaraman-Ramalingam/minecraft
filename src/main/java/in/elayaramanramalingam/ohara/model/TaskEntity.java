package in.elayaramanramalingam.ohara.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskEntity {
	
	int id;
	String name;
	Date dueDate;
	boolean isActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(String string) {
        LocalDate localDate = LocalDate.parse(string, DateTimeFormatter.ISO_LOCAL_DATE);
        Date date = Date.valueOf(localDate);
        this.dueDate = date;
    }
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Task [id= " + id + ", name= " + name + ", dueDate= " + dueDate + ", isActive= " + isActive + "]";
	}

	public int compareTo(Task o) {
		return this.dueDate.compareTo(o.getDueDate());
	}

}
