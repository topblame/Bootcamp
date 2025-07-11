export function add2(a,b){
    return a + b;
}

export function substract2(a,b){
    return a - b;
}

//multiply: 
export default function multiply2(a,b){
    return a*b;
}

export function divide2(a,b){
    if(b !== 0){
        return a/b;
    }
    else 
        throw new Error ("0으로는 나눌수 없습니다.");
}
