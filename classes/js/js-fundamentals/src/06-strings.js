/**
 * Reduce duplicate characters to a desired minimum
 */
exports.reduceString = function(str, amount) {
    let reducedStrings = [];
    let lastString = "";

    for (let index = 0; index < str.length; index++) {
        let numberOfTimes = 0;

        if (lastString === str[index]) {
            continue;
        }

        for (let index2 = 0; index2 < str.length; index2++) {

            if (str[index] === str[index2]) {                
                numberOfTimes++;
                reducedStrings.push(str[index]);
            }

            if (numberOfTimes >= amount) {
                lastString = str[index];
                break;
            }
        }
    }

    return reducedStrings.join('');
};

/**
 * Wrap lines at a given number of columns without breaking words
 */
exports.wordWrap = function(str, cols) {
    return str.split(" ").map(e => e += "\n").join("");
};

/**
 * Reverse a String
 */
exports.reverseString = function(str) {
    return str.split('').reverse().join('');
};

/**
 * Check if String is a palindrome
 */
exports.palindrome = function(str) {
    return str.slice(0, Math.ceil((str.length - 1) / 2)) === str.slice(Math.ceil(((str.length)) / 2), str.length).split('').reverse().join('');
};
