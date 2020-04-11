package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("*** TEST 1: Department findById ***");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n*** TEST 2: Department findAll ***");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n*** TEST 3: Insert Implementation ***");
		Department newDep = new Department(null, "Flat earth");
		departmentDao.insert(newDep);
		System.out.println("Deparment inserted. New id: " + newDep.getId());
		
		System.out.println("\n*** TEST 4: UPDATE Implementation ***");
		dep = departmentDao.findById(7);
		dep.setName("Drinks");
		departmentDao.update(dep);
		System.out.println("Update completed.");		
		
		System.out.println("\n*** TEST 5: DELETE Implementation ***");
		departmentDao.deleteById(7);
		System.out.println("Delete completed.");	
		
		sc.close();
	}

}
