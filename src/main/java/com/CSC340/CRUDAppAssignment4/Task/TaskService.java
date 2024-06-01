package com.CSC340.CRUDAppAssignment4.Task;

import com.CSC340.CRUDAppAssignment4.Goal.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    /**
     * Save the specified task to the database
     * @param task is the task to save
     */
    public void addNewTask(Task task){
        taskRepository.save(task);
    }

    /**
     * Fetch the Task by its ID, or return null
     * @param id is the ID to search by
     * @return the task
     */
    public Task getTaskByID(int id){
        return taskRepository.findById(id).orElse(null);
    }

    /**
     * Fetch all tasks with the specific goal ID
     * @param goalId is the goal ID to search for
     * @return a list
     */
    public Object getAllTasksByGoal(int goalId){
        return taskRepository.getTasksByGoal(goalId);
    }


    /**
     * Delete the task with the specified ID
     * @param id is the ID to be deleted
     */
    public void deleteTaskById(int id){
        taskRepository.deleteById(id);
    }

}
