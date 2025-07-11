//date_luxon.js
//luxon
import {DateTime} from "luxon";

const now = DateTime.now();
console.log("현재 날짜와 시간: " , now.toString())

const dt = DateTime.local(2025,7,10,12,45);
console.log("지정 날짜와 시간: " , dt.toString())

const formattedDate = dt.toLocaleString(DateTime.DATE_FULL)
console.log("포맷팅 날짜: ", formattedDate)

const diff = now.diff(dt, ["years", "months", "days"])
console.log("현재부터 지정된 날짜까지의 차이: ", diff.toObject())