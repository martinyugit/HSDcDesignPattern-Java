package com.hsdc.dp.intf.util;

public final class ObjectCreator {
	public static <T> T createObject(String className) {
		try {
			@SuppressWarnings("unchecked")
			Class<T> c = (Class<T>)Class.forName(className);
			return createObject(c);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private static <T> T createObject(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
