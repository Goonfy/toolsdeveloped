define(['view/index'], function (indexView) {
    var internals = {};
    var externals = {};

    externals.init = function () {
        fetch("https://shazam.p.rapidapi.com/search?term=wiz%20khalifa&locale=en-US&offset=0&limit=5", 
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
                indexView.show(jsonData);
            })
            .catch(function (err) {
                console.error(err);
            });
    };

    return externals;
});
