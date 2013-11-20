de.htwg.sa.highscores
=====================

RESTful highscore server:

Requests:

GET  -> show page

POST -> Add new highscore entry

	- HTTP BODY (json):

			{
				"game": "MyGame",
				"player": "MyPlayer",
				"score": "56789"
			}
			
Response Format:
	{"result":
		[
			{"game":"MyGame","player":"MyPlayer","score":56789},
			{"game":"MySecondGame","player":"MyPlayer","score":0}
		]
	}
