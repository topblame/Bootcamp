import useInput from "../hooks/useInput";

const InputComponent = () => {
    const [input, onChange] = useInput();
    const [input2, onChange2] = useInput();

    return(
        <div>
            <input value={input} onChange={onChange} />
            <input value={input2} onChange={onChange2} />
        </div>
    )
}
export default InputComponent;