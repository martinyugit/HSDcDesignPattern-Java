package com.hsdc.dp.service.factorymethod;

import java.util.List;

public abstract class MaintianUcoCreator<T> {
	protected abstract MaintainJobDao<T> CreateMaintaionJob();
    public List<T> ListAll()
    {
        MaintainJobDao<T> dao = CreateMaintaionJob();
        List<T> returnVal = dao.read();
        returnVal = businessRuleCheck(returnVal);
        return returnVal;
    }
    protected abstract List<T> businessRuleCheck(List<T> obj);
}
