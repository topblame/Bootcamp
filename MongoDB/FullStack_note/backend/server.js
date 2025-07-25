const express = require('express'); //Node.js 프레임워크 -> 라우팅
const mongoose = require('mongoose'); // ODM (OBJECT DATA MODEL)-. mongodb modeling
const cors = require('cors'); // 도메인간의 통신(React와 express프레임워크 간의 통신)

const app = express();
app.use(cors()); //모든 출처의 요청 -> 브라우저 보안정책
app.use(express.json()); //JSON 데이터 파싱을 허용

mongoose.connect('mongodb://localhost:27017/fullstackDB', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
})
.then(() => console.log('✅ MongoDB connected'))
.catch(err => console.error('❌ MongoDB error:', err));

// 스키마 + 모델
const NoteSchema = new mongoose.Schema({
  title: String, //제목
  content: String, //내용
});
const Note = mongoose.model('Note', NoteSchema);
// 기본 API 호출하기.
app.get('/notes', async (req, res) => {
  const notes = await Note.find(); //전체 문서 검색
  res.json(notes); //json 데이터로 반환해줘.
});
// 기본 API 저장하기.
app.post('/notes', async (req, res) => {
  const {title, content} = req.body; //클라이언트가 요청한 데이터를 본문에서 추출
  const newNote = new Note({title, content}); // NoteSchema 테이블의 객체
  await newNote.save(); // mongodb에 newNote 저장.
  res.json({message: '✅ 저장완료'});
});
// 삭제
app.delete('/notes/:id', async (req, res) => {
  const { id } = req.params; // url(/notes/:id)에서 id 추출
  await Note.findByIdAndDelete(id);
  res.json({ message: '🗑️ 삭제 완료' });
});

// 수정
app.put('/notes/:id', async (req, res) => {
  const { id } = req.params; 
  const { title, content } = req.body; //수정할내용 추출
  await Note.findByIdAndUpdate(id, { title, content });
  res.json({ message: '✏️ 수정 완료' });
});

// 5천번 포트에서 서버실행.
app.listen(5000, () => {
      console.log('🚀 서버 실행 중: http://localhost:5000');
})