de.htwg.sa.highscores
=====================

RESTful highscore server:

Requests:

GET  ->  show website with highscores	

GET  ->  get all highscores as json
		
		urltoServer/getHighscores

		{"result":
			[
				{"game":"MyGame","player":"MyPlayer","score":56789},
				{"game":"MySecondGame","player":"MyPlayer","score":0}
			]
		}	

POST -> Add new highscore entry with HTTP parameters



		urltoServer/addHighscore?game=MyGame&player=MyPlayer&score=56789
		
POST -> Add new highscore entry with JSON

		urltoServer/addHighscoreJson
		
		HTTP BODY (json):
			{
				"game": "MyGame",
				"player": "MyPlayer",
				"score": "56789"
			}
