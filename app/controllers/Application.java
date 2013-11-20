package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Highscore;
import models.HighscoreException;
import models.IHighscore;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Application extends Controller {

	private static List<IHighscore> scoreList = new ArrayList<IHighscore>();

	public static Result index() throws HighscoreException {
		return ok(getResult());
	}

	public static Result addHighscoreHttp(String game, String player, Long score) throws HighscoreException {
		IHighscore s = new Highscore();

		s.setGame(game);
		s.setPlayer(player);
		s.setScore(score);
		scoreList.add(s);
		sortList();
        return ok(getResult());
	}

	public static Result addHighscoreJson() throws HighscoreException {
		IHighscore s = new Highscore();
        try {
                System.out.println(request().body().asJson());
                s.deserializeJson(request().body().asJson());
        } catch (HighscoreException e) {
                return badRequest(e.getMessage() + "\n" + e.getStackTrace());
        }

        scoreList.add(s);
        sortList();
        return ok(getResult());
	}

	private static void sortList() {
		Comparator<IHighscore> c = new Comparator<IHighscore>() {

			@Override
			public int compare(IHighscore arg0, IHighscore arg1) {
				long s1 = arg0.getScore();
				long s2 = arg1.getScore();

				if (s1 == s2) {
					return 0;
				} else if (s1 < s2) {
					return 1;
				} else {
					return -1;
				}
			}

		};
		Collections.sort(scoreList, c);
	}
	
	private static ObjectNode getResult() throws HighscoreException {
		ObjectNode result = Json.newObject();
        ArrayNode resultArr = result.arrayNode();
        for (IHighscore ts : scoreList) {
        	resultArr.add(ts.serializeJson());
        }
        
        result.put("result", resultArr);
        return result;
	}
}
