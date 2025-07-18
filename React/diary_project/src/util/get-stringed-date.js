export const getStringedDate = (targetDate) => {
  // yyyy-mm-dd
  /*
  JS의 Date 객체를 받아서 yyyy-mm--dd 
  */
  let year = targetDate.getFullYear();
  let month = targetDate.getMonth() + 1;
  let date = targetDate.getDate();
  //날짜와 월을 두자릿수 문자열로 포맷팅.
   if (month < 10) {
    month = `0${month}`;  }
  if (date < 10) {
    date = `0${date}`;
  }

  return `${year}-${month}-${date}`;
};