import { useRef, useState } from 'react'
/*
1.이름
2.생년월일
3.국적
4.자기소개.
*/
/*
const Register = () => {
    const [name, setName] = useState("");
    const [birth, setbirth] = useState("");
    const [country, setCountry] = useState("");
    const [bio, setBio] = useState("");

    const onChangeName = (e) => {
        setName(e.target.value); // 사용자가 입력한 값으로 변경.
    }
    const onChangeBirth = (e) => {
        setbirth(e.target.value);
    }
    const onChangeCountry = (e) => {
        setCountry(e.target.value);
    }
    const onChangeBio = (e) => {
        setBio(e.target.value);
    }

    return (
        <div>
            <div>
                <input value={name} onChange={onChangeName} placeholder={"이름"} />
                {name}
            </div>
            <div>
                <input value={birth} onChange={onChangeBirth} placeholder={"생년월일"} 
                type = "date"/>
                {birth}
            </div>
            <div>
                <select value={country} onChange={onChangeCountry}>
                    <option value="korea">한국</option>
                    <option value="Japan">일본</option>
                    <option value="CN">중국</option>
                    <option value="USA">미국</option>
                    <option value="India">인도</option>
                    {country}
                </select>
            </div>
            <div>
                <textarea value={bio} onChange={onChangeBio} />
            </div>
        </div>
    );
}
export default Register;
*/
const Register = () => {
    const [input, setInput] = useState({
        name: "",
        birth: "",
        country: "",
        bio: "",
    });
    const countRef = useRef(0);
    const inputRef = useRef();
    console.log("Register 렌더링");

    const onChange = (e) => {
        setInput({
            ...input,
            [e.target.name]: e.target.value,
        }); // 사용자가 입력한 값으로 변경.

    }
    const onSubmit = () =>{
        if(input.name === ""){
            console.log(inputRef.current)
            inputRef.current.focus();
        }
    }
    return (
        <div>
           
            <div>
                <input
                    ref = {inputRef}
                    name="name"
                    value={input.name}
                    onChange={onChange}
                    placeholder={"이름"}
                />
            </div>
            <div>
                <input
                    name="birth"
                    value={input.birth}
                    onChange={onChange}
                    placeholder={"생년월일"}
                    type="date"
                />
            </div>
            <div>
                <select
                    name="country"
                    value={input.country} onChange={onChange}>
                    <option value="korea">한국</option>
                    <option value="Japan">일본</option>
                    <option value="CN">중국</option>
                    <option value="USA">미국</option>
                    <option value="India">인도</option>
                    {input.country}
                </select>
            </div>
            <div>
                <textarea
                    name="bio"
                    value={input.bio}
                    onChange={onChange} />
            </div>

            <button onClick={onSubmit}>제출</button>
        </div>
    );
}
export default Register;