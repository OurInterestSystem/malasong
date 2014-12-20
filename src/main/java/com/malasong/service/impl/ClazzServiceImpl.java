package com.malasong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo2do.core.persistence.GenericDaoSupport;
import com.demo2do.core.service.impl.GenericServiceImpl;
import com.malasong.entity.Clazz;
import com.malasong.service.ClazzService;

@Service("clazzService")
public class  ClazzServiceImpl extends GenericServiceImpl<Clazz>  implements ClazzService {

	@Autowired
	private GenericDaoSupport genericDaoSupport;

	public List<Clazz> list() {
		return genericDaoSupport.loadAll(Clazz.class);
	}

}
