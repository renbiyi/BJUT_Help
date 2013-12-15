package cn.edu.bjut.help.information.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjut.help.core.web.action.BaseAction;

//@Controller  
//@RequestMapping("comment")
public class CommentAction extends BaseAction {
	
	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	@ResponseBody
	public void viewCommentByMid(){
		
		
	}
	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	@ResponseBody
	public void replyMessage(){
		
		
	}
}
