package com.CSC340.CRUDAppAssignment4.Task;

import com.CSC340.CRUDAppAssignment4.Goal.Goal;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;

    @ManyToOne
    @JoinColumn(name = "goalId")
    private Goal goal;

    @Nonnull
    private String title;

    @Nullable
    private String details;

    private String status;

    public Task(){

    }

    public Task(int taskId, Goal goal, @Nonnull String title, @Nullable String details, String status) {
        this.taskId = taskId;
        this.goal = goal;
        this.title = title;
        this.details = details;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    @Nullable
    public String getDetails() {
        return details;
    }

    public void setDetails(@Nullable String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
