package com.hsdc.dp.persist.dao.flyeweight;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hsdc.dp.intf.dao.flyweight.CodeDao;
import com.hsdc.dp.intf.dto.flyweight.CodeDto;
import com.hsdc.dp.persist.dto.flyeweight.CodeDtoImpl;

@Repository
public class CodeDaoImpl implements CodeDao {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<CodeDto> query(String type) {
		String sql = "SELECT ID, CODEVALUE, CODETEXT FROM CODE WHERE CODETYPE=:type";
		Query q = entityManager.createNativeQuery(sql, CodeDtoImpl.class)
				.setParameter("type", type);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CodeDto> query(String type, String parentValue) {
		String sql = "SELECT ID, CODEVALUE, CODETEXT, PARENTID FROM CODE AS C1 "
				+ "INNER JOIN (SELECT ID, CODEVALUE FROM CODE) AS C2 ON (C1.PARENTID = C2.ID) "
				+ "WHERE C1.CODETYPE=:type AND C2.CODEVALUE=:parent";
		Query q = entityManager.createNativeQuery(sql, CodeDtoImpl.class)
				.setParameter("type", type)
				.setParameter("parent", parentValue);
		return q.getResultList();
	}

}
