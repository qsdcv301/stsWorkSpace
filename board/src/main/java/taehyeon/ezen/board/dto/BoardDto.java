package taehyeon.ezen.board.dto;


import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDto {
	private long num;
	private String title;
	private String contents;
	private String writer;
	private Timestamp create_at;


}
