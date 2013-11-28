package cn.edu.bjut.help.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.edu.bjut.help.account.dao.ResourceDao;
import cn.edu.bjut.help.account.service.ResourceService;
import cn.edu.bjut.help.core.bo.Resource;

@Component("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;
	
	@Override
	public List<Resource> findAllResources() {
		return resourceDao.findAllResources();
	}

}
