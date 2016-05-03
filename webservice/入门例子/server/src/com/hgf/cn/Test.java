package com.hgf.cn;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * 这是一个加法测试
 * 
 * @author hgfdo
 *
 */
@WebService
public class Test {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9090/test/Second", new Second());
		Endpoint.publish("http://localhost:9090/test/Add", new Add());
		System.out.println("发布成功！");
	}

}
