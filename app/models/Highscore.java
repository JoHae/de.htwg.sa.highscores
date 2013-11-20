package models;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Highscore implements IHighscore {

	String player;
	String game;
	Long score;

	@Override
	public void setGame(String game) {
		this.game = game;
	}

	@Override
	public String getGame() {
		return game;
	}

	@Override
	public void setPlayer(String player) {
		this.player = player;
	}

	@Override
	public String getPlayer() {
		return player;
	}

	@Override
	public void setScore(Long score) {
		this.score = score;
	}

	@Override
	public Long getScore() {
		return score;
	}

	@Override
	public void deserializeJson(JsonNode jsonRoot) throws HighscoreException {
		if(jsonRoot == null) {
			throw new HighscoreException("Expecting JSON data.");
		}
		
		String game = jsonRoot.findPath("game").textValue();
		String player = jsonRoot.findPath("player").textValue();
		Long score = jsonRoot.findPath("score").asLong();

		if (player == null || game == null || score == null) {
			throw new HighscoreException(
					"Some parameters cannot be parsed. Please ensure that"
							+ "all parameters are given in request (game, player, score)");
		}

		this.game = game;
		this.player = player;
		this.score = score;
	}
	
	@Override
	public ObjectNode serializeJson() throws HighscoreException {
		if (player == null || game == null || score == null) {
			throw new HighscoreException(
					"Some parameters cannot be parsed. Please ensure that"
							+ "all parameters are given in request (game, player, score)");
		}
		
		ObjectNode result = Json.newObject();
		
		result.put("game", game);
	    result.put("player", player);
	    result.put("score", score);
	    
	    return result;
	}
}
