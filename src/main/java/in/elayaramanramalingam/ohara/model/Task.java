package in.elayaramanramalingam.ohara.model;

import java.time.*;

public class Task {
	
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
	public LocalDate getDue() {
		return due;
	}
    public void setDue(int daysToAdd) {
        LocalDate currentDate = LocalDate.now();
        this.due = currentDate.plusDays(daysToAdd);
    }
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", due=" + due + ", status=" + status + "]";
	}
	
	int id;
	String name;
	LocalDate due;
	boolean status;

}
