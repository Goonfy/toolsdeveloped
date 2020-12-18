define(['view/info'], function (infoView) {
    var internals = {};
    var externals = {};

    externals.init = function () {
        
        fetch("https://shazam.p.rapidapi.com/songs/get-details?key=" + externals.data.key + "&locale=en-US",
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
                console.log(jsonData)
                infoView.show(jsonData);
            })
            .catch(function (err) {
                console.error(err);
            });

    };



    return externals;
});