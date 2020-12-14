/**
 * Creates a counter module with an initial value, zero if not provided
 */
exports.createCounter = function (counter) {
    return {
        get: function () {
            return (counter != 0 && counter != null) ? counter : 0;
        },
        increment: function () {
            return counter++;
        },
        reset: function () {
            return counter = 0;
        }
    };
};

/**
 * Creates a person module with name and age
 * An initial name value should be provided and
 * an exception thrown if not
 */
exports.createPerson = function (name) {

    if (typeof name === 'undefined' || name === '' || name === null) {
        throw new Error('Please input name...');
    }
    
    let person = {
        age: 0,
        name: name
    }

    return {
        setAge: function (age) {
            person.age = age;
        },
        getAge: function () {
            return person.age;
        },
        getName: function () {
            return person.name;
        }
    };
};
