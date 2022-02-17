package com.dudi.ppmtool.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.annotations.NotThreadSafe;

public class Project {

	@Id
	@JsonProperty("_id")
    private String id;
    
	@BsonId
	@JsonIgnore
	private ObjectId oid;
    
	@NotBlank(message = "Project name is required")
	private String projectName;
    
	@NotBlank(message = "Project Identifier is required")
    private String projectIdentifier;
    
	@NotBlank(message = "Project description is required")
    private String description;
    
    @JsonProperty(value = "startDate")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date start_date;
    
	@JsonProperty(value = "endDate")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date end_date;
    
    @JsonProperty(value = "createdOn")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_At;
    
    @JsonProperty(value = "updatedOn")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_At;

    public Project() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
    	this.id = id;
        this.oid = new ObjectId(id);
    }
    
    public ObjectId getOid() {
 		return oid;
 	}

 	public void setOid(ObjectId oid) {
 		 this.oid = oid;
         this.id = oid.toHexString();
 	}

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    protected void onCreate(){
        this.created_At = new Date();
    }

    protected void onUpdate(){
        this.updated_At = new Date();
    }

}