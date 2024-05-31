package com.CSC340.CRUDAppAssignment4.Task;

import com.CSC340.CRUDAppAssignment4.Goal.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public void addNewTask(Task task){
        taskRepository.save(task);
    }
    public Task getTaskByID(int id){
        return taskRepository.findById(id).orElse(null);
    }

    public Object getAllTasksByGoal(int goalId){
        return taskRepository.getTasksByGoal(goalId);
    }


    public void deleteTaskById(int id){
        taskRepository.deleteById(id);
    }

}
