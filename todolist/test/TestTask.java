import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.todo.entity.Task;
import com.todo.entity.User;
import com.todo.service.TaskService;
import com.todo.service.UserService;

public class TestTask{
	
	private TaskService t;
	private UserService u;
	
	@Before
	public void before(){
		 t = new TaskService();
		 u = new UserService();
	}
	
	@Test
	public void test() {
		try {
			Assert.assertTrue(t.taskList().getClass().equals(ArrayList.class));
			Assert.assertTrue(t.unfinishedTasks().getClass().equals(ArrayList.class));
			Assert.assertTrue(t.editTask("2").getClass().equals(Task.class));
			Assert.assertTrue(t.saveAddTask("1","1","1"));
			Assert.assertTrue(t.saveEditTask("1","1","1","1"));
			Assert.assertTrue(t.deleteTask("1"));
			Assert.assertTrue(t.doneTask("1"));
			User user = new User();
			user.setPassword("1");
			user.setLoginName("1");
			user.setUserName("1");
			Assert.assertTrue(u.registerSave(user ));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}