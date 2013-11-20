de.htwg.sa.highscores
=====================

RESTful highscore server:

Requests:

GET  -> get all highscores as json
	- example:
		{"result":
			[
				{"game":"MyGame","player":"MyPlayer","score":56789},
				{"game":"MySecondGame","player":"MyPlayer","score":0}
			]
		}	

POST -> Add new highscore entry with HTTP parameters
	- example:
		urltoServer/addHighscore?game=MyGame&player=MyPlayer&score=56789
		
POST -> Add new highscore entry with JSON
	- example:
		urltoServer/addHighscoreJson
		HTTP BODY (json):

			{
				"game": "MyGame",
				"player": "MyPlayer",
				"score": "56789"
			}