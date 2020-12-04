/**
 * Reduce duplicate characters to a desired minimum
 */
exports.reduceString = function(str, amount) {
    let arr2 = [];

    for (let index = 0; index < str.length; index++) {
        let numberOfTimes = 0;

        for (let index2 = 0; index2 < str.length; index2++) {

            if (numberOfTimes >= amount && !arr2.includes(str[index])) {
                break;
            }

            if (str[index] === str[index2]) {                
                numberOfTimes += 1;
                arr2.push(str[index]);
            }
        }

        
    }

    return arr2;
};

/**
 * Wrap lines at a given number of columns without breaking words
 */
exports.wordWrap = function(str, cols) {

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
