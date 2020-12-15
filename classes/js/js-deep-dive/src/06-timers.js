/**
 * Return a stop watch object with the following API:
 * getTime - return number of seconds elapsed
 * start - start counting time
 * stop - stop counting time
 * reset - sets seconds elapsed to zero
 */
exports.createStopWatch = function () {
    let time = 0;

    let timer;

    return {
        getTime: function () {
            return time;
        },
            
        start: function () {
            timer = setInterval(function(){ time++; }, 1000);
        },
    
        stop: function () {
            clearInterval(timer);
        },
    
        reset: function () {
            time = 0;
        }
    }
};
