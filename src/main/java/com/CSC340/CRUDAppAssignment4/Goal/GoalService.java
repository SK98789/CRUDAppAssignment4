package com.CSC340.CRUDAppAssignment4.Goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    GoalRepository goalRepository;

    public Object getAllGoals(){
        return goalRepository.findAll();
    }
    public void addNewGoal(Goal goal){
        goalRepository.save(goal);
    }
    public Object getGoalById(int id){
        return goalRepository.findById(id).orElse(null);
    }
}
