/**
 * Invoke the callback and return the amount of time in miliseconds it took to execute
 */
exports.profileFunc = function (cb) {
	let timestart = Date.now();

	cb();

	return Date.now() - timestart;
};

/**
 * Invoke the async callback with the provided value after some delay
 */
exports.returnWithDelay = function (value, delay, cb) {
	setInterval(function () {
		cb(null, value);
	}, delay);
};

/**
 * Invoke the async callback with an error after some delay
 */
exports.failWithDelay = function (delay, cb) {
	setInterval(function () {
		cb(new Error("Error"));
	}, delay);
};

/**
 * Return a promise that resolves after the specified delay
 * or rejects if the delay is negative or non-existent
 */
exports.promiseBasedDelay = function (delay) {
	return new Promise(function (resolve, reject) {
		if (delay < 0 || delay === null) {
			reject(Error());
		}

		setInterval(function () {
			resolve();
		}, delay);
	});
};

/**
 * Use fetch to grab the contents of both urls and return
 * a promise resolving to the payload concatenation
 */
exports.concatBodies = function (url1, url2) {
	return Promise.all([
		fetch(url1),
		fetch(url2),
	]).then(function (values) {
		return Promise.resolve(values[0] + values[1]);
	});
};
