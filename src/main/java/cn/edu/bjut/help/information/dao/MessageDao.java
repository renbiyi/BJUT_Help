package cn.edu.bjut.help.information.dao;

import java.util.List;

import cn.edu.bjut.help.core.bo.Message;

public interface MessageDao {
	int saveMessage(Message msg);
	List<Message> findMessages();
}
