package taehyeon.ezen.board.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class BoardDto {
	private long num;
	private String title;
	private String content;
	private String writer;
	private Date create_at;


}
