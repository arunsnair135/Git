package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.model.Task;
import com.todo.service.ToDoService;

@Controller
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;
	
	@RequestMapping("/allTasks")
	public List<Task> getHome() {
		return toDoService.getAllTasks();
	}
	
	@GetMapping("/addNew")
	public String getAddForm(Model model) {
		model.addAttribute("task", new Task());
		return "NewToDo";
	}
	
	@PostMapping("/addTask")
	public String addTask(@ModelAttribute Task task){
		toDoService.addNewTask(task);
		return "redirect:/index";
	}
	
	@GetMapping("/update/{id}")
	public String fetchTaskForUpdate(@PathVariable Long id, Model model) {
		model.addAttribute("updateTask", toDoService.getTaskById(id));
		return "UpdateForm";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable Long id) {
		toDoService.deleteTask(id);
		return "redirect:/index";
	}
	
	@PostMapping("/change/{id}")
	public String updateTask(@PathVariable Long id, @ModelAttribute Task task, Model model) {
		Task existingTask=toDoService.getTaskById(id);
		toDoService.saveUpdatedTask(existingTask,task);
		return "redirect:/index";
	}
	
	
}
