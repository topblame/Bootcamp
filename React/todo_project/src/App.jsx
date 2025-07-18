import './App.css'
import Header from './components/Header'
import Editor from './components/Editor'
import List from './components/List'
import { useState ,useRef } from 'react';

const mockData = [
  {
    id: 0,
    isDone: false,
    content: "React 공부하기",
    date: new Date().getTime(),
  },
  {
    id: 1,
    isDone: false,
    content: "빨래하기",
    date: new Date().getTime(),
  },
  {
    id: 2,
    isDone: false,
    content: "노래 연습하기",
    date: new Date().getTime(),
  },
];
function App() {

  const [todos, setTodos] = useState(mockData);
  const idRef = useRef(3);

  const onCreate = (content) => {
    const newTodo={
      id: idRef.current++,
      isDone: false,
      content: content,
      date: new Date().getTime(),
    };
    setTodos([newTodo, ...todos])
  };
  
  const onUpdate = (targetId) =>{
    setTodos(
      //todos.map():기존의 배열을 변경하는 메소드
      //...todo: targetId와 일치하지 않는 값들의 그대로 유지
      todos.map((todo) =>
        todo.id === targetId
          ? { ...todo, isDone: !todo.isDone }
          : todo //삼항연산자
      )
    );
  }
  const onDelete = (targetId) => {
    setTodos(todos.filter((todo) => todo.id !== targetId));
  };
  return (
    <>
       <div className="App">
      <Header />
      <Editor onCreate={onCreate} />
      {/* App컨포넌트의 자식 -> List컴포턴트의 id체크박스 
      -> TodoItem의 id체크여부 요소에서 제어 */}
      <List todos={todos} onUpdate={onUpdate} onDelete={onDelete} />
    </div>
    </>
  )
}

export default App
