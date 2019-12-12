package com.litao.cms.pojo;

import java.util.Date;

public class Comment {
	private Integer id;
	private Integer articleid;
	private Integer userid;
	private String content;
	private Date created;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", articleid=" + articleid + ", userid=" + userid + ", content=" + content
				+ ", created=" + created + "]";
	}
	public Comment(Integer id, Integer articleid, Integer userid, String content, Date created) {
		super();
		this.id = id;
		this.articleid = articleid;
		this.userid = userid;
		this.content = content;
		this.created = created;
	}
	public Comment() {
		super();
	}

}
