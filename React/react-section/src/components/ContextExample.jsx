import { createContext , useContext} from "react";

const UserContext = createContext();

const Profile = () =>{
    const user = useContext(UserContext); //UseContext 문서읽기
    return <p>안녕하세요 , {user.name}님!</p>
};
const ContextExample = () => {
    const user = { name: "soldesk"};
    return(
        <UserContext.Provider value={user}>
            <Profile/>
        </UserContext.Provider>
    )
}
export default ContextExample;