package com.CSC340.CRUDAppAssignment4.Task;

import com.CSC340.CRUDAppAssignment4.Goal.Goal;
import com.CSC340.CRUDAppAssignment4.Goal.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goals")
public class TaskController {
    @Autowired
    TaskService taskService;

    @Autowired
    GoalService goalService;

    @GetMapping("/{id}/newTask")
    public String newTaskCreationForm(@PathVariable int id, Model model){
        model.addAttribute("goalId", id);
        return "CreateATask";
    }
    @PostMapping("/createTask")
    public String addNewTask(Task task){
        taskService.addNewTask(task);
        return "redirect:/goals/" + task.getGoal().getGoalId();
    }

    @GetMapping("/taskDetails/{id}")
    public String taskDetails(@PathVariable int id, Model model){
        model.addAttribute("task", taskService.getTaskByID(id));
        return "TaskDetails";
    }
    @GetMapping("/{id}/editTask")
    public String editTaskForm(@PathVariable int id, Model model){
        model.addAttribute("task", taskService.getTaskByID(id));
        return "EditTask";
    }
    @GetMapping("/{id}/deleteTask")
    public String deleteTaskByID(@PathVariable int id){
        Task t = taskService.getTaskByID(id);
        Goal g = t.getGoal();

        taskService.deleteTaskById(id);
        return "redirect:/goals/" + g.getGoalId();
    }

    @PostMapping("/editTask")
    public String editTask(Task task) {
        taskService.addNewTask(task);
        return "redirect:/goals/taskDetails/" + task.getTaskId();
    }

}
