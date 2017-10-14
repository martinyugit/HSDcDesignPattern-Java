package com.hsdc.dp.service.domain.templatemethod;

import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.dto.templatemethod.PolicyTransaction;
import com.hsdc.dp.intf.service.templatemethod.RetrievePolicyTransactionUco;
import com.hsdc.dp.intf.util.ObjectCreator;
import com.hsdc.dp.service.util.SpringAppCtx;

@Service
public class RetrievePolicyTransactionUcoImpl implements RetrievePolicyTransactionUco {

	public List<PolicyTransaction> getTransactionList(String classKey) {
		Properties p = (Properties) SpringAppCtx.get().getBean("tmProperties");
		AbstractPolicyChangeTemplate policyChange = ObjectCreator.createObject(p.getProperty(classKey));
        return policyChange.getTransactionList();
	}

}
