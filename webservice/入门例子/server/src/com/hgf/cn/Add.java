package com.hgf.cn;

import javax.jws.WebService;


@WebService
public class Add {
	/**
	 * �ӷ�����
	 * 
	 * @param a ������
	 * @param b ����
	 * @return �ӽ��
	 */
	public int add(int a, int b){
		System.out.println("��������"+(a+b));
		return a+b;
	}
}
