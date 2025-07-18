import { useEffect } from "react";

const Event = () => {
    useEffect(() => {
        return () => {
            console.log("unmount")
        }
    }, [])
    return <div>짝수 입니다.</div>
}
export default Event;