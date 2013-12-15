package cn.edu.bjut.help.information.dao;

import org.springframework.stereotype.Repository;

import cn.edu.bjut.help.core.bo.Message;

@Repository
public interface MessageDao {
	public int saveMessage(Message msg);
}
