import { useCallback, useState } from "react";

const CallbackExample = () =>{
    const[count, setCount] = useState(0);

    const handleClick = useCallback(()=>{
        console.log("버튼클릭");
    }, [])

    return(
        <>
            <button onClick={()=> setCount(count+1)}>{count}</button>
            <button onClick={handleClick}>클릭로그</button>
        </>
    )
}
export default CallbackExample