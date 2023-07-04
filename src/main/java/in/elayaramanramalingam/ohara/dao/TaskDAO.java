package in.elayaramanramalingam.ohara.dao;

import in.elayaramanramalingam.ohara.model.Task;

public class TaskDAO {
	
	Task[] tasks = TaskList.lisofTasks;
	
	public Task[] findAll() {
		Task[] tasks = TaskList.lisofTasks;
		return tasks;
	}
	
	public void create(Task task) {
		
		for(int i =0;  i < tasks.length;i++) {
			Task index = tasks[i];
			if(index == null) {
				tasks[i] = task;
				break;
			}
		}
		
	}
	public void update(int id,Task task) {

		for (int i = 0; i < tasks.length; i++) {
			Task index = tasks[i];
			if (index.getId() == id) {
				index = task;
				break;
			}
		}
		
	}
	
	public void delete(int id) {
		
		for(int i =0;  i < tasks.length;i++) {
			Task index = tasks[i];
			if(index.getId() == id) {
				index.setStatus(false);;
				break;
			}
		}
		
	}
	public void findById(int id) {

		for (int i = 0; i < tasks.length; i++) {
			Task index = tasks[i];
			if (index.getId() == id) {
				return;
			}
		}
		
	}

}
