package com.CSC340.CRUDAppAssignment4.Goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goals")
public class GoalController {
    @Autowired
    GoalService goalService;

    @PostMapping("/create")
    public String addNewGoal(Goal goal){
        goalService.addNewGoal(goal);
        return "redirect:/goals/all";
    }

}
