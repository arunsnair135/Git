package com.todo.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tasks")
public class Task {

//	@Transient
//	private static final String SEQUENCE_NAME= "user_sequence";
	
	@Id
	private Long id;
	private String name;
	private String description;
	private String date;

	public Task() {
		super();
	}
	
	public Task(Long id, String name, String description, String date) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}

	public void setId() {
		Date date = new Date();
		System.out.println(date.getTime());
	    id = (Long) date.getTime();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + "]";
	}

}
