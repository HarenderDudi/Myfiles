package com.dudi.ppmtool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dudi.ppmtool.daos.ProjectDao;
import com.dudi.ppmtool.entity.Project;

@Component
public class ProjectService {

	@Autowired
	ProjectDao projectDao;
	
	public Project createProject(Project project) {
		return projectDao.createProject(project);
	}

	public List<Project> getAllProjects() {
		return projectDao.getAllProjects();
	}
	
	public Project getProject(String id) {
		return projectDao.getProject(id);
	}
	
	public Project updateProject(Project project) {
		return projectDao.updateProject(project);
	}
	
}
