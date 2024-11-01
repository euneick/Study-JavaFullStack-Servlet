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
			int group, int level, Date date, int cnt, String ofile, String sfile, int downCount) {

		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.title = title;
		this.content = content;
		this.group = group;
		this.level = level;
		this.date = date;
		this.cnt = cnt;
		this.ofile = ofile;
		this.sfile = sfile;
		this.downCount = downCount;
	}

	public int getIdx() {
		return idx;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public int getGroup() {
		return group;
	}

	public int getLevel() {
		return level;
	}

	public Date getDate() {
		return date;
	}

	public int getCnt() {
		return cnt;
	}

	public String getOfile() {
		return ofile;
	}

	public String getSfile() {
		return sfile;
	}

	public int getDownCount() {
		return downCount;
	}
}
