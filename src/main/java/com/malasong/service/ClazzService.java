package com.malasong.service;

import java.util.List;

import com.demo2do.core.service.GenericService;
import com.malasong.entity.Clazz;

public interface ClazzService extends GenericService<Clazz>{

	public List<Clazz> list();

}
