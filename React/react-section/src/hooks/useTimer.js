//useTimer.js
import { useState, useRef } from "react";

function useTimer(){
    const[seconds, setSeconds] = useState(0);
    //리 렌더링 없이 값을 보존.
    const intervalRef = useRef(null);

    const start = () =>{
        if(intervalRef.current !== null) return; //이미시작된 경우 방지
        intervalRef.current = setInterval(()=>{
            setSeconds((prev)=> prev +1);
        }, 1000);
    };

    const stop = () =>{
        clearInterval(intervalRef.current);
        intervalRef.current = null;
    };

    const reset = () =>{
        stop();
        setSeconds(0);
    }

    return {seconds, start, stop, reset};
}

export default useTimer;