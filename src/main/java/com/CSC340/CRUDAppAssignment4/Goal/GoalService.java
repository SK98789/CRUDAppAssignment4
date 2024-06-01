package com.CSC340.CRUDAppAssignment4.Goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    GoalRepository goalRepository;

    /**
     * Fetches All Goals from the database
     * @return a list of all Goals
     */
    public Object getAllGoals(){
        return goalRepository.findAll();
    }

    /**
     * Saves a goal to the database
     * @param goal is the goal to be saved
     */
    public void addNewGoal(Goal goal){
        goalRepository.save(goal);
    }

    /**
     * Gets the goal from the database with the specified ID
     * @param id is the ID to find
     * @return the Goal
     */
    public Goal getGoalById(int id){
        return goalRepository.findById(id).orElse(null);
    }

    /**
     * Deletes the goal with the specified ID
     * @param id is the ID to be deleted
     */
    public void deleteGoalById(int id){
        goalRepository.deleteById(id);
    }
}
