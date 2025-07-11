//ES module 시스템 사용

import {add, substract, multiply, divide} from "./ESM_math.js";

console.log(add(5,3))
console.log(substract(5,3))
console.log(multiply(5,3))
console.log(divide(5,3))

import mul, {add2, substract2, divide2} from "./ESM_math2.js";
console.log("-----------------------------------")
console.log(add2(5,3))
console.log(substract2(5,3))
console.log(mul(5,3));
console.log(divide2(5,3))

