package com.hxh.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class MapUtil  {
	private static final String SUCCESS_MESSAGE = "操作成功！";
	private static final String ERROR_MESSAGE = "操作失败！";
	private static Map<String, Object> messageMap = new HashMap<String, Object>();
	/**
	 * 
	 * <p>Title: getParameterMap2</p> 
	 * <p>Description: 获取前台map。  06-10更新</p> 
	 * @param request
	 * @return Map对象
	 * 作者:xiangshunjie
	 */
	public static Map<String,Object> getParameterMap(HttpServletRequest request) {
		Map<String,Object> result = new HashMap<String, Object>();
		Map<String,String[]> map = request.getParameterMap();
		String[] v = null;
		for(Object o :map.keySet()){
			v = (String[])map.get(o);//单个map
		
			result.put(o.toString(), (v.length == 1) ? (StringUtils.isEmpty((v)[0])) ? null : (v)[0] : map.get(o));
		}
		
		return result;
	}
}
