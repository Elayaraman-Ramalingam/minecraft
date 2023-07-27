package in.elayaramanramalingam.ohara.services;

import in.elayaramanramalingam.ohara.model.Task;
import in.elayaramanramalingam.ohara.validation.TaskValidator;

import java.util.List;
import java.util.Set;

import in.elayaramanramalingam.ohara.dao.TaskDAO;

public class TaskServices {
    TaskDAO taskDAO = new TaskDAO();

    public List<Task> getAll() {
        List<Task> taskList = taskDAO.findAll();
        for (Task task : taskList) {
            System.out.println(task);
        }
        return taskList;
    }

    public void create(Task task) throws Exception {
        TaskValidator.validate(task);
        taskDAO.create(task);
    }

    public void update(int id, Task task) throws Exception {
        TaskValidator.validate(task);
        taskDAO.update(id, task);
    }

    public void delete(int id) {
        taskDAO.delete(id);
    }

    public Task findById(int id) {
        return taskDAO.findById(id);
    }
}
