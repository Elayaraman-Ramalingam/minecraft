package in.elayaramanramalingam.ohara.dao;

import java.util.HashSet;
import java.util.Set;

import in.elayaramanramalingam.ohara.model.Task;

public class TaskDAO {

    Set<Task> tasks = new HashSet<>();

    public Set<Task> findAll() {
        return tasks;
    }

    public void create(Task task) {
        tasks.add(task);
    }

    public void update(int id, Task task) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t = task;
                break;
            }
        }
    }

    public void delete(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setActive(false);
                break;
            }
        }
    }

    public Task findById(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
