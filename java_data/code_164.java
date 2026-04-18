package com.galaxy.kite.algorithm.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

	private Object realObject = null;

	public ProxyHandler(IRealObject target) {
		this.realObject = target;
		
	}
	
	public IRealObject bind() {
		return  (IRealObject) Proxy.newProxyInstance(realObject.getClass().getClassLoader(),
				RealObject.class.getInterfaces(),
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.println("Begin to proxy:");
		Object result = method.invoke(realObject, args);
		System.out.println("End to proxy");
		
		return result;
	}

}