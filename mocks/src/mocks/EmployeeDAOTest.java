package mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class EmployeeDAOTest {

	@Test
	void testEmployeeDAO() {
		EmployeeDAO dao = mock(EmployeeDAO.class);
		int id  = anyInt();
		when(dao.get(id)).thenReturn(new Employee(id,"ABC",1000));
		Employee e = dao.get(id);
		assertEquals(id, e.id());
	}
	
	@Test
	void testEmployeeDAOGetAll() {
		EmployeeDAO dao = mock(EmployeeDAO.class);
		List emps = mock(List.class);
		when(emps.size()).thenReturn(2);
		when(emps.get(0)).thenReturn(new Employee(1,"ABC",100340));
		when(emps.get(1)).thenReturn(new Employee(2,"DEF",1000));
		when(dao.getAll()).thenReturn(emps);
		assertEquals(2, dao.getAll().size());
		assertEquals(1, dao.getAll().get(0).id());
		assertEquals(2, dao.getAll().get(1).id());
		
//		verify(dao.getAll(),times(3));
	}

}
