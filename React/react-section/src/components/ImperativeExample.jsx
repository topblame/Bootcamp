import { forwardRef, useImperativeHandle, useReducer, useRef } from "react";
const FancyButton = forwardRef((props, ref) => {
    const btnRef = useReducer();

    useImperativeHandle(ref, ()=>({
        click:()=>{
            btnRef.current.click();
        }
    }))

    return <button ref={btnRef} onClick={props.onClick}>자식버튼</button>
})

const ImperativeExample = () =>{
    const childRef = useRef();

    return(
        <>
        <FancyButton
        ref = {childRef}
        onClick={()=>alert("자식버튼이 클릭됨!")}
        />
        <button onClick={()=> childRef.current.click()}>자식버튼 강제클릭 </button>
        </>
    )
}

export default ImperativeExample;