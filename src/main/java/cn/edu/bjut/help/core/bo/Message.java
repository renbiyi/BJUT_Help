package cn.edu.bjut.help.core.bo;

import java.io.Serializable;

import java.sql.Date;

public class Message implements Serializable {

	private static final long serialVersionUID = -2368691093937464933L;

	private Long id;
	private Long userId;
	private String theme;
	private Date timestamp;
	private String content;
	private String contact;
	private Short type;
	private Long expire;
	private Double longitude;
	private Double latitude;

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp2) {
		this.timestamp = timestamp2;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Long getExpire() {
		return expire;
	}

	public void setExpire(Long expire) {
		this.expire = expire;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
