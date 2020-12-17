/**
 * Create a Prefixer class with constructor and a prefixArray method
 */
exports.Prefixer = class Prefixer {
    
    constructor(prefix) {
        this.prefix = prefix;
    }

    prefixArray(arr) {
        return arr.map(e => this.prefix + e);
    }
};

/*exports.Prefixer.prototype.prefixArray = function(arr) {
};*/

/**
 * Create a PrefixerSuffixer class which extends from the Prefixer class
 * but adds a sufixArray method
 */
exports.PrefixerSufixer = class PrefixerSuffixer extends this.Prefixer { 
    constructor(prefix, suffix) {

        super(prefix);

        this.suffix = suffix;
    }

    sufixArray(arr) {
        return arr.map(e => e + this.suffix);
    }
};
