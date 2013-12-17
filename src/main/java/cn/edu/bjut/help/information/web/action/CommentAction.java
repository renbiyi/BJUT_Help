package cn.edu.bjut.help.information.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjut.help.core.bo.Comment;
import cn.edu.bjut.help.core.excep.ServiceException;
import cn.edu.bjut.help.core.web.action.BaseAction;
import cn.edu.bjut.help.information.service.CommentService;
import cn.edu.bjut.help.information.web.action.dto.CommentForm;

@Controller  
@RequestMapping("comment")
public class CommentAction extends BaseAction {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "list/{messageId}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listComments(@PathVariable Long messageId){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<Comment> comments = null;
		try {
			comments = commentService.listComments(messageId, getVisitor());
		} catch (ServiceException e) {
			logger.warn("", e);
			jsonMap.put("status", 0);
			jsonMap.put("data", "error");
			return jsonMap;
		}
		
		jsonMap.put("status", 1);
		jsonMap.put("data", comments);
		return jsonMap;
	}
	
	//http://localhost:8080/comment/reply?messageId=21313&content=12312  {"status":1,"data":"success"}
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createComment(@ModelAttribute CommentForm form) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if (commentService.createComment(form, getVisitor())) {
			jsonMap.put("status", 1);
			jsonMap.put("data", "success");
		} else {
			jsonMap.put("status", 0);
			jsonMap.put("data", "error");
		}
		return jsonMap;
	}
	
	
}
