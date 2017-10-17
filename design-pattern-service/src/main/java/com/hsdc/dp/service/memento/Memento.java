package com.hsdc.dp.service.memento;


public class Memento {

	private Lotto lotto;

	public Memento(Lotto lotto) {
		this.lotto = lotto;
	}

	public Lotto getLotto() {
		return lotto;
	}

	public void setLotto(Lotto lotto) {
		this.lotto = lotto;
	}
}
