package com.ranking_server.ranking_server.controller;

import com.ranking_server.ranking_server.model.ScoreEntry;
import com.ranking_server.ranking_server.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    @PostMapping("/submit-name")
    public String submitName(@RequestBody ScoreEntry entry) {
        leaderboardService.submitName(entry.getGuid(), entry.getPlayerName());
        return "Name submit successfully.";
    }
    
    @PostMapping("/get-name")
    public String getName(@RequestBody ScoreEntry entry) {
        return leaderboardService.getName(entry.getGuid());

    }
    
    
    @PostMapping("/update-score")
    public String updateScore(@RequestBody ScoreEntry entry) {
        leaderboardService.updateScore(entry.getGuid(),  entry.getScore());
        return "Score update successfully.";
    }
    
    

    @GetMapping("/leaderboard")
    public List<ScoreEntry> getLeaderboard() {
        return leaderboardService.getTop100Leaderboard();
    }
}