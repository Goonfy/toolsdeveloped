/**
 * Return result of calling function with arguments as present in array
 */
exports.argsAsArray = function (fn, arr) {
    return fn.apply(this, arr);
};

/**
 * Return the result of calling a function with the provided obj as context
 * for the implicit argument this
 */
exports.speak = function (fn, obj) {
    return fn.call(obj);
};

/**
 * Return a prefixer function that concatenates a string argument with a prefix
 */
exports.stringPrefixer = function (prefix) {
    return function (suffix) {
        return prefix + suffix;
    }
};

/**
 * Create an array of functions, each producing a result obtained
 * from applying the transform function to an argument from values array
 */
exports.makeResultFunctions = function (values, transform) {
    return values.map(function (i) {
        return function () {
            return transform(i);
        }
    });
};

/**
 * From a function which receives three arguments,
 * of which only two are available, create a new function
 * which wraps the original one with the missing argument
 */
exports.createWrapperFunction = function (fn, arg1, arg2) {
    return fn.bind(this, arg1, arg2);
};

/**
 * Return the sum of all arguments
 */
exports.sumArguments = function () {
    return Array.from(arguments).reduce(function (lastArg, nextArg) {
        return lastArg + nextArg;
    });
};

/**
 * Execute the function, passing it all the provided arguments
 */
exports.callIt = function (fn) {
    let arr = Array.from(arguments);
    arr.shift();

    fn.apply(this, arr);
};

/**
 * From a function which receives a variable number of arguments,
 * return a wrapper function which adds additional argumens to the ones
 * available and calls the original function
 */
exports.createAddArgumentsFunction = function (fn) {
    let args = Array.from(arguments);
    args.shift();

    return function () {
        Array.from(arguments).forEach(function (i) {
            args.push(i);
        })

        return fn.apply(this, args);
    }
};
