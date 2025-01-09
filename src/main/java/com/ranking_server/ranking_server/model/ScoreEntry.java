package com.ranking_server.ranking_server.model;
import jakarta.persistence.*;

@Entity
@Table(name = "leaderboard")
public class ScoreEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "guid", nullable = false, unique = true)
    private String guid;
    
    @Column(name = "playerName", nullable = false)
    private String playerName;

    @Column(name = "score", nullable = true)
    private int score;

    public ScoreEntry() {}

    public ScoreEntry(String guid, String playerName) {
    	this.guid = guid;
        this.playerName = playerName;
    }
    
    public String getGuid() {
		return guid;
	}
    public void setGuid(String guid) {
		this.guid = guid;
	}
    
    public String getPlayerName() {
		return playerName;
	}
    public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
    public int getScore() {
		return score;
	}
    public void setScore(int score) {
		this.score = score;
	}


    // Getter와 Setter 생략
}