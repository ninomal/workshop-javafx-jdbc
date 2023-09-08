package model.service;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService {

	public List<Department> findAll(){
		List<Department> depart = new ArrayList<>();
		depart.add(new Department(1, "manga"));
		depart.add(new Department(2, "tv"));
		depart.add(new Department(3, "celphone"));
		depart.add(new Department(4, "rooms"));
		return depart;
	}
}
