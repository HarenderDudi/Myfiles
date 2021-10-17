package com.dudi.twitter.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;


@Document
public class User {

	@Id
	private String id;
	
	@Indexed(unique = true)
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Field("Date of birth")
	private Date dob;
	
	public User() {}
	
	public User(String name, Date dob) {
		super();
		this.name = name;
		this.dob = dob;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
}






////alphabetic = true - apart from id, name and dob, remaining properties will be in alphabetic order
////JsonRawValue = will map already serialized json to field, use this on field
//
////JsonAnyGetter - used on map, will use keys as property of json i.e flatten them
//
////@JsonPropertyOrder(value = {"id", "name", "dob"}, alphabetic = true)
//@Document
//public class User {
//
//	@Id
//	private String id;
//	
//	@Indexed(unique = true)
//	private String name;
//	
////	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
////	@JsonProperty("Date of birth")
//	@Field("Date of birth")
//	private Date dob;
//	
//	public User() {}
//	
//	public User(String name, Date dob) {
//		super();
//		this.name = name;
//		this.dob = dob;
//	}
//
//	public String getId() {
//		return id;
//	}
//	
//	public void setId(String id) {
//		this.id = id;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	//@JsonGetter("Date of birth", nulls = Nulls.AS_EMPTY) old alternative
//	public Date getDob() {
//		return dob;
//	}
//	
//	//@JsonSetter("Date of birth") // why it is not required
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}
//	
//	
//}
