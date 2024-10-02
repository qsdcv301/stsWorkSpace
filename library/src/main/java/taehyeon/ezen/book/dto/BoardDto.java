package taehyeon.ezen.book.dto;

import java.sql.Timestamp;

public class BoardDto {
	private long num;
	private String title;
	private String contents;
	private String writer;
	private int count;
	private Timestamp wdate;
	private String userid;
	private String password;
	private String viewDate;

	public BoardDto() {
	}

	public BoardDto(long num, String title, String contents, String writer, int count, Timestamp wdate, String userid,
			String password, String viewDate) {
		super();
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.count = count;
		this.wdate = wdate;
		this.userid = userid;
		this.password = password;
		this.viewDate = viewDate;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Timestamp getWdate() {
		return wdate;
	}

	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getViewDate() {
		return viewDate;
	}

	public void setViewDate(String viewDate) {
		this.viewDate = viewDate;
	}

	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", title=" + title + ", contents=" + contents + ", writer=" + writer
				+ ", count=" + count + ", wdate=" + wdate + ", userid=" + userid + ", password=" + password
				+ ", viewDate=" + viewDate + "]";
	}

}
