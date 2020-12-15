/**
 * Create a developer person object with a code method
 * that delegates to the provided person object
 */
exports.createDelegate = function (person) {
    var p = Object.create(person);

    p.name = person.name;
    p.greeting = person.greeting;
    p.say = person.say;
    p.code = function () {};

    return p;
};

/**
 * Borrow and invoke the person say method on top of the company object
 */
exports.borrowSayMethod = function (person, company) {
    person.name = company.name;

    return person.say();
};

/**
 * Iterate over all of the provided object own properties,
 * returning an array of key: value strings
 */
exports.iterate = function (obj) {
    return Object.entries(obj).map(function (entrie) {
        return entrie[0] + ": " + entrie[1];
    });
};

/**
 * Add a repeatify method to all JavaScript Strings
 * 'string'.repeatify(3) should equal 'stringstringstring'
 * NOTE: This exercise exists for a pedagogic purpose only,
 * do not think doing stuff like this is a good idea...
 *
 * String already contains a repeat method, let's NOT use that one.
 */
exports.extendString = function () {

    if (String.prototype.repeatify === undefined) {
        String.prototype.repeatify = function (n) {
            let joinedStrings = "";

            while (n !== 0) {
                n--;
                joinedStrings += this;
            }

            return joinedStrings;
        };
    }
};
