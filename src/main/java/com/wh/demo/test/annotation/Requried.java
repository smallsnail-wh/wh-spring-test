package com.wh.demo.test.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class Requried {

	private ModelTest modelTest;

	public ModelTest getModelTest() {
		return modelTest;
	}

	@Required
	@Autowired
	public void setModelTest(ModelTest modelTest) {
		this.modelTest = modelTest;
	}
	
	
	
}
