package cn.edu.bjut.help.information.web.action.dto;

import cn.edu.bjut.help.core.bo.Message;

public class MessageForm {

//	private Long uid;
	private String theme;
	private String content;
	private String contact;
	private Long expire;
//	private Date timestamp;
//	private Short type;
	private Double longitude;
	private Double latitude;

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double d) {
		this.longitude = d;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

//	public Long getUid() {
//		return uid;
//	}
//
//	public void setUid(Long uid) {
//		this.uid = uid;
//	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Long getExpire() {
		return expire;
	}

	public void setExpire(Long expire) {
		this.expire = expire;
	}

//	public Date getTimestamp() {
//		return timestamp;
//	}
//
//	public void setTimestamp(Date timestamp) {
//		this.timestamp = timestamp;
//	}
//
//	public Short getType() {
//		return type;
//	}
//
//	public void setType(Short type) {
//		this.type = type;
//	}
//	
	public Message createMessage(){
		Message msg = new Message();
//		m.setUserId(uid);
		msg.setContact(this.contact);
		msg.setContent(this.content);
		msg.setExpire(this.expire);
		msg.setLatitude(this.latitude);
		msg.setLongitude(this.longitude);
		msg.setTheme(this.theme);
//		m.setTimestamp(timestamp);
//		m.setType(type);
		return msg;
	}

}
