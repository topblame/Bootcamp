package board;

public class BoardDTO {
	private int num;
	private String writer;
	private String email; 
	private String subject; 
	private String password;
	private String content;
	private String Reg_date;
	private int Readcount;
	private int ref; // 글번호-> 글번호를 참고해서 메인글 개수
	private int re_step; // 댓글의 번호를 추출하기 위한 글순서
	private int re_level; //최신 댓글을 추출하기 위한 글순서.
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public String getContent() {
		return content;
	}
	public String getReg_date() {
		return Reg_date;
	}
	public void setReg_date(String reg_date) {
		Reg_date = reg_date;
	}
	public int getReadcount() {
		return Readcount;
	}
	public void setReadcount(int readcount) {
		Readcount = readcount;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
