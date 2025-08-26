package io.tasklist;

public class ToDo {
	private String title;
	private boolean done;
	
	public ToDo(String title) {
		this.title = title;
		this.done= false;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
	public void markAsDone() {
		this.done = true;
	}
	
	public void markAsToDo() {
		this.done = false;
	}
	

}
