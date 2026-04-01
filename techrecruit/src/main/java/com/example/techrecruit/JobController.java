package com.example.techrecruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JobController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // READ: Get all jobs
    @GetMapping
    public List<Map<String, Object>> getJobs() {
        return jdbcTemplate.queryForList("SELECT * FROM jobs ORDER BY id DESC");
    }

    // CREATE: Add a new job
    @PostMapping
    public Map<String, Object> addJob(@RequestBody Map<String, String> jobData) {
        String sql = "INSERT INTO jobs (title, company, location, salaryRange, tags) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, jobData.get("title"), jobData.get("company"), 
                        jobData.get("location"), jobData.get("salaryRange"), jobData.get("tags"));
        return Map.of("status", "success");
    }

    // UPDATE: Update existing job by ID
    @PutMapping("/{id}")
    public Map<String, Object> updateJob(@PathVariable int id, @RequestBody Map<String, String> jobData) {
        String sql = "UPDATE jobs SET title=?, company=?, location=?, salaryRange=?, tags=? WHERE id=?";
        jdbcTemplate.update(sql, jobData.get("title"), jobData.get("company"), 
                        jobData.get("location"), jobData.get("salaryRange"), jobData.get("tags"), id);
        return Map.of("status", "success");
    }

    // DELETE: Remove job by ID
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteJob(@PathVariable int id) {
        jdbcTemplate.update("DELETE FROM jobs WHERE id = ?", id);
        return Map.of("status", "success");
    }
}