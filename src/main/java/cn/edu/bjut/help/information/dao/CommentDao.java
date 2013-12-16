package cn.edu.bjut.help.information.dao;

import org.springframework.stereotype.Repository;
import cn.edu.bjut.help.core.bo.Comment;

@Repository
public interface CommentDao {
	public void saveComment(Comment comment);
}
