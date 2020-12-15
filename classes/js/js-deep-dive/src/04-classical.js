/**
 * Return a Rectangle constructor function
 * Rectangle instances should contain x and y properites
 * and they should know how to calculate their area and perimeter
 */
exports.createRectangleConstructor = function() {
    var rectangle = function Rectangle(x, y) {
        this.x = x;
        this.y = y;
    }

    rectangle.prototype.area = function() {
        return this.x * this.y;
    }

    rectangle.prototype.perimeter = function() {
        return this.x * 2 + this.y * 2;
    }

    return rectangle;
};

/**
 * Return a constructor function that
 * subclasses the provided constructor
 */
exports.createSubClass = function(fn) {
    let subclass = function SubClass() {
        fn.call(this, fn);
        this.test = fn.prototype.test;
    }

    //console.log(subclass.called);

    return subclass;
};


