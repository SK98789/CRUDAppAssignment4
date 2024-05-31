package com.CSC340.CRUDAppAssignment4.Goal;

import com.CSC340.CRUDAppAssignment4.Task.TaskService;
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

    @Autowired
    TaskService taskService;

    /**
     * Creates a new goal, saves it to the database,
     * and redirects the user from the newGoal page to the all page
     * @param goal is the goal created on the newGoal page
     * @return a redirect to the all page
     */
    @PostMapping("/create")
    public String addNewGoal(Goal goal){
        goalService.addNewGoal(goal);
        return "redirect:/goals/all";
    }

    /**
     * Fetches the current goals in the database and displays them on the Goals.html page
     * @param model is the Model used for UI display
     * @return the html page to be displayed
     */
    @GetMapping("/all")
    public String getAllGoals(Model model) {
        model.addAttribute("goalList", goalService.getAllGoals());
        return "Goals";
    }

    /**
     * Displays the Goal creation html
     * @return the html page to be displayed
     */
    @GetMapping("/newGoal")
    public String getCreationForm(){
        return "CreateAGoal";
    }

    /**
     * Fetches a specific goal from the database and displays it in the goal details html
     * @param id is the ID for the specific goal to be displayed
     * @param model is the Model used for UI display
     * @return the html page to be displayed
     */
    @GetMapping("/{id}")
    public String getGoalById(@PathVariable int id, Model model) {
        model.addAttribute("goal", goalService.getGoalById(id));
        model.addAttribute("taskList", taskService.getAllTasksByGoal(id));

        return "GoalDetails";
    }

    /**
     * Deletes a specific goal from the database and redirects to the list of goals page
     * @param id is the id of the goal to delete
     * @return a redirect to the list of goals page
     */
    @GetMapping("/delete/{id}")
    public String deleteGoalByID(@PathVariable int id){
        goalService.deleteGoalById(id);
        return "redirect:/goals/all";
    }

    /**
     * Edits an already existing goal, saves the changes to the database, and redirects to the
     * specific goal's page
     * @param goal is the goal to edit
     * @return a redirect to the goal's page
     */
    @PostMapping("/edit")
    public String editGoal(Goal goal) {
        goalService.addNewGoal(goal);
        return "redirect:/goals/" + goal.getGoalId();
    }

    /**
     * Displays the edit form and imports the already currently saved values.
     * @param id is the ID of the goal to be edited
     * @param model is the Model used for UI display
     * @return the html for the edit form
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("goal", goalService.getGoalById(id));
        return "EditGoal";
    }


}
