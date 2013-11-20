package models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface IHighscore {

	void setGame(String game);
	String getGame();
	
	void setPlayer(String player);
	String getPlayer();
	
	void setScore(Long score);
	Long getScore();
	
	void deserializeJson(JsonNode jsonRoot) throws HighscoreException;
	ObjectNode serializeJson() throws HighscoreException;
}
