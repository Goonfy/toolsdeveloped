/**
 * Return the result of invoking the provided function
 * If an exception is thrown, return the enclosed error message
 */
exports.callIt = function (fn) {
    try {
        return fn();
    } catch (e) {
        return e.message;
    }
};

/**
 * Return true if the provided arguments are equal,
 * throw an error with an enclosed message otherwise
 */
exports.assertEqual = function (a, b) {
    if (a !== b) {
        throw new Error("Not Equal");
    }

    return true;
};

/**
 * Return a custom error constructor with a timestamp property
 * indicating when the error occurred
 */
exports.createCustomError = function () {
    let customerror = function CustomError(message) {
        var error = Error(message);
        this.name = 'CustomError';
        this.message = error.message;
        this.stack = error.stack;
        this.timestamp = Date.now();
    }

    // Make CustomError inherit from a new error object,
    customerror.prototype = Object.create(Error.prototype);
    customerror.prototype.constructor = customerror;

    return customerror;
};
