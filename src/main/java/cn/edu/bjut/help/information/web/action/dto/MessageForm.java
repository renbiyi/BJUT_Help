package cn.edu.bjut.help.information.web.action.dto;

import cn.edu.bjut.help.core.bo.Message;

public class MessageForm {

	private String theme;
	private String content;
	private String contact;
	private Long expire;
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

	public Message createMessage(){
		Message msg = new Message();
		msg.setContact(this.contact);
		msg.setContent(this.content);
		msg.setExpire(this.expire);
		msg.setLatitude(this.latitude);
		msg.setLongitude(this.longitude);
		msg.setTheme(this.theme);
		return msg;
	}

}
