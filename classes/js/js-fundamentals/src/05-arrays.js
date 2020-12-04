/**
 * Determine the location of an item in the array
 */
exports.indexOf = function(arr, item) {
    return arr.indexOf(item);
};

/**
 * Sum the items of an array
 */
exports.sum = function(arr) {
    var summedNumbers = 0;

    arr.forEach(e => summedNumbers += e);

    return summedNumbers;
};

/**
 * Remove all instances of an item from an array
 */
exports.remove = function(arr, item) {
    return arr.filter(e => e !== item);
};

/**
 * Remove all instances of an item from an array by mutating original array
 */
exports.removeWithoutCopy = function(arr, item) {
    for (let index = 0; index < arr.length; index++) {
        arr.splice(arr.indexOf(item), 1);
    }

    return arr;
};

/**
 * Add an item to the end of the array
 */
exports.append = function(arr, item) {
    arr.push(item);

    return arr;
};

/**
 * Remove the last item of an array
 */
exports.truncate = function(arr) {
    arr.pop();

    return arr;
};

/**
 * Add an item to the beginning of an array
 */
exports.prepend = function(arr, item) {
    arr.unshift(item);

    return arr;
};

/**
 * Remove the first item of an array
 */
exports.curtail = function(arr) {
    arr.shift();

    return arr;
};

/**
 * Join two arrays together
 */
exports.concat = function(arr1, arr2) {
    return arr1.concat(arr2);
};

/**
 * Add an item to an array in the specified position
 */
exports.insert = function(arr, item, index) {
    arr.splice(index, 0, item);

    return arr;
};

/**
 * Count the number of occurrences of an item in an array
 */
exports.count = function(arr, item) {
    return arr.filter(e => e === item).length;
};

/**
 * Find all items which container multiple occurrences in the array
 */
exports.duplicates = function(arr) {
    let arr2 = [];

    for (let index = 0; index < arr.length; index++) {
        let numberOfTimes = 0;

        for (let index2 = 0; index2 < arr.length; index2++) {
            if (arr[index] === arr[index2]) {                
                numberOfTimes += 1;
            }
        }

        if (numberOfTimes > 1 && !arr2.includes(arr[index])) {
            arr2.push(arr[index]);
        }
    }

    return arr2;
};

/**
 * Square each number in the array
 */
exports.square = function(arr) {
    return arr.map(e => Math.pow(e, 2));
};

/**
 * Find all occurrences of an item in an array
 */
exports.findAllOccurrences = function(arr, target) {
    let occurrences = [];

    for (let index = 0; index < arr.length; index++) {            
        if (arr[index] === target) {
            occurrences.push(index);
        }
    }

    return occurrences;
};
