package com.cs.streams;

public class Employee {
	private int id;
	private String name;
	private int deptId;
	private String status = "active";
	private int salary;
	
	public Employee(int id, String name, int deptId, String status, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.status = status;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", deptId=" + deptId + ", status=" + status + ", salary="
				+ salary + "]";
	}
	
}
