import { useState, useRef } from "react";
const CompareRefAndLet = () =>{
    const[input, setInput] = useState("");
    const refCount = useRef("0");
    let letCount = 0;

    const handleChange = (e) =>{
        setInput(e.target.value);
        refCount.current++;
        letCount++;

        console.log("use refcount : ", refCount.current);
        console.log("let count : ", letCount);
    }

    return(
        <div>
            <h2>useRef vs let 비교</h2>
            <input value={input} onChange={handleChange} placeholder="아무거나 입력" />
            <p>현재입력 {input}</p>
            <p>refCount (useRef): {refCount.current}</p>
            <p>letCount (let): {letCount}</p>
        </div>
    )
}
export default CompareRefAndLet;