package cn.edu.bjut.help.information.web.action.dto;

import cn.edu.bjut.help.core.bo.Message;

public class MessageVO extends Message implements Comparable<MessageVO> {

	private static final long serialVersionUID = 2869598628156550446L;

	private Double distance;

	public MessageVO(Message msg) {
		this.setId(msg.getId());
		this.setUserId(msg.getUserId());
		this.setTheme(msg.getTheme());
		this.setTimestamp(msg.getTimestamp());
		this.setContent(msg.getContent());
		this.setContact(msg.getContact());
		this.setType(msg.getType());
		this.setExpire(msg.getExpire());
		this.setLongitude(msg.getLongitude());;
		this.setLatitude(msg.getLatitude());
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(MessageVO vo) {
		return distance.compareTo(vo.getDistance());
	}

}
