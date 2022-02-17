package com.dudi.ppmtool.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dudi.ppmtool.entity.Project;
import com.dudi.ppmtool.services.MapValidationErrorService;
import com.dudi.ppmtool.services.ProjectService;

@RestController
@CrossOrigin
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@Autowired
    private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("/project")
	public ResponseEntity<?> createProjectController(@Valid @RequestBody Project project, BindingResult result ) {
		
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
		
        Project project1 = projectService.createProject(project);
		return new ResponseEntity<Project>(project1, HttpStatus.CREATED);	
	}
	
	@PutMapping("/project")
	public ResponseEntity<?> updateProjectController(@Valid @RequestBody Project project, BindingResult result ) {
		
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
		
        Project project1 = projectService.updateProject(project);
		return new ResponseEntity<Project>(project1, HttpStatus.ACCEPTED);	
	}
	
	@GetMapping("/project/all")
	public ResponseEntity<?> getAllProjects(){
		List<Project> projects = projectService.getAllProjects();
		return new ResponseEntity<List>(projects, HttpStatus.OK);	
	}
	
	@GetMapping("/project/{id}")
	public ResponseEntity<?> getProjects(@PathVariable("id") String id){
		Project project = projectService.getProject(id);
		return new ResponseEntity<Project>(project, HttpStatus.OK);	
	}
	
}
