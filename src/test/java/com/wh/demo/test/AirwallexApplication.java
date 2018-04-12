package com.wh.demo.test;

/**
 * 程序运行类
 * 
 * @author wanghuan
 *
 */
public class AirwallexApplication {

	public static void main(String[] args) {
		OperationService operationService = new OperationServicImpl();
		operationService.run();
	}
}
