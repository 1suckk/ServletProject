package reboard.data;

import java.sql.Date;
import java.sql.Timestamp;

/*
create table reboard
(
	num smallint auto_increment primary key,
    writer varchar(100),
    photo varchar(200),
    passwd varchar(20),
    subject varchar(500),
    content varchar(2048),
    readcount smallint default 0,
    writeday datetime,
    regroup smallint,
    relevel smallint,
    restep smallint
);
 */

public class BoardDto {
	private int num;
	private String writer;
	private String photo;
	private String passwd;
	private String subject;
	private String content;
	private int readcount;
	private Timestamp writeday;
	private int regroup;
	private int relevel;
	private int restep;
	
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	public int getRegroup() {
		return regroup;
	}
	public void setRegroup(int regroup) {
		this.regroup = regroup;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
