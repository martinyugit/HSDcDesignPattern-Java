package com.hsdc.dp.intf.service.memento;

import java.util.List;

public interface LottoUco {
	String computerSelNum();

	String getList();
	
	void doAppend(String str);
	void doDelete(int idx);	
	String doRestore(int idx);
	void doUpdate(int idx, String num);
}
