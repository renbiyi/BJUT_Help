package cn.edu.bjut.help.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bjut.help.information.dao.CommentDao;
import cn.edu.bjut.help.information.service.CommentService;
import cn.edu.bjut.help.information.web.action.dto.CommentForm;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public int saveComment(CommentForm form) {
		int ret = 0;
		if(form.getUserId()!=null && form.getIsRead()!=null 
			&& form.getContent()!=null && form.getMessageId()!=null
			&& form.getTimestamp()!=null){
			commentDao.saveComment(form.createComment());
			ret = 1;
		}else{
			ret = 0;
		}	
		return ret;
	}

}

	