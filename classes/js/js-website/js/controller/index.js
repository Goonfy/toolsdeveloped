define(['view/index'], function (indexView) {
	var internals = {};
	var externals = {};

	//console.log(indexView);

	externals.init = function () {
		fetch("https://shazam.p.rapidapi.com/search?term=wiz%20khalifa&locale=en-US&offset=0&limit=50",
			{
				"method": "GET",
				"headers": {
					"x-rapidapi-key": "53bf368258msh1b69b626ca7b9b5p1f6389jsndf7a9c315048",
					"x-rapidapi-host": "shazam.p.rapidapi.com"
				}
			})
			.then(function (response) {
				return response.json();
			})
			.then(function (jsonData) {
				return jsonData.artists.hits;
			})
			.then(function (artistData) {
				return artistData[0].artist.id;
			})
			.then(function (artistID) {
				fetch("https://shazam.p.rapidapi.com/songs/list-artist-top-tracks?id=" + artistID + "&locale=en-US",
				{
					"method": "GET",
					"headers": {
						"x-rapidapi-key": "53bf368258msh1b69b626ca7b9b5p1f6389jsndf7a9c315048",
						"x-rapidapi-host": "shazam.p.rapidapi.com"
					}
				})
				.then(function (response) {
					return response.json();					
				})
				.then(function (jsonData) {
					jsonData.tracks.forEach(function (tracks) {
						indexView.show(tracks);
					})
				})	
			})
			.catch(function (err) {
				console.error(err);
			});
	};

	return externals;
});
