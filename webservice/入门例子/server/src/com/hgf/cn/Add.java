package com.hgf.cn;

import javax.jws.WebService;


@WebService
public class Add {
	/**
	 * 加法运算
	 * 
	 * @param a 被加数
	 * @param b 加数
	 * @return 加结果
	 */
	public int add(int a, int b){
		System.out.println("服务器："+(a+b));
		return a+b;
	}
}
