package org.test.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

@Controller
public class mvcController {
	
	@Autowired
	private HttpServletRequest request;
	
    @Autowired
    private ServletContext servletContext;	

	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("login");
		
		return mv;
	}
	
//	@RequestMapping("/doLogin")
//	@ResponseBody
//	public String doLogin(@RequestParam(value="username") String username, @RequestParam(value="password") String password, HttpServletRequest request){
////		public String doLogin(@RequestParam Map<String,String> param){
//		
//		JSONObject jsonResult = new JSONObject();
//		HashMap<String, Object> result = new HashMap<String, Object>();
//		System.out.println("���յ���¼ҳ���������ݣ�");
//		
//		System.out.println("username:"+username);
//		System.out.println("password:"+password);
////		for (Entry<String, String> val : param.entrySet()) {
////			System.out.println("key:"+val.getKey()+",value:"+val.getValue());
////		}
//		
//		result.put("isLogin", true);
//		jsonResult.put("isLogin", true);
//		System.out.println(result);
//		return jsonResult.toString();
//	}
	
	@RequestMapping("/doLogin")
	@ResponseBody
	public String doLogin(){
		
		//上传目录
		String savePath = servletContext.getRealPath("/WEB-INF/upload");
		
		System.out.println(savePath);
		File file = new File(savePath);
		
		//判断上传目录是否存在
		if(!file.exists() && !file.isDirectory()){
			System.out.println(savePath+"目录不存在，需要创建");
			
			file.mkdirs();
		}
		
		//1、创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		//解决乱码
		upload.setHeaderEncoding("UTF-8");
		//3、判断提交上来的数据是否是上传表单的数据
		if(!ServletFileUpload.isMultipartContent(request)){
			System.out.print("cdcdc");
			//按照传统方式获取数据
			return null;
		}
		
		try {
			List<FileItem> list = upload.parseRequest(request);
			
			for (FileItem item : list) {
				//如果fileitem中封装的是普通输入项的数据
				if(item.isFormField()){
					String name = item.getFieldName();
					
					String value = item.getString();
					
					System.out.println(name+"=" + value);
				}else{
					String fileName = item.getName();
					
					System.out.println(fileName);
					
					if(fileName == null || fileName.trim().equals("")){
						continue;
					}
					
					fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
					
					InputStream in;
					in = item.getInputStream();
					
					FileOutputStream out;
					out = new FileOutputStream(savePath + "\\" +fileName);
					
					byte[] buffer = new byte[1024];
					
					int len = 0;
					
					while ((len=in.read(buffer)) > 0) {
						
						out.write(buffer, 0, len);
					}
					
					in.close();
					out.close();
					
					item.delete();
					System.out.print("文件上传成功！");
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			System.out.print("文件上传失败！");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONObject jsonResult = new JSONObject();

		jsonResult.put("isLogin", true);
		return jsonResult.toString();
	}	
}
