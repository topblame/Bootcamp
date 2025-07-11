function add(a,b){
    return a + b;
}

function substract(a,b){
    return a - b;
}

function multiply(a,b){
    return a*b;
}

function divide(a,b){
    if(b !== 0){
        return a/b;
    }
    else 
        throw new Error ("0으로는 나눌수 없습니다.");
}
export {
    add, 
    substract, 
    multiply, 
    divide
}