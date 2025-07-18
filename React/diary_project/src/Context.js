//Context.js : React Context 객체를 생성하고 내보내는 파일로 주로 js로 작성이 일반적

import { createContext } from "react";

export const DiaryStateContext = createContext(null);
export const DiaryDispatchContext = createContext(null);
