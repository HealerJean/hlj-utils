package com.hlj.util.path;

import java.net.URL;

/**
 *  ��weblogic ʹ�ñ�ʵ��
 */
public class ClassLoadThead {

	public static void main(String[] args) {
		threadClassload();
	}
	private static void threadClassload() {

		//�� / ������ʾ
		URL urlThread_ =Thread.currentThread().getContextClassLoader().getResource("");
		System.out.println("urlThread_"+urlThread_);
		// �� / null
		URL urlThread_1 =Thread.currentThread().getContextClassLoader().getResource("/");
		System.out.println("urlThread_1:λ�գ�����"+urlThread_1);

		//�� / ������ʾ
		// URL urlClassLoader_ = FileTest.class.getClassLoader().getResource("");
		// System.out.println("urlClassLoader_"+urlClassLoader_);

		// �� / null
		// URL urlClassLoader_1 = FileTest.class.getClassLoader().getResource("/");
		// System.out.println("urlClassLoader_1"+urlClassLoader_1);

	}
}
