package net.taehyeon.community.model;

import lombok.Data;

@Data
public class BbsAdmin {
	private int id;
    private String bbsTitle;
    private String skin;
    private Byte category;
    private Byte listCount;
    private Byte pageCount;
    private Byte lGrade;
    private Byte rGrade;
    private Byte fGrade;
    private Byte reGrade;
    private Byte comGrade;
    private int fileSize;
    private int allFileSize;
    private String thImgSize;
    private String imgSize;
}
