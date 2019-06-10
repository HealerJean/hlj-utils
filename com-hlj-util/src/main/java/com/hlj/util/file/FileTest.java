package com.hlj.util.file;

import org.junit.Test;

import java.io.*;

public class FileTest {
	
	/**
	 * 6、
	 */
	static int i = 1; //用于保留统计记录的个数




	/**
	 * 1、路径不存在，fileNameTxt.createNewFile() 会抛出异常
	 * 2、只有路径，不会创建出文件，也不会报错，无法创建，但是不会报错
	 * 3、路径存在，文件不存在，创建成功
	 * 4、没有路径，只有文件文件，和src一个级别，创建成功
	 * @throws IOException 
	 */
	private  void createFile(String filePath) throws IOException {
		
			File fileNameTxt = new File(filePath);
			
			if(!fileNameTxt.exists()){
				fileNameTxt.createNewFile();
			}
			System.out.println("创建成功");
	}

	@Test
	public void createFile(){
		try {
//			1、路径不存在，fileNameTxt.createNewFile() 会抛出异常
//			createFile("D:/test/file/d01_createFile/d01_no_exist");
//			2、只有路径，不会创建出文件，也不会报错，无法创建，但是不会报错
//			createFile("D:/test/file/d01_createFile/d01_exist");
//			3、路径存在，文件不存在，创建成功
//			createFile("D:/test/file/d01_createFile/d01_exist/newFile.txt");
//			4、没有路径，只有文件文件，和src一个级别，创建成功
			createFile("newFile.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 2、创建有目录的文件
	 *  通过父的目录引入文件   directoryName 是父类
	 */
	private  void createHavaDirectoryFile(String directoryName ,String fileName) throws IOException {
		File directoryNameTxt = new File(directoryName,"directoryName.txt");
		if(!directoryNameTxt.exists()){
			directoryNameTxt.createNewFile();
		}
		System.out.println("创建有目录的文件成功");
	}

	@Test
	public void testCreateHavaDirectoryFile(){
		try {
			createHavaDirectoryFile("D:/test/file/d02_createHavaDirectoryFile","directoryName.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 2、 判断是文件或者目录
	 */
	private  void judgeFileOrDirectory(File path) {
			System.out.println("测试开始");
			if(path.isFile()){
				System.out.println(path.getPath()+"是一个文件");
			}
			else if(path.isDirectory()){
				System.out.println(path.getPath()+"是一个目录");
			}else {
				System.out.println(path.getPath()+"不是文件也不是目录");

			}
	}
	

	/**
	 * 3、创建目录
	 * 判断是不是目录
	 * 创建目录，即使路径不存在，也会创建相关路径，因为是mkdirs
	 */
	private  void createDirectory() {
		//引入目录
				File directoryName = new File("D:/test/healerjean/file");  
				if(!directoryName.exists()){
					directoryName.mkdirs();
					System.out.println(directoryName.getPath()+"创建目录成功"); 
				}
	}


	/**
	 * 4、复制文件
	 * 第一个文件以及路径必须存在， 否则fileInputStream会报错
	 * 第二个文件可以不存在,但是路径必须存在，如果路径不存在则FileOutSteam会报错
	 */
	 public  void copyFile(String inFilePath,String outFilePath) throws IOException{
	        FileInputStream ins = new FileInputStream(inFilePath);
	        FileOutputStream out = new FileOutputStream(outFilePath);
	        byte[] b = new byte[1024];
	        int n=0;
	        new   Thread();
	        while((n=ins.read(b))!=-1){
	            out.write(b, 0, n); 
	        }
	         
	        ins.close();
	        out.close();
	        System.out.println("复制文件成功");
	    }

	    @Test
		public void testCopyFile(){
	 	String inFilePath = "D:/test/file/d03_copyFile/exist/file.txt" ;
//	 	1、路径不存在， FileOutputStream out = new FileOutputStream(outFilePath); FileNotFoundException 异常
			String outFilePath = "D:/test/file/d03_copyFile/no_exist/newfile.txt" ;
//		1、路径存在，文件不存在，复制成功
//			String outFilePath = "D:/test/file/d03_copyFile/exist/new.txt" ;
			try {
				copyFile(inFilePath,outFilePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}



	 /**
	  * 5、删除多个目录
	  */
	 
	    public  void  delteFiles(File file){
	    	//file.listFiles()是获取file这个对象也就是file这个目录下面的文件和文件夹的集合
	        File[] files=file.listFiles(); 
	        for(File f:files)
	        {
	            if(f.isDirectory())//递归调用
	            {
	                delteFiles(f);
	            }
	            else {
	                f.delete();
	            }
	        }
	        file.delete();
	        System.out.println("删除目录成功");
	    }
	    
	    
	    /**
		 * 6 、目录下读取文件内容进行匹配
	     * @throws Exception 
		 * 
		 */
		private  void getFileValue(File file,String content) throws Exception {
			// 
			//file.listFiles()是获取file这个对象也就是file这个目录下面的文件和文件夹的集合
	        File[] files=file.listFiles(); 
	        for(File f:files)
	        {
	            if(f.isDirectory())//递归调用
	            {
	            	getFileValue(f,content);
	            }
	            else {  
	            	String path = f.getPath();
					FileInputStream fInputStream = new FileInputStream(f);
					ByteArrayOutputStream outStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[1024];
					int len = 0;
					while((len=fInputStream.read(buffer))!=-1){
						outStream.write(buffer, 0, len);
					}
					String str = new String(outStream.toByteArray(),"utf-8");
					if(str.contains(content)){
						System.out.println("第"+i+"个文件名为\n"+f.getPath());
						System.out.println("内容为\n"+str);
						i++;
					}
	            }
	        }
		}
		

		/**
		 * 7、获取txt文件内容
		 * 
		 */
		private  String getFileTextValue(String filePath) throws Exception {
			//  
			 FileInputStream fileInputStream = new FileInputStream(filePath);
			 ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
			 int len  = 0;
			 byte[] buffer = new byte[1024];
			 while((len = fileInputStream.read(buffer))!=-1){
				 byteOutputStream.write(buffer, 0, len);
			 }
			 String txtValue = new String(byteOutputStream.toByteArray());
			 System.out.println(txtValue);
			 return txtValue;
		}



		/**
		 * 8、按照行,一行一行读取txt内容	
		 */
		private  String getFileReadLineTextValue(String filePath) throws Exception {
		
			 FileInputStream fileInputStream = new FileInputStream(filePath);
			 ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
			 int len  = 0;
			 byte[] buffer = new byte[1024];
			 while((len = fileInputStream.read(buffer))!=-1){
				 byteOutputStream.write(buffer, 0, len);
			 }
			 byte[] txtByteArray = (byteOutputStream.toByteArray());
			 
			BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(txtByteArray),"utf-8"));
	     	String lineVal =null ;
	     	int flagLength = 0;
			while((lineVal = reader.readLine()) != null ){
				flagLength++;
			 if(flagLength==1){
				 System.out.println("第"+flagLength+"行的内容为"+lineVal);
				 System.out.println(lineVal.substring(0,7));
				 System.out.println(lineVal.substring(0,8));
			 }
			 else{
				 System.out.println("第"+flagLength+"行的内容为"+lineVal);			 
			 }
			 
			}
	     	
	     	
			return null;
		}

		
		  /**
		    * 9、根据字符串生成内容
		   * 	9.1、先创建路径，
		    */
		public  void getTxtByTextContent(String textContext,String fileName,String path){
			try {
				File fileDirectory = new File(path);
				if(!fileDirectory.exists()){
					fileDirectory.mkdirs();
				}
				FileOutputStream outputStream = new FileOutputStream(path+"/"+fileName);
				byte[] buffer = textContext.getBytes("utf-8");
				outputStream.write(buffer);
			System.out.println("成功"+path+"/"+fileName);
				
			} catch (FileNotFoundException e) {
				// 
				e.printStackTrace();
			}catch (UnsupportedEncodingException e) {
				// 
				e.printStackTrace();
			} catch (IOException e) {
				// 
				e.printStackTrace();
			} 
			
		}
		
		
		/**
		 * 10、操作系统 路径符号判断
		* @author  作者 HealerJean: 
		* @version 创建时间：2017年11月1日 上午9:32:49 
		*
		 */
		public  void testSeparator(){
			/**
			 * 1、判断哪个系统
			 */
			File directoryName	  = new File("D:"+File.separator+"test/txt.txt");
			System.out.println(directoryName.getPath()); 
			String os = System.getProperty("os.name");
			if(os.startsWith("Win")){
				System.out.printf("This system is windows");
				System.out.println(":::"+os);

			}else { //linux
				
			}
			/**
			 * 2、系统路径的代表符号 
			 * / linux 
			 * \ windows
			 */
			String fileSeparator = System.getProperty("file.separator");
			System.out.println(fileSeparator); 
			
			System.out.println(""+File.separator); 
			
			
		
		}

}
