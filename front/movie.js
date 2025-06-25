const dateInput = document.querySelector("#dateInput");
const msg = document.querySelector("#msg");
const box3 = document.querySelector("#box3");

//어제 날짜를 기본값으로 설정하는 코드 

// 상세 정보 보여주기
function show(movieCd) {
    const url = `https://kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=3b332ef4a3da86661a2814114a483318&movieCd=${movieCd}`;

    //박스오피스APi 호출
    fetch(url)
        .then(res => res.json())
        .then(date => {
            const info = date.movieInfoResult.movieInfo;
            let str = "<ul>";
            str += `<li> 영화제목: ${info.movieNm}</li>`;
            str += `<li>감독: ${info.directors.map(d => d.peopleNm).join(", ")}</li>`;
            str += `<li>배우: ${info.actors.slice(0, 3).map(a => a.peopleNm).join(", ")}</li>`;
            str += `<li>장르: ${info.genres.map(g => g.genreNm).join(", ")}</li>`;
            str += `<li>개봉일: ${info.openDt}</li>`;
            str += "</ul>";
            document.querySelector("#msg").innerHTML = str;
        })
}
(function setDefaultDate() {
    const yesterday = new Date(Date.now() - 86400000);
    dateInput.value = yesterday.toISOString().slice(0, 10); // yyyy-mm-dd
})(); // 함수 정의 후 즉시실행. 
// 박스 오피스 조회
document.querySelector("#btn1").addEventListener("click", () => {
    const targetDt = dateInput.value.replace(/-/g, ""); // yyyy-mm-dd → yyyymmdd
    const url = `https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=3b332ef4a3da86661a2814114a483318&targetDt=${targetDt}`;

    fetch(url)
        .then(res => res.json())
        .then(data => {
            const list = data.boxOfficeResult.dailyBoxOfficeList;

            let html = "<ul>";
            list.forEach(movie => {
                html += `<li data-code="${movie.movieCd}">${movie.rank}. ${movie.movieNm}</li>`;
            });
            html += "</ul>";

            msg.innerHTML = html;

            // 나중에 클릭 이벤트 연결할 수 있게 준비
            document.querySelectorAll("#msg li").forEach(li => {
                li.addEventListener("click", () => {
                    const movieCd = li.getAttribute("data-code");
                    show(movieCd); // ← 상세 보기 호출
                });
            });
        });
});