//JSX 주의사항
// 1. 중괄호 내부에는 자바스크립트 표현식만 넣을 수 있다.
// 2. 조건문을 사용할 수 없다.
// 3. 숫자, 문자, 배열 값만 렌더링된다.
// 4. {true} {null} {obj} {undefined}
// 5. 모든 태그는 반드시 닫아야 한다.</>
// 6. 최상위 태그는 반드시 하나여야만 한다. 권장 <> </>
/* 
Step 1
const Main = () =>{
    const number = 10;
    return (
        <main>
            <h1>main</h1>
            <h2>{number}</h2>
            <h2>{number + 10}</h2>
            <h2>{number % 2 ===0 ? "짝수" : "홀수"}</h2>
            
        </main>
    );
        
}
*/
import './Main.css'
const Main = () =>{
    const user = {name: "soldesk", isLogin:true,}
    if(user.isLogin){
        //return <div style={{backgroundColor:"red", borderBottom:"5px solid blue",}}>로그 아웃.</div>
        return <div className = "logout">로그아웃</div>
    }
    else{
        return <div></div>
    }
        
    //방법 2
    /*
    return(
        <>
        {user.isLogin?(<div>로그아웃</div>:(<div>로그인</div>))}
        </>
    );
    */
}
export default Main;