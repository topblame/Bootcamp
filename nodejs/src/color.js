import randomColor from "randomcolor";
import express from "express";

const color = randomColor(); //randomcolor 라이브러리 가져오기
console.log(color);
console.log("---------------");
const app = express(); //http 요청
const port = 3000;

app.get("/", (req, res)=> {
    const color = randomColor();
    res.send(`<h1 style="color: ${color};">Welcome to Home page</h1>`)

})
app.listen(port, ()=>{
    console.log(`Server is running on http://localhost:${port}`)
})