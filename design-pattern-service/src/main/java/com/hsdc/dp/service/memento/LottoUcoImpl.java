package com.hsdc.dp.service.memento;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.service.memento.LottoUco;

@Service
public class LottoUcoImpl implements LottoUco {

	private CareTaker careTaker = new CareTaker();
	
	//電腦選號
	public String computerSelNum() {
		Lotto lotto = new Lotto();
		return lotto.computerSelNum();
	}

	//下注
	public void doAppend(String number) {
		Lotto lotto = new Lotto();
		lotto.setNumber(number);
		careTaker.setMemento(-1, lotto.createMemento());
	}


	//還原
	public String doRestore(int i) {
		Lotto lotto = new Lotto();
		lotto.setMemento(careTaker.getMementoList().get(i));
		return lotto.getNumber();
	}

	//取下注清單
	public String getList() {
		StringBuffer sb = new StringBuffer();
		for(Memento m : careTaker.getMementoList()) {
			sb.append(m.getLotto().getNumber()).append("|");
		}
		return sb.toString();
	}

	//刪除
	public void doDelete(int idx) {
		careTaker.deleteMemento(idx);
	}

	public void doUpdate(int idx, String num) {
		Lotto lotto = new Lotto();
		lotto.setNumber(num);
		careTaker.setMemento(idx, lotto.createMemento());
	}

}
