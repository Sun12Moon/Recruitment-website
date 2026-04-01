package com.example.techrecruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/signup")
    public Map<String, Object> signUp(@RequestBody Map<String, String> userData) {
        try {
            String sql = "INSERT INTO users (fullName, email, password) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, userData.get("fullName"), userData.get("email"), userData.get("password"));
            return Map.of("status", "success", "message", "User registered!");
        } catch (Exception e) {
            return Map.of("status", "error", "message", "Email already exists!");
        }
    }

    @PostMapping("/signin")
    public Map<String, Object> signIn(@RequestBody Map<String, String> loginData) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        List<Map<String, Object>> user = jdbcTemplate.queryForList(sql, loginData.get("email"), loginData.get("password"));

        if (!user.isEmpty()) {
            return Map.of("status", "success", "user", user.get(0).get("fullName"));
        } else {
            return Map.of("status", "error", "message", "Invalid email or password");
        }
    }
}