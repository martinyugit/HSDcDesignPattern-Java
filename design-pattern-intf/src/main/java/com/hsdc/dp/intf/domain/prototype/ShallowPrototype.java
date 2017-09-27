package com.hsdc.dp.intf.domain.prototype;

import java.io.Serializable;

public interface ShallowPrototype<T> extends Serializable {
	T shallowClone();
}
