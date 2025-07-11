import msg, {getCurrentDate, getDayOfWeek} from "./getdate.js";

console.log(msg(getCurrentDate(), getDayOfWeek()));

const username = "Alice";
const message = "Hello Every one!";
console.log("-----------------------------");
const formatMessage = msg(username, message);
console.log(formatMessage)

import { quotes, getRandomQuote } from "./quotes.js";
console.log("-------------------------------")
console.log("랜덤명언 생성기: ", getRandomQuote());

console.log("-------------------------------")

import {weatherConditions ,suggestActivity } from "./weatherSimulator.js";

const randomIndex = Math.floor(Math.random()* weatherConditions.length);
const currentweather = weatherConditions[randomIndex];
console.log(`현재날씨:${randomIndex},`,suggestActivity(currentweather));
console.log("오늘의 날씨 : ", currentweather);
console.log("추천 활동: ", suggestActivity(currentweather));

const birthyear = 2000;
import { getZodiac, getFortune } from "./fortuneGenerater.js";
console.log("나의 띠 ",getZodiac(birthyear) );
console.log(getFortune(birthyear));