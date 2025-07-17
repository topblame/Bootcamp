import './App.css'
import { useState } from 'react'
import Bulb from './components/Bulb';
import Counter from './components/Counter';
import Register from './components/Register';
import CompareRefAndLet from './components/CompareRefAndLet';
import TypingGame from './components/TypingGame';
import ClickCounter from './components/ClickCounter';
import EffectExample from './components/EffectExample';
import RandomQuote from './components/RandomQuote';
import ContextExample from './components/ContextExample';
import ReducerExample from './ReducerExample';
import CallbackExample from './CallbackExample';
import MemoExample from './components/MemoExample';
import LayoutEffectExample from './components/LayoutEffectExample';
import ImperativeExample from './components/ImperativeExample';
import TimerComponent from './components/TimerComponent';
import ToggleComponents from './components/ToggleComponents';
import InputComponent from './components/InputComponent';
function App() {
  return (
    <>
      <CompareRefAndLet />
      <hr />
      <TypingGame />
      <hr />
      <ClickCounter />
      <hr />
      <EffectExample/>
      <hr />
      <RandomQuote/>
      <hr />
      <ContextExample/>
      <hr />
      <ReducerExample/>
      <hr />
      <CallbackExample/>
      <hr />
      <MemoExample/>
      <hr />
      <LayoutEffectExample/>
      <hr />
      <ImperativeExample/>
      <hr />
      <TimerComponent/>
      <hr />
      <ToggleComponents/>
      <hr />
      <InputComponent/>
    </>
  )
}


export default App





// import './App.css'
// import Header from './components/Header'
// import Main from './components/Main'
// import Footer from './components/Footer'
// import Button from './components/Button'
// /*
// const Header=() => {
//   }

// function Header(){
//   return(
//     <header>
//       <h1>Header</h1>
//     </header>
//   )
// }

// function App() {

//   return (
//     <>
//     <Header/>
//     <Main/>
//     <Footer/>
//     </>
//   )
// }
// */
// //속성값이 여러개일때
// function App() {
//   const buttonProps = {text:"메일", color:"red", a:1, b:2, c:3}
//   //... -> 전개연산자. spread operator
//   return (
//     <>
//       <Button {...buttonProps}/>
//       <Button text ={"카페"} />
//       <Button text ={"블로그"}>
//       {/*<div>자식요소.</div>*/}
//       <Header/>
//       </Button>
//     </>
//   )
// }
// export default App
