package cn.edu.bjut.help.information.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.bjut.help.core.bo.Comment;

public interface CommentDao {
	void saveComment(Comment comment);
	List<Comment> listCommentsByMessageId(@Param("messageId") Long messageId, @Param("userId") Long userId);
}
