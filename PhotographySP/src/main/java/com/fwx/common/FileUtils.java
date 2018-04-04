package com.fwx.common;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception { 
        File targetFile = new File(filePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }       
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
	  public static boolean saveFile(MultipartFile file,String filePath) {  
	        // 判断文件是否为空  
	        if (!file.isEmpty()) {  
	            try {  
	                // 文件保存路径  
	               
	                // 转存文件  
	                file.transferTo(new File(filePath));  
	                return true;  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        return false;  
	    }  
	  public static boolean delete(String fileName) {
	        File file = new File(fileName);
	        if (!file.exists()) {
	          
	            return false;
	        } else {
	            if (file.isFile())
	                return deleteFile(fileName);
	            else
	                return deleteDirectory(fileName);
	        }
	    }

	  
	 
	    public static boolean deleteFile(String fileName) {
	        File file = new File(fileName);
	        // ����ļ�·������Ӧ���ļ����ڣ�������һ���ļ�����ֱ��ɾ��
	        if (file.exists() && file.isFile()) {
	            if (file.delete()) {
	            	
	                return true;
	            } else {
	            	
	                return false;
	            }
	        } else {
	        	
	            return false;
	        }
	    }
	    public static boolean deleteDirectory(String dir) {
	        // ���dir�����ļ��ָ�����β���Զ�����ļ��ָ���
	        if (!dir.endsWith(File.separator))
	            dir = dir + File.separator;
	        File dirFile = new File(dir);
	        // ���dir��Ӧ���ļ������ڣ����߲���һ��Ŀ¼�����˳�
	        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
	        	
	            return false;
	        }
	        boolean flag = true;
	        // ɾ���ļ����е������ļ�������Ŀ¼
	        File[] files = dirFile.listFiles();
	        for (int i = 0; i < files.length; i++) {
	            // ɾ�����ļ�
	            if (files[i].isFile()) {
	                flag = FileUtils.deleteFile(files[i].getAbsolutePath());
	                if (!flag)
	                    break;
	            }
	            // ɾ����Ŀ¼
	            else if (files[i].isDirectory()) {
	                flag = FileUtils.deleteDirectory(files[i]
	                        .getAbsolutePath());
	                if (!flag)
	                    break;
	            }
	        }
	        if (!flag) {
	        	
	            return false;
	        }
	        // ɾ����ǰĿ¼
	        if (dirFile.delete()) {
	        	
	            return true;
	        } else {
	            return false;
	        }
	    }
}
