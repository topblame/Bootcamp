//weatherSimulator.js 모듈
export const weatherConditions = [
    "맑음",
    "흐림",
    "비",
    "폭풍",
    "눈",
    "바람",
  ];

  export function suggestActivity(weather){
    switch(weather){
        case "맑음":
            return "하이킹을 가보세요";
        
        case "흐림":
            return "책읽기 좋은 날씨입니다.";
        
        case "비":
            return "파전에 막걸리 그리고 실내에서 븜티기";
        
        case "폭풍":
            return "집밖은 위험해양";
        
        case "눈":
            return "하늘에서 쓰레기가 떨어진다.";
        
        case "바람":
            return "피크닉 가기 좋은 날씨네양";
        
    }
  }