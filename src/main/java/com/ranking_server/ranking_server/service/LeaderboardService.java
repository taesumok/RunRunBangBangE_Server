package com.ranking_server.ranking_server.service;

import com.ranking_server.ranking_server.model.ScoreEntry;
import com.ranking_server.ranking_server.repository.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {

    @Autowired
    private LeaderboardRepository repository;
    

    public List<ScoreEntry> getTop100Leaderboard() {
        return repository.findTop100ByOrderByScoreDesc();
    }
    
    public void updateScore(String guid, int score) {
    	
        int org_score = repository.getScore(guid);
        if(score >= org_score) {
        	repository.updateScore(guid, score);
        }
    }

    public void submitName(String guid, String playerName) {
        ScoreEntry entry = new ScoreEntry(guid, playerName);
        repository.save(entry);
    }
    
    public String getName(String guid) {
    	return repository.getName(guid);
        
    }
}