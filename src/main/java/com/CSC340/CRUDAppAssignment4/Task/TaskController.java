package com.CSC340.CRUDAppAssignment4.Task;

import com.CSC340.CRUDAppAssignment4.Goal.Goal;
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

    /**
     * Displays the Create A Task page
     * @param id is the id of the goal this task is associated with
     * @param model is the Model used for UI display
     * @return the html file name for creating a task
     */
    @GetMapping("/{id}/newTask")
    public String newTaskCreationForm(@PathVariable int id, Model model){
        model.addAttribute("goalId", id);
        return "CreateATask";
    }

    /**
     * Creates and adds the task to the database
     * @param task is the task to add
     * @return a redirect to the goal page that contains the task
     */
    @PostMapping("/createTask")
    public String addNewTask(Task task){
        taskService.addNewTask(task);
        return "redirect:/goals/" + task.getGoal().getGoalId();
    }

    /**
     * Fetches the task detail html page for the specific task
     * @param id is the id of the task
     * @param model is the Model used for UI display
     * @return the Task Details html page
     */
    @GetMapping("/taskDetails/{id}")
    public String taskDetails(@PathVariable int id, Model model){
        model.addAttribute("task", taskService.getTaskByID(id));
        return "TaskDetails";
    }

    /**
     * Fetches the html for the Edit Task Form
     * @param id is the ID of the task to edit
     * @param model is the Model used for UI display
     * @return the html of the Edit Task page
     */
    @GetMapping("/{id}/editTask")
    public String editTaskForm(@PathVariable int id, Model model){
        model.addAttribute("task", taskService.getTaskByID(id));
        return "EditTask";
    }

    /**
     * Deletes the task with the specified ID
     * @param id is the ID of the task to be deleted
     * @return a redirect to the goal that held the task that was deleted
     */
    @GetMapping("/{id}/deleteTask")
    public String deleteTaskByID(@PathVariable int id){
        Task t = taskService.getTaskByID(id);
        Goal g = t.getGoal();

        taskService.deleteTaskById(id);
        return "redirect:/goals/" + g.getGoalId();
    }

    /**
     * Edits the task specified by saving the task parameter to the database
     * @param task is the task to be edited
     * @return a redirect to the task details page for the edited task
     */
    @PostMapping("/editTask")
    public String editTask(Task task) {
        taskService.addNewTask(task);
        return "redirect:/goals/taskDetails/" + task.getTaskId();
    }

}
