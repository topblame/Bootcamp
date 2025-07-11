// commonJS 방식.
/*
console.log("hello world");

const sayHello = require("./greeting");
const userName = "soldesk";

const math = require("./math");
console.log(math);
console.log(math.add(5,3))
console.log(math.substract(5,3))
console.log(math.multiply(5,3))
console.log(math.divide(5,3))
// console.log(math.divide(5,0))

const {add, substract, divide, multiply} = require("./math");
console.log(add(5,3))

const filemanager = require("./fileManager");
const fileName = "sample.txt";
const content = "this is sample"
filemanager.writeFile(fileName, content);
console.log(filemanager.readFile(fileName));

const getWeather = require("./weatherModule");
getWeather("Seoul");

const noteManager = require("./noteManager");
noteManager.addNote("nodeJS2", "Learn how to use node JS2");
noteManager.getNotes();
// noteManager.deleteNote(1);
*/