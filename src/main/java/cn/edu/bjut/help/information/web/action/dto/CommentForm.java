package cn.edu.bjut.help.information.web.action.dto;

import java.util.Date;

import cn.edu.bjut.help.core.bo.Comment;

public class CommentForm {
	private Long userId;
	private Long messageId;
	private String content;
	private Date timestamp;
	private Boolean isRead;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

	public Comment createComment(){
		Comment c = new Comment();
		c.setUserId(userId);
		c.setContent(content);
		c.setTimestamp(timestamp);
		c.setIsRead(isRead);
		c.setMessageId(messageId);
		return c;
	}
	

}
