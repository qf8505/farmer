package com.qf.farmer.common.util;

import com.qf.farmer.common.exception.BusinessException;

public class CommonUtil {

	public static String checkException(Exception e){
		if(e.getCause() instanceof BusinessException){
			return e.getCause().getMessage();
		}else{
			return e.getMessage();
		}
	}
}
