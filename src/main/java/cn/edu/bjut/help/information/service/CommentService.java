package cn.edu.bjut.help.information.service;

import java.util.List;

import cn.edu.bjut.help.core.bo.Comment;
import cn.edu.bjut.help.core.excep.ServiceException;
import cn.edu.bjut.help.core.web.action.dto.Visitor;
import cn.edu.bjut.help.information.web.action.dto.CommentForm;


public interface CommentService {

	boolean createComment(CommentForm form, Visitor visitor);
	List<Comment> listComments(Long messageId, Visitor visitor) throws ServiceException;
}
