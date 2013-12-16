package cn.edu.bjut.help.information.web.action;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjut.help.account.service.UserService;
import cn.edu.bjut.help.core.web.action.BaseAction;
import cn.edu.bjut.help.information.service.CommentService;
import cn.edu.bjut.help.information.web.action.dto.CommentForm;
import cn.edu.bjut.help.information.web.action.dto.MessageForm;

@Controller  
@RequestMapping("comment")
public class CommentAction extends BaseAction {
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	@ResponseBody
	public void viewCommentByMid(@ModelAttribute Long mid){
		
	}
	
	//http://localhost:8080/comment/reply?messageId=21313&content=12312  {"status":1,"data":"success"}
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createComment(@ModelAttribute CommentForm form){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		int ret;
		if(username!=null){
			Long uid = userService.findUserByUsername(username).getId();
			form.setUserId(uid);
			form.setTimestamp(new Date());
			form.setIsRead(false);
			ret = commentService.saveComment(form);
			if(ret==1){
				jsonMap.put("status", ret);
				jsonMap.put("data", "success");
			}else{
				jsonMap.put("status", 0);
				jsonMap.put("data", "error");
			}
		}
		return jsonMap;
	}
	
	
}
