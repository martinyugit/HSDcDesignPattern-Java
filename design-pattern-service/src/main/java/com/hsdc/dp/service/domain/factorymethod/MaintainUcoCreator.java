package com.hsdc.dp.service.domain.factorymethod;

import java.util.List;

public abstract class MaintainUcoCreator<T> {
	protected abstract MaintainJobDao<T> createMaintaionJob();
	
	 public List<T> listAll()
     {
         MaintainJobDao<T> dao = createMaintaionJob();
         List<T> returnVal = dao.read();
         returnVal = businessRuleCheck(returnVal);
         return returnVal;
     }
	 
	 protected abstract List<T> businessRuleCheck(List<T> obj);
}
