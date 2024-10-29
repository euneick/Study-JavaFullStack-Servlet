package VOs;

import java.sql.Date;

public class BoardVO {
	
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
	private int count;
	
	public BoardVO() {
	}

	public BoardVO(int idx, String id, String pw, String name, String email, String title, String content, int group,
			int level, int count) {
		
		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.title = title;
		this.content = content;
		this.group = group;
		this.level = level;
		this.count = count;
	}
	
	public BoardVO(int idx, String id, String pw, String name, String email, String title, String content, int group,
			int level, Date date, int count) {

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
		this.count = count;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
