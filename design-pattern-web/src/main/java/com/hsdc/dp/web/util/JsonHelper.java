package com.hsdc.dp.web.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json公用程式
 * @author HSDc Team
 *
 */
public class JsonHelper {
	/**
	 * 將物件轉為 Json 字串
	 * @param objs
	 * @return
	 */
	public static String toJson(  Object objs){
		
		StringBuilder sb = new StringBuilder();
		ObjectMapper mapper = new ObjectMapper();
		//sb.append(callbackName + "(");
		try {
			sb.append(mapper.writeValueAsString(objs) );
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//sb.append(")");
		
		return sb.toString();
		
		
	}
	
	/**
	 * 將物件列表轉為 Json 字串
	 * @param objs
	 * @return
	 */
	public static String toJson(List<?> objs){
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(objs) ;
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";

	}
}
