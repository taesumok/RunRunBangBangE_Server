package com.ranking_server.ranking_server.repository;

import com.ranking_server.ranking_server.model.ScoreEntry;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaderboardRepository extends JpaRepository<ScoreEntry, Long> {
    List<ScoreEntry> findTop100ByOrderByScoreDesc();  // 상위 100명 랭킹 조회
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE ScoreEntry se SET se.score=:score WHERE se.guid=:guid")
    void updateScore( @Param("guid") String guid, @Param("score") int score);
    
    @Query("SELECT se.playerName FROM ScoreEntry se WHERE se.guid=:guid")
    String getName( @Param("guid") String guid);
   
}