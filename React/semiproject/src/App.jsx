import './App.css'
import { useEffect, useState, useRef } from 'react'
import Viewer from './components/Viewer';
import Event from './components/Event';
import Controller from './components/Controller';
function App() {
  const [count, setCount] = useState(0);
  const [input, setInput] = useState(0);

  const isMount = useRef(false);
  // 1. 마운트 탄생
  useEffect(() => {
    console.log("mount");
  }, [])

  // 2. 업데이트시
  useEffect(() => {
    if (isMount.current) {
      isMount.current = true
    }
    console.log("update")
  },) // [] 생략되면 update
  //3. 언바운드 = 죽음.
  const onClickButton = (value) => {
    setCount(count + value);
  }
  return (
    <div className="App">
      <h1>Simple Counter</h1>
      <section>
        <input
          value={input}
          onChange={(e) => {
            setInput(e.target.value);
          }}
          placeholder="입력된 값이 Viewer에 출력됩니다"
        />
      </section>
      <section>
        {/* Viewer에 input도 전달 */}
        <Viewer count={count} input={input} />
        {count % 2 === 0 ? <Event /> : null}
      </section>
      <section>
        <Controller onClickButton={onClickButton} />
      </section>
    </div>
  )
}

export default App
