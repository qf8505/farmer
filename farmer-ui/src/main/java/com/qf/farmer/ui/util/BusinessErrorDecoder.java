package com.qf.farmer.ui.util;

import java.lang.reflect.Constructor;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;

import com.qf.farmer.common.exception.BusinessException;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder.Default;

/**
 * feign异常拦截处理
 * @author qinfei
 *
 */
@Configuration
public class BusinessErrorDecoder extends Default {

	@Override
	public Exception decode(String methodKey, Response response) {
		if (response.status() == 500) {
			try {
				if (response.body() != null) {
					String body = Util.toString(response.body().asReader());
					JSONObject json=new JSONObject(body);
					if(StringUtils.isNotBlank(json.getString("exception"))){
						Class<?> c=Class.forName(json.getString("exception"));
						Constructor<?> ct = c.getDeclaredConstructor(String.class);
						return (BusinessException) ct.newInstance(json.getString("message"));
					}
				}else{
					return super.decode(methodKey, response);
				}
			} catch (Exception e) {
				return new BusinessException(e);
			}
		}
		return super.decode(methodKey, response);
	}
}