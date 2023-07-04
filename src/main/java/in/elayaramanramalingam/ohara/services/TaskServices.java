package in.elayaramanramalingam.ohara.services;

import in.elayaramanramalingam.ohara.model.Task;
import in.elayaramanramalingam.ohara.validation.TaskValidator;
import in.elayaramanramalingam.ohara.dao.TaskDAO;

public class TaskServices {
	TaskDAO taskDAO = new TaskDAO();
	
	public Task[] getAll() {
		
		TaskDAO taskDAO = new TaskDAO();
		
		Task[] taskList = taskDAO.findAll();
		
		for(int i = 0; i < taskList.length;i++) {
			System.out.println(taskList[i]);
		}
		
		return taskList;	
		
	}
	
	public void create (Task task) throws Exception {
		TaskValidator.validate(task);
		taskDAO.create(task);
	}
	public void update (int id,Task task) throws Exception {
		TaskValidator.validate(task);
		taskDAO.update(id, task);
	}

}
