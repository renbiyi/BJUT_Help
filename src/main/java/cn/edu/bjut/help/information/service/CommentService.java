package cn.edu.bjut.help.information.service;

import org.springframework.stereotype.Service;

import cn.edu.bjut.help.information.web.action.dto.CommentForm;


@Service
public interface CommentService {

	int saveComment(CommentForm form);
}
