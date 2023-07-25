package in.elayaramanramalingam.ohara;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.elayaramanramalingam.ohara.model.Task;
import in.elayaramanramalingam.ohara.services.TaskServices;
import in.elayaramanramalingam.ohara.exception.ValidationException;

public class TestCreateTask {

		TaskServices taskServices = new TaskServices();

	@Test
	public void testCreateTaskWithValidInput() {
		Task task = new Task();
		task.setId(01);
		task.setName("Anime");
		task.setDue("07 08 2023");
		task.setStatus(true);
		
		assertDoesNotThrow(()->{
			taskServices.create(task);
		});

	}
	
	@Test
	public void testCreateTaskWithInvalidInput() throws Exception{
		Exception exception = assertThrows(Exception.class, ()->{
			taskServices.create(null);
		});
		String exceptedMessage = "Invalid user input";
		String actualMessage = exception.getMessage();
		
		assertTrue(exceptedMessage.equals(actualMessage));
	}
	@Test
	public void testCreateTaskWithNameNull() {
		Task task = new Task();
		task.setId(01);
		task.setName(null);
		task.setDue("07 08 2023");
		task.setStatus(true);
		
		Exception exception = assertThrows(Exception.class, ()->{
			taskServices.create(task);
		});
		
		String exceptedMessage = "Name cannot be empty or null";
		String actualMessage = exception.getMessage();
		
		assertTrue(exceptedMessage.equals(actualMessage));

	}
	@Test
	public void testCreateTaskWithNameEmpty() {
		Task task = new Task();
		task.setId(01);
		task.setName("");
		task.setDue("07 08 2023");
		task.setStatus(true);
		
		ValidationException exception = assertThrows(ValidationException.class, ()->{
			taskServices.create(task);
		});
		
		String exceptedMessage = "Name cannot be empty or null";
		String actualMessage = exception.getMessage();
		
		assertTrue(exceptedMessage.equals(actualMessage));

	}

}
