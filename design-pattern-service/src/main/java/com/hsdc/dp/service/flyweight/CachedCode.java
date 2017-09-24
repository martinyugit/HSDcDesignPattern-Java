/**
 * 
 */
package com.hsdc.dp.service.flyweight;

import java.util.List;

import com.hsdc.dp.intf.dao.flyweight.CodeDao;
import com.hsdc.dp.intf.domain.flyweight.Code;
import com.hsdc.dp.intf.dto.flyweight.CodeDto;
import com.hsdc.dp.service.util.SpringAppCtx;

/**
 * @author student
 *
 */
class CachedCode implements Code {
	private CodeDao dao;
	private List<CodeDto> codes;

	/* (non-Javadoc)
	 * @see com.hsdc.dp.intf.domain.flyweight.Code#GetCodeList(java.lang.String)
	 */
	public CachedCode(String CodeType)
    {
		if (dao == null) {
			dao = SpringAppCtx.get().getBean(CodeDao.class);
		}
        this.codes = dao.query(CodeType);
    }
	public List<CodeDto> getCodeList(String parentValue) {
		return this.codes;
	}

}
