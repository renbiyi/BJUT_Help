package cn.edu.bjut.help.information.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bjut.help.core.bo.Comment;
import cn.edu.bjut.help.core.excep.ServiceException;
import cn.edu.bjut.help.core.web.action.dto.Visitor;
import cn.edu.bjut.help.information.dao.CommentDao;
import cn.edu.bjut.help.information.service.CommentService;
import cn.edu.bjut.help.information.web.action.dto.CommentForm;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public boolean createComment(CommentForm form, Visitor visitor) {

		if(!validateComment(form)){
			return Boolean.FALSE;
		}
		
		Comment comment = form.createComment();
		comment.setUserId(visitor.getId());
		comment.setIsRead(Boolean.FALSE);
		comment.setTimestamp(new Date());
		commentDao.saveComment(comment);
		
		return Boolean.TRUE;
	}
	
	private boolean validateComment(CommentForm form) {
		return (StringUtils.isNotBlank(form.getContent()) && ObjectUtils.notEqual(form.getMessageId(), null));
	}

	@Override
	public List<Comment> listComments(Long messageId, Visitor visitor) throws ServiceException {
		if (ObjectUtils.equals(messageId, null)) {
			throw new ServiceException("messageId can't be null.");
		}
		return commentDao.listCommentsByMessageId(messageId, visitor.getId());
	}

}

	