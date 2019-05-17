package com.hlj.util.xml;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 设置FreeMarker的模版文件位置
 1、类路径，当前类下面的文件
 cfg.setClassForTemplateLoading(CreateXmlByVmFile.class,"");
 或者
 TemplateLoader templateLoaderClass = new ClassTemplateLoader(CreateXmlByVmFile.class,"");
 cfg.setTemplateLoader(templateLoaderClass);
 2、文件系统 ,文件目录
 cfg.setDirectoryForTemplateLoading(fileDirectory);
 或者
 TemplateLoader templateLoaderFile=new FileTemplateLoader(new File("E:/workspace/JavaWorkspace/CompanyOffer/bin/com/hlj/xml/"));
 cfg.setTemplateLoader(templateLoaderFile);
 3、Servlet Context。
 setServletContextForTemplateLoading(Object servletContext, String path);
 */
public  class CreateXmlByVmFile
{    


	public static void main(String args[]) throws TemplateException, IOException{
		XmlEntry p =new XmlEntry();
		p.setAge(24);
		p.setPerson("张宇晋");
		p.setSex(1);
		Map map = new HashMap();
		map.put("name", "zhangyujin");
		map.put("x", p);
		String xml = 	createXmlFile("CreateXmlByVmFile.vm", map);
		System.out.println(xml);

 }    
	/**
	 * 
	 * @param TemplateName 模板的名字
	 * @param dataMap 数据源
	 * @return
	 */
	public  static String createXmlFile(String TemplateName, Map dataMap) throws TemplateException, IOException     {


		  //得FreeMarker配置对象
		  // 创建Configuration对象
		   Configuration cfg = new Configuration();
		   cfg.setEncoding(Locale.CHINA, "UTF-8");

		   File file = new File(CreateXmlByVmFile.class.getResource("").getFile());
		   cfg.setDirectoryForTemplateLoading(file);
		   Template template = cfg.getTemplate(TemplateName,"utf-8");

		   StringWriter w =new StringWriter();    		      
		           // 生成xml  
		   template.process(dataMap, w);    
		   return w.toString();
		   }
}