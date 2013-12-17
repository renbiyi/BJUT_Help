package cn.edu.bjut.help.information.web.action.dto;

import cn.edu.bjut.help.core.bo.Comment;

public class CommentForm {
	private Long messageId;
	private String content;
	
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
	
	public Comment createComment(){
		Comment c = new Comment();
		c.setContent(content);
		c.setMessageId(messageId);
		return c;
	}
	

}
