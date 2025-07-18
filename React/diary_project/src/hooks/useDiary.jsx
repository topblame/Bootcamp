import { useContext, useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { DiaryStateContext } from "../Context";

//커스텀 훅: 특정 id에 해당하는 일기 데이터를 찾아 반환하는로직
/*
1. id 전달
2. diaryStateContext 에서 전체 일기 목록을 불러옴
3. 해당 id에 일기를 찾아서 반환
4. 일기가 없으면 경고창을 띄우고 /로 이동.
*/
const useDiary = (id) => {
    const data = useContext(DiaryStateContext);
    //현재 id에 해당하는 일기. 나중에 해당일기 설정
    const [curDiaryItem, setCurDiaryItem] = useState();
    const nav = useNavigate();

    useEffect(() => {
        //id에 해당하는 일기를data에서 find()로 검색
        const currentDiaryItem = data.find(
            // 숫자와 문자 비교시 타입자동변화 
            (item) => String(item.id) === String(id)
        );
        //일기를 못찾은 경우.
        if (!currentDiaryItem) {
            window.alert("존재하지 않는 일기입니다.");
            nav("/", { replace: true });
        }
        //일기를 찾은 경우 상태를 리턴
        setCurDiaryItem(currentDiaryItem);
    }, [id, data, nav]) //일기 id, 전체 목록이 바뀌거나, 페이지가 이동되거나
    return curDiaryItem;
}
export default useDiary;