package com.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.todo.model.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, Long> {

}
