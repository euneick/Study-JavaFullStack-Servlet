package VOs;

import java.sql.Date;

public class FileBoardVO {
	
	private int idx;
	private String id;
	private String pw;
	private String name;
	private String email;
	private String title;
	private String content;
	private int group;
	private int level;
	private Date date;
	private int cnt;
	private String ofile;
	private String sfile;
	private int downCount;
	
	public FileBoardVO() {
	}

	public FileBoardVO(int idx, String id, String pw, String name, String email, String title, String content,
			int group, int level, int cnt, String ofile, String sfile, int downCount) {
		
		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.title = title;
		this.content = content;
		this.group = group;
		this.level = level;
		this.cnt = cnt;
		this.ofile = ofile;
		this.sfile = sfile;
		this.downCount = downCount;
	}

	public FileBoardVO(int idx, String id, String pw, String name, String email, String title, String content,
			int group, int level, Date date, int cnt, String ofile, String sfile, int downCount) {

		this(idx, id, pw, name, email, title, content, group, level, cnt, ofile, sfile, downCount);		
		this.date = date;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getOfile() {
		return ofile;
	}

	public void setOfile(String ofile) {
		this.ofile = ofile;
	}

	public String getSfile() {
		return sfile;
	}

	public void setSfile(String sfile) {
		this.sfile = sfile;
	}

	public int getDownCount() {
		return downCount;
	}

	public void setDownCount(int downCount) {
		this.downCount = downCount;
	}
}
