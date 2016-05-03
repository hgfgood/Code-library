package com.hgf.cn;

import javax.jws.WebService;

@WebService
public class Second {
	public int times(int a, int b) {
		return a*b;
	}
}
