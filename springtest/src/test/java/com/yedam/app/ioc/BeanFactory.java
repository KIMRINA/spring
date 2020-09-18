package com.yedam.app.ioc;


public class BeanFactory {					// Bean 객체를 관리해주는 컨테이너
	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {	// 런 컨피규레이션에서 아귀먼트에서 런해보면 확인해볼 수 있음
			return new SamsungTV();
		} else if(beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
}
