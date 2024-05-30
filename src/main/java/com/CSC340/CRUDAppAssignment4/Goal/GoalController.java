package com.CSC340.CRUDAppAssignment4.Goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("goalList", goalService.getAllGoals());
        return "Goals";
    }

    @GetMapping("/newGoal")
    public String getCreationForm(Model model){
        return "CreateAGoal";
    }
    @GetMapping("/{id}")
    public String getGoalById(@PathVariable int id, Model model) {
        model.addAttribute("goal", goalService.getGoalById(id));
        return "GoalDetails";
    }
    @GetMapping("/delete/{id}")
    public String deleteGoalByID(@PathVariable int id){
        goalService.deleteGoalById(id);
        return "redirect:/goals/all";
    }


}
