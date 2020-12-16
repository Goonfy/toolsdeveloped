// where should my modules be imported from?
requirejs.config({
    baseUrl: './js'
});

// entry point
requirejs(['router'], function (router) {
    $(document).ready(router.init);
});
