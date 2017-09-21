package com.hsdc.dp.intf.domain.prototype;

import java.io.Serializable;

public interface Prototype<T> extends Serializable {
	T clone();
}
