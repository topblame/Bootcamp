import './App.css'
import { useEffect, useState } from 'react'
import Viewer from './components/Viewer'
import Controller from './components/Controller'
function App() {
  const [count, setCount] = useState(0);
  const [isVisible, setIsVisible] = useState(0);

  const handleButtonClick = (value) => {
    setCount(count + value);
  }

  //useEffect : count값이 변경될때 자동으로 출력 및 언마운트시 메모리청소
  useEffect(() => {
    //실행할 코드
    console.log(`Count 값이 변경되었습니다: ${count}`);

    //정리 함수
    return () => {
      console.log("컴포넌트가 곧 언마운트됩니다");
    };
  },
    [count]) //[count] : 의존성 배열

  return (
    <>
      <div className='App'>
        <h1>Simple Counter</h1>
        <section>
          <button onClick={() => setIsVisible(!isVisible)}>
            {isVisible ? "Hide" : "Show"} Counter
          </button>
        </section>
        <section>
          {/* 조건부 렌더링 */}
          {/* isVisible이 true 일경우 <Viewer count = {count}/> 가 렌더링 */}
          {isVisible && <Viewer count={count} />}
        </section>
        
        <section>
          <Controller onClickButton={handleButtonClick} />
        </section>
      </div>
    </>
  )
}

export default App
