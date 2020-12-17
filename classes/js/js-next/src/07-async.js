/**
 * Fix the async retreive method, doing proper error handling
 * in case fetch does not return a user
 */
exports.User = class {

    constructor(url) {
        this.url = url;
    }

    async retrieve() {
        const response = await fetch(this.url);

        if (!response) {
            throw new Error(response.message); // throwing inside async rejects the returned promise
        }

        return response;
    }
};
