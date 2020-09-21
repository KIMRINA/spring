package com.yedam.app.ioc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserContainer {

	public static void main(String[] args) {

		AbstractApplicationContext  factory =
				new GenericXmlApplicationContext("applicationContext.xml");	// GenericXmlApplicationContext는 bean factory 역할을 하는 객체
		/* TV tv = (TV)factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff(); */
		
		Speaker speaker1 = (Speaker)factory.getBean("sony");
		Speaker speaker2 = (Speaker)factory.getBean("sony");
		System.out.println(speaker1 == speaker2 ? "yes" : "no");	// scope= prototype 1,2는 서로 다른 객체 / singleton는 같은객체

	}
}
