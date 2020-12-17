/**
 * Return an object with a login property,
 * accessible only through a getter and setter
 */
exports.buildLogin = function() {
    return {
        logino: '',

        set login(value) {
            this.logino = value;
        },

        get login() {
            return this.logino;
        }
    };
};
