/*
//properties : 전달되는 매개변수 읽기전용
const Button =(props) =>{
    console.log(props);
    return <button style={{color:props.color}}>{props.text} - {props.color}
    </button>
}

//props 없이 버튼에 텍스트 적용
const Button =({text, color = "black"}) =>{
    return <button style={{color}}>
        {text} - {color.toUpperCase()}
    </button>
}

// 전달되어야 하는 속성값이 여러개.
const Button =({text, color = "black", a, b, c}) =>{
    return <button style={{color}}>
        {text} - {color.toUpperCase()} (a = {a} b= {b} c= {c})
    </button>
}

//버튼 하위 자식 엘리먼트
const Button =({text, color="black", children}) =>{
    return <button style={{color}}>
    {text}-{color.toUpperCase()};
    {children}
    </button>
}

*/
//이벤트 객체
const Button =({text, color="green", children}) =>{
    const onClickButton=(e)=>{
        alert(`button clicked! U clicked on : ${e.target.textContent}`)
    }
    //console.log("Button props:", {text, color, children})
    return (
        <button onClick={onClickButton}
        style = {{color:color}}>
            {text} - {color.toUpperCase()}
            {children}
           
        </button>
    );

}
Button.defaultProps = {
    color: "green",
};
export default Button;