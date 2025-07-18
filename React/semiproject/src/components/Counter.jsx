import { useRef, useState } from "react";
import '../css/Counter.css'
const Counter = () => {
    const countRef = useRef(0);
    const [visibleCount, setVisibleCount] = useState(0);

    const HandleClick = () =>{
        countRef.current++;
        setVisibleCount(countRef.current);
    }   

    return(
        <div className="container">
            <h2>Counter</h2>
            <br/>
            <p>Current Count {visibleCount}</p>
            <button onClick={HandleClick}>Increment</button>
        </div>
    )
}
export default Counter;
