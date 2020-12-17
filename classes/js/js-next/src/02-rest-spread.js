/**
 * Return an array containing the function arguments
 */
exports.argsAsArray = function () {
    return Array.from(arguments);
};

/**
 * Return an array containing the function arguments,
 * but discarding the first two
 */
exports.lastArgs = function () {
    return Array.from(arguments).filter(e => Array.from(arguments).indexOf(e) > 1);
};

/**
 * Return a function which applies the provided transform function
 * on all arguments and returns an array with the results
 */
exports.transformArgs = function (transform) {
    return (...arguments) => {
        return Array.from(arguments).map(e => transform(e));
    };
};

/**
 * Invoke the callback function passing each character
 * from the provided string as an argument
 */
exports.spreadChars = function (str, cb) {
    cb(...str.split(""));
};

/**
 * Concatenate the provided arrays using the spread operator
 */
exports.mergeArrays = function (arr1, arr2) {
    return [...arr1, ...arr2];
};

/**
 * Return array of chars from the provided array of strings
 * using the spread operator
 */
exports.spreadArrayStrings = function (arr) {
    //return [...arr.reduce((acc, val) => acc + val)];

    return [...arr].map(e => e.split('')).toString().split(',');
};

/**
 * Flatten an array of arrays using the spread operator
 */
exports.flattenArray = function (arr) {
    return [...arr.reduce((acc, val) => acc + val)].filter(e => e !== ',');
};

