package com.hsdc.dp.service.flyweight;

import java.util.List;

import com.hsdc.dp.intf.dao.flyweight.CodeDao;
import com.hsdc.dp.intf.domain.flyweight.Code;
import com.hsdc.dp.intf.dto.flyweight.CodeDto;
import com.hsdc.dp.service.util.SpringAppCtx;

public class UncachedCode implements Code {
	private CodeDao dao;
	private String codeType = "";
	public UncachedCode(String codeType)
    {
		if (dao == null) {
			dao = SpringAppCtx.get().getBean(CodeDao.class);
		}
        this.codeType = codeType;
    }

	public List<CodeDto> getCodeList(String parentValue) {
		return dao.query(codeType, parentValue);
	}

}
