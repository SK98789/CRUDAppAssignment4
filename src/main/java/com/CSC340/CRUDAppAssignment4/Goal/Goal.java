package com.CSC340.CRUDAppAssignment4.Goal;

import java.sql.Date;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int goalId;

    private int userId;
    @Nonnull
    private String title;
    @Nullable
    private String details;
    private Date targetDate;
    private String status;

    public Goal(){
    }

    public Goal(int goalId, int userId, @Nonnull String title, @Nullable String details, Date targetDate, String status) {
        this.goalId = goalId;
        this.userId = userId;
        this.title = title;
        this.details = details;
        this.targetDate = targetDate;
        this.status = status;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
