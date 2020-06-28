'use strict';
console.log("hi, loading JSBasic01.js");
var jsBasic01Namespace = {
    process01: function () {
        var newTitle = "JS Title 03";
        var newContent = "JS Content 03";
        var header = document.getElementById('h03');
        var content = document.getElementById("ct03");
        header.innerHTML = newTitle;
        content.innerHTML = newContent;
        var i = 2;
        document.write(`<p> i= ${i}, the namespace conflict with which designed in the index html</p>`);
    },

    process02: function () {
        document.write(`process2 is called`);
    },

    process03: function () {
        var arr = [1, 2];
    }
}
jsBasic01Namespace.process01();