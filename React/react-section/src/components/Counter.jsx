import { useState } from "react";

const Counter = () => {
    const [state, setState] = useState(0);
    return (
        <h1>
            {state}
            <br/>
            <button onClick={() => {
                setState(state + 1);
            }}>
                +
            </button>
        </h1>
    );

}

export default Counter;