package board.spring.mybatis;

import org.springframework.stereotype.Component;

@Component
public class BoardDTO {
	int seq;
	String title;
	String contents;
	String writer;
	int pw;
	int viewcount;
	String writingtime;
	
	public BoardDTO() {
		
	}
	
	
	public BoardDTO(String title, String contents, String writer, int pw) {
		super();
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.pw = pw;
		this.viewcount = 0;
	}


	
	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getWritingtime() {
		return writingtime;
	}
	public void setWritingtime(String writingtime) {
		this.writingtime = writingtime;
	}
}
