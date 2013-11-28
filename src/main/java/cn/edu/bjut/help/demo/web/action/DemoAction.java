package cn.edu.bjut.help.demo.web.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  
@RequestMapping("demo")
public class DemoAction {

	@RequestMapping(value = "hellojson", method = RequestMethod.GET) 
	@ResponseBody
    public Map<String, Object> hellojson() {  
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("status", 200);
		jsonMap.put("data", "zhanghao");
		
        return jsonMap;
    }
}
