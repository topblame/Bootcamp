import { useRef, useState } from "react";

const ClickCounter =() => {
    const countRef = useRef(0);
    const [visibleCount, setVisibleCount] = useState(0);

    const handleClick= () =>{
        countRef.current++;
        console.log("총 클릭수 : " , countRef.current);
    };

    const showCount = () =>{
        setVisibleCount(countRef.current);
    };

    return(
        <div>
            <h2>클릭 카운터</h2>
            <button onClick={handleClick}>클릭하기</button>
            <button onClick={showCount}>지금까지 몇번 클릭 했을까?</button>
            <p>화면에 보이는 클릭 수 : {visibleCount}</p>
        </div>
    )
}

export default ClickCounter;