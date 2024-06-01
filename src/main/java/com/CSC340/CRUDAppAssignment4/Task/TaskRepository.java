package com.CSC340.CRUDAppAssignment4.Task;

import com.CSC340.CRUDAppAssignment4.Goal.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    /**
     * Fetch all tasks with the specified goal ID
     * @param goalId is the goal ID to search for
     * @return a list of tasks
     */
    @Query(value = "select * from tasks where goal_id = ?1", nativeQuery = true)
    public List<Task> getTasksByGoal(int goalId);
}
