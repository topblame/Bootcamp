import { useState } from "react";

function TodoList() {
    // 현재 To_Do 목록을 저장하는 배열 상태
    const [todos, setTodos] = useState([]);
    //사용자가 입력한 새 작업을 저장하는 상태
    const [newTodo, setNewTodo] = useState("");

    const handleInputChange = (e) => {
        setNewTodo(e.target.value);
    }

    const handleAddTodo = () => {
        if (newTodo.trim() !== "") {
            setTodos([...todos, newTodo])
            setNewTodo("")
        }
    }
    const handleDeleteTodo = (index) => {
        //filter(Element, index)
        //요청한 인덱스와 나머지만 다시 todo에 저장 
        const newTodos = todos.filter((_, i) => i !== index);
        setTodos(newTodos);
    }

    return (
        <div className="todo-list">
            <h1>To-Do List</h1>
            <input
                type="text"
                value={newTodo}
                onChange={handleInputChange}
                placeholder="Add a new task"
            />
            <p></p>
            <button onClick={handleAddTodo}>Add</button>
            <ul>
                {todos.map((todo, index) => (
                    <li key={index}>
                        {todo}
                        <button onClick={() => handleDeleteTodo(index)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );

}
export default TodoList;
