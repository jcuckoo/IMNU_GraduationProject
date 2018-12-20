package com.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.model.*;
import com.service.*;
import com.util.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
//导入导出

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

@Controller
public class YoukeAction {
	@Autowired
	private YoukeService youkeService;
	@Autowired
	private YhbumenService yhbumenService;
	@Autowired
	private YhroleService yhroleService;

	/***上传导入开始***/
	private InputStream excelFile;

	public InputStream getExcelFile() {
		return excelFile;
	}
	/***上传导入结束***/

	@RequestMapping("/getYoukes")
	public void getYoukes(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String page = (String) request.getParameter("page");
		String rows = (String) request.getParameter("rows");
		String youkeName = (String) request.getParameter("youkeName");
		String youkeXingming = (String) request.getParameter("youkeXingming");
		String youkeId = (String) request.getParameter("youkeId");
		String youkeType1 = (String) request.getParameter("youkeType1");
		String youkeType2 = (String) request.getParameter("youkeType2");
		String yhroleId = (String) request.getParameter("yhroleId");
		String youkeSex = (String) request.getParameter("youkeSex");
		String yhbumenId = (String) request.getParameter("yhbumenId");
		String sdate = (String) request.getParameter("sdate");
		String edate = (String) request.getParameter("edate");
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Youke youke = new Youke();
		try {

			if (StringUtil.isNotEmpty(youkeXingming)) {
				youke.setYoukeXingming(youkeXingming);
			}
			if (StringUtil.isNotEmpty(youkeName)) {
				youke.setYoukeName(youkeName);
			}
			if (StringUtil.isNotEmpty(youkeId)) {
				youke.setYoukeId(Integer.parseInt(youkeId));
			}
			if (StringUtil.isNotEmpty(youkeType1)) {
				youke.setYoukeType1(Integer.parseInt(youkeType1));
			}
			if (StringUtil.isNotEmpty(youkeType2)) {
				youke.setYoukeType2(Integer.parseInt(youkeType2));
			}
			if (StringUtil.isNotEmpty(yhroleId)) {
				youke.setYhroleId(Integer.parseInt(yhroleId));
			}
			if (StringUtil.isNotEmpty(youkeSex)) {
				youke.setYoukeSex(Integer.parseInt(youkeSex));
			}
			if (StringUtil.isNotEmpty(yhbumenId)) {
				youke.setYhbumenId(Integer.parseInt(yhbumenId));
			}
			JSONArray jsonArray = JSONArray.fromObject(youkeService.queryYoukes(
					youke, null, pageBean.getStart(), pageBean.getRows(), sdate, edate));
			JSONObject result = new JSONObject();
			int total = youkeService.queryYoukes(youke, null, 0, 0, sdate, edate).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/addYouke")
	public void addYouke(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JSONObject result = new JSONObject();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String youkeName = (String) request.getParameter("youkeName");
		String youkePassword = (String) request.getParameter("youkePassword");
		String youkeAge = (String) request.getParameter("youkeAge");
		String youkeXingming = (String) request.getParameter("youkeXingming");
		String youkeSex = (String) request.getParameter("youkeSex");
		String youkePhone = (String) request.getParameter("youkePhone");
		String youkeMark1 = (String) request.getParameter("youkeMark1");
		String youkeMark2 = (String) request.getParameter("youkeMark2");
		String youkeMark3 = (String) request.getParameter("youkeMark3");
		String youkeMark4 = (String) request.getParameter("youkeMark4");
		String youkeDate1 = (String) request.getParameter("youkeDate1");
		String youkeDate2 = (String) request.getParameter("youkeDate2");
		String youkeType1 = (String) request.getParameter("youkeType1");
		String youkeType2 = (String) request.getParameter("youkeType2");
		String yhroleId = (String) request.getParameter("yhroleId");
		String yhbumenId = (String) request.getParameter("yhbumenId");
		String youkeId = (String) request.getParameter("youkeId");
		Youke youke = new Youke();

		if (StringUtil.isNotEmpty(youkeId)) {
			youke = youkeService.getYouke(Integer.parseInt(youkeId));
		}
		if (StringUtil.isNotEmpty(youkeName)) {
			youke.setYoukeName(youkeName);
		}
		if (StringUtil.isNotEmpty(youkePassword)) {
			youke.setYoukePassword(youkePassword);
		}
		if (StringUtil.isNotEmpty(youkeAge)) {
			youke.setYoukeAge(Integer.parseInt(youkeAge));
		}
		if (StringUtil.isNotEmpty(youkeXingming)) {
			youke.setYoukeXingming(youkeXingming);
		}
		if (StringUtil.isNotEmpty(youkeSex)) {
			youke.setYoukeSex(Integer.parseInt(youkeSex));
		}
		if (StringUtil.isNotEmpty(youkePhone)) {
			youke.setYoukePhone(youkePhone);
		}
		if (StringUtil.isNotEmpty(youkeMark1)) {
			youke.setYoukeMark1(youkeMark1);
		}
		if (StringUtil.isNotEmpty(youkeMark2)) {
			youke.setYoukeMark2(youkeMark2);
		}
		if (StringUtil.isNotEmpty(youkeMark3)) {
			youke.setYoukeMark3(youkeMark3);
		}
		if (StringUtil.isNotEmpty(youkeMark4)) {
			youke.setYoukeMark4(youkeMark4);
		}
		if (StringUtil.isNotEmpty(youkeDate1)) {
			youke.setYoukeDate1(DateUtil.formatString(youkeDate1,
					"yyyy-MM-dd hh:mm:ss"));
		}
		if (StringUtil.isNotEmpty(youkeDate2)) {
			youke.setYoukeDate2(DateUtil.formatString(youkeDate2,
					"yyyy-MM-dd hh:mm:ss"));
		}
		if (StringUtil.isNotEmpty(youkeType1)) {
			youke.setYoukeType1(Integer.parseInt(youkeType1));
		}
		if (StringUtil.isNotEmpty(youkeType2)) {
			youke.setYoukeType2(Integer.parseInt(youkeType2));
		}
		if (StringUtil.isNotEmpty(yhroleId)) {
			youke.setYhroleId(Integer.parseInt(yhroleId));
			Yhrole yhrole = new Yhrole();
			yhrole = yhroleService.getYhrole(Integer.parseInt(yhroleId));
			youke.setYhroleName(yhrole.getYhroleName());
		}
		if (StringUtil.isNotEmpty(yhbumenId)) {
			youke.setYhbumenId(Integer.parseInt(yhbumenId));
			Yhbumen yhbumen = new Yhbumen();
			yhbumen = yhbumenService.getYhbumen(Integer.parseInt(yhbumenId));
			youke.setYhbumenName(yhbumen.getYhbumenName());
		}
		try {
			if (StringUtil.isNotEmpty(youkeId)) {
				youkeService.modifyYouke(youke);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			} else {
				int total = youkeService.queryYoukes(null, youkeName, 0, 0, null, null).size();
				if (total==0) {
					Date date = new Date();
					youke.setYoukeDate1(date);
					youkeService.save(youke);
					result.put("success", "true");
					ResponseUtil.write(response, result);
				} else {
					result.put("success", "true");
					result.put("errorMsg", "用户名重复！");
					ResponseUtil.write(response, result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/mimaYouke")
	public void mimaYouke(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String youkeId = (String) request.getParameter("youkeId");
		String youkePassword = (String) request.getParameter("youkePassword");
		String youkePassword1 = (String) request.getParameter("youkePassword1");
		Youke youke = new Youke();
		try {
			youke = youkeService.getYouke(Integer.parseInt(youkeId));
			if (!youke.getYoukePassword().equals(youkePassword)) {
				request.setAttribute("error", "原密码错误，请重新输入！");
				request.getRequestDispatcher("youkemima.jsp").forward(request,
						response);
			}else{
				youke.setYoukePassword(youkePassword1);
				youkeService.modifyYouke(youke);
				request.setAttribute("error", "密码修改成功！");
				request.getRequestDispatcher("youkemima.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/zhuceYouke")
	public void zhuceYouke(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JSONObject result = new JSONObject();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String youkeName = (String) request.getParameter("youkeName");
		String youkePassword = (String) request.getParameter("youkePassword");
		String youkeAge = (String) request.getParameter("youkeAge");
		String youkeXingming = (String) request.getParameter("youkeXingming");
		String youkeSex = (String) request.getParameter("youkeSex");
		String youkePhone = (String) request.getParameter("youkePhone");
		String youkeMark1 = (String) request.getParameter("youkeMark1");
		String youkeMark2 = (String) request.getParameter("youkeMark2");
		String youkeMark3 = (String) request.getParameter("youkeMark3");
		String youkeMark4 = (String) request.getParameter("youkeMark4");
		String youkeDate1 = (String) request.getParameter("youkeDate1");
		String youkeDate2 = (String) request.getParameter("youkeDate2");
		String youkeType1 = (String) request.getParameter("youkeType1");
		String youkeType2 = (String) request.getParameter("youkeType2");
		String yhroleId = (String) request.getParameter("yhroleId");
		String yhbumenId = (String) request.getParameter("yhbumenId");
		String youkeId = (String) request.getParameter("youkeId");
		Youke youke = new Youke();

		if (StringUtil.isNotEmpty(youkeId)) {
			youke = youkeService.getYouke(Integer.parseInt(youkeId));
		}
		if (StringUtil.isNotEmpty(youkeName)) {
			youke.setYoukeName(youkeName);
		}
		if (StringUtil.isNotEmpty(youkePassword)) {
			youke.setYoukePassword(youkePassword);
		}
		if (StringUtil.isNotEmpty(youkeAge)) {
			youke.setYoukeAge(Integer.parseInt(youkeAge));
		}
		if (StringUtil.isNotEmpty(youkeXingming)) {
			youke.setYoukeXingming(youkeXingming);
		}
		if (StringUtil.isNotEmpty(youkeSex)) {
			youke.setYoukeSex(Integer.parseInt(youkeSex));
		}
		if (StringUtil.isNotEmpty(youkePhone)) {
			youke.setYoukePhone(youkePhone);
		}
		if (StringUtil.isNotEmpty(youkeMark1)) {
			youke.setYoukeMark1(youkeMark1);
		}
		if (StringUtil.isNotEmpty(youkeMark2)) {
			youke.setYoukeMark2(youkeMark2);
		}
		if (StringUtil.isNotEmpty(youkeMark3)) {
			youke.setYoukeMark3(youkeMark3);
		}
		if (StringUtil.isNotEmpty(youkeMark4)) {
			youke.setYoukeMark4(youkeMark4);
		}
		if (StringUtil.isNotEmpty(youkeDate1)) {
			youke.setYoukeDate1(DateUtil.formatString(youkeDate1,
					"yyyy-MM-dd hh:mm:ss"));
		}
		if (StringUtil.isNotEmpty(youkeDate2)) {
			youke.setYoukeDate2(DateUtil.formatString(youkeDate2,
					"yyyy-MM-dd hh:mm:ss"));
		}
		if (StringUtil.isNotEmpty(youkeType1)) {
			youke.setYoukeType1(Integer.parseInt(youkeType1));
		}
		if (StringUtil.isNotEmpty(youkeType2)) {
			youke.setYoukeType2(Integer.parseInt(youkeType2));
		}
		if (StringUtil.isNotEmpty(yhroleId)) {
			youke.setYhroleId(Integer.parseInt(yhroleId));
			Yhrole yhrole = new Yhrole();
			yhrole = yhroleService.getYhrole(Integer.parseInt(yhroleId));
			youke.setYhroleName(yhrole.getYhroleName());
		}
		if (StringUtil.isNotEmpty(yhbumenId)) {
			youke.setYhbumenId(Integer.parseInt(yhbumenId));
			Yhbumen yhbumen = new Yhbumen();
			yhbumen = yhbumenService.getYhbumen(Integer.parseInt(yhbumenId));
			youke.setYhbumenName(yhbumen.getYhbumenName());
		}
		try {
			if (StringUtil.isNotEmpty(youkeId)) {
				youkeService.modifyYouke(youke);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			} else {
				int total = youkeService.queryYoukes(null, youkeName, 0, 0, null, null).size();
				if (total==0) {
					youkeService.save(youke);
					request.setAttribute("error", "注册成功，请登录！");
					request.getRequestDispatcher("index.jsp").forward(request,
							response);
				} else {
					request.setAttribute("error", "用户名重复，请重新输入！");
					request.getRequestDispatcher("zhuceyouke.jsp").forward(request,
							response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/deleteYouke")
	public void deleteYouke(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JSONObject result = new JSONObject();
		String delIds = (String) request.getParameter("delIds");
		try {
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				youkeService.deleteYouke(Integer.parseInt(str[i]));
			}
			result.put("success", "true");
			result.put("delNums", str.length);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/youkeComboList")
	public void youkeComboList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String youkeSex = (String) request.getParameter("youkeSex");
		String youkeType1 = (String) request.getParameter("youkeType1");
		String youkeType2 = (String) request.getParameter("youkeType2");
		String yhroleId = (String) request.getParameter("yhroleId");
		String yhbumenId = (String) request.getParameter("yhbumenId");
		Youke youke = new Youke();

		if (StringUtil.isNotEmpty(youkeSex)) {
			youke.setYoukeSex(Integer.parseInt(youkeSex));
		}
		if (StringUtil.isNotEmpty(youkeType1)) {
			youke.setYoukeType1(Integer.parseInt(youkeType1));
		}
		if (StringUtil.isNotEmpty(youkeType2)) {
			youke.setYoukeType2(Integer.parseInt(youkeType2));
		}
		if (StringUtil.isNotEmpty(yhroleId)) {
			youke.setYhroleId(Integer.parseInt(yhroleId));
		}
		if (StringUtil.isNotEmpty(yhbumenId)) {
			youke.setYhbumenId(Integer.parseInt(yhbumenId));
		}
		try {
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("youkeName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(youkeService.queryYoukes(youke, null, 0, 0, null, null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/youkeTongji")
	public void youkeTongji(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		String yhroleId=request.getParameter("yhroleId");
		List<Integer> yhbumenIds = new ArrayList<Integer>();
		List<String> yhbumenNames = new ArrayList<String>();
		List<Integer> youkeZongshus = new ArrayList<Integer>();
		List<Yhbumen> yhbumens = new ArrayList<Yhbumen>();
		List<Youke> youkes = new ArrayList<Youke>();
		Youke youke = new Youke();
		if (StringUtil.isNotEmpty(yhroleId)) {
			youke.setYhroleId(Integer.parseInt(yhroleId));
		}
		Integer zongshu = 0;
		try {
			yhbumens = yhbumenService.queryYhbumens(null, 0,0);
			for(int i=0;i<yhbumens.size();i++){
				yhbumenIds.add(yhbumens.get(i).getYhbumenId());
				yhbumenNames.add(yhbumens.get(i).getYhbumenName());
			}
			for(int i=0;i<yhbumenIds.size();i++){
				Integer youkeZongshu = 0;
				youke.setYhbumenId(yhbumenIds.get(i));
				youkes = youkeService.queryYoukes(youke, null, 0, 0, sdate, edate);
				for(int j=0;j<youkes.size();j++){
					youkeZongshu = youkeZongshu + youkes.size();
				}
				zongshu = zongshu + youkeZongshu;
				youkeZongshus.add(youkeZongshu);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("yhbumenNames", yhbumenNames);
			session.setAttribute("youkeZongshus", youkeZongshus);
			session.setAttribute("zongshu", zongshu);
			response.sendRedirect("admin/youketongji.jsp");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/shangchuanYouke")
	public void shangchuanYouke(HttpServletRequest request, HttpServletResponse response,MultipartFile uploadFile)
			throws Exception {
		try {
			String youkeId = (String) request.getParameter("youkeId");
			String directory = "/file";
			String targetDirectory = request.getSession().getServletContext().getRealPath(directory);
	        String fileName = uploadFile.getOriginalFilename();  
			File dir = new File(targetDirectory,fileName);        
	        if(!dir.exists()){
	            dir.mkdirs();
	        }
	        //MultipartFile自带的解析方法
	        uploadFile.transferTo(dir);

			String shangchuandizhi = "/file" + "/" + fileName;
			String shangchuanname = fileName;
			Youke youke = youkeService.getYouke(Integer.parseInt(youkeId));
			youke.setYoukeImg(shangchuandizhi);
			youke.setYoukeImgName(shangchuanname);
			youkeService.modifyYouke(youke);
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/daoruYouke")
	public void daoruYouke(HttpServletRequest request, HttpServletResponse response,MultipartFile uploadFile)
			throws Exception {
		try {
			String directory = "/file";
			String targetDirectory = request.getSession().getServletContext().getRealPath(directory);
	        String fileName = uploadFile.getOriginalFilename();  
			File dir = new File(targetDirectory,fileName);        
	        if(!dir.exists()){
	            dir.mkdirs();
	        }
	        //MultipartFile自带的解析方法
	        uploadFile.transferTo(dir);
			excelFile = new FileInputStream(dir);
			Workbook wb = new HSSFWorkbook(excelFile);
			Sheet sheet = wb.getSheetAt(0);
			int rowNum = sheet.getLastRowNum() + 1;
			for (int i = 1; i < rowNum; i++) {
				Youke youke = new Youke();
				Row row = sheet.getRow(i);
				int cellNum = row.getLastCellNum();
				for (int j = 0; j < cellNum; j++) {
					Cell cell = row.getCell(j);
					String cellValue = null;
					switch (cell.getCellType()) { // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
					case 0:
						cellValue = String.valueOf((int) cell
								.getNumericCellValue());
						break;
					case 1:
						cellValue = cell.getStringCellValue();
						break;
					case 2:
						cellValue = cell.getStringCellValue();
						break;
					case 3:
						cellValue = cell.getStringCellValue();
						break;
					case 4:
						cellValue = cell.getStringCellValue();
						break;
					case 5:
						cellValue = cell.getStringCellValue();
						break;
					case 6:
						cellValue = cell.getStringCellValue();
						break;
					case 7:
						cellValue = cell.getStringCellValue();
						break;
					case 8:
						cellValue = cell.getStringCellValue();
						break;
					case 9:
						cellValue = cell.getStringCellValue();
						break;
					case 10:
						cellValue = cell.getStringCellValue();
						break;
					case 11:
						cellValue = cell.getStringCellValue();
						break;
					case 12:
						cellValue = cell.getStringCellValue();
						break;
					case 13:
						cellValue = cell.getStringCellValue();
						break;
					case 14:
						cellValue = cell.getStringCellValue();
						break;
					}

					switch (j) {// 通过列数来判断对应插如的字段
					case 1:
						youke.setYoukeName(cellValue);
						break;
					case 2:
						youke.setYoukePassword(cellValue);
						break;
					case 3:
						youke.setYoukeXingming(cellValue);
						break;
					case 4:
						youke.setYoukeAge(Integer.parseInt(cellValue));
						break;
					case 5:
						youke.setYoukeSex(Integer.parseInt(cellValue));
						break;
					case 6:
						youke.setYoukePhone(cellValue);
						break;
					case 7:
						youke.setYoukeMark1(cellValue);
						break;
					case 8:
						youke.setYoukeMark2(cellValue);
						break;
					case 9:
						youke.setYoukeMark3(cellValue);
						break;
					case 10:
						youke.setYoukeMark4(cellValue);
						break;
					case 11:
						youke.setYoukeType1(Integer.parseInt(cellValue));
						break;
					case 12:
						youke.setYoukeType2(Integer.parseInt(cellValue));
						break;
					}
				}
				youkeService.save(youke);
			}
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/daochuYouke")
	public void daochuYouke(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String delIds = (String) request.getParameter("delIds");
		JSONObject result = new JSONObject();
		String str[] = delIds.split(",");

		// 创建一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表
		HSSFSheet sheet = workbook.createSheet("youkes记录");
		// 添加表头行
		HSSFRow hssfRow = sheet.createRow(0);
		// 设置单元格格式居中
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 添加表头内容
		HSSFCell headCell = hssfRow.createCell(0);
		headCell.setCellValue("编号");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(1);
		headCell.setCellValue("用户名");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(2);
		headCell.setCellValue("密码");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(3);
		headCell.setCellValue("姓名");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(4);
		headCell.setCellValue("性别");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(5);
		headCell.setCellValue("年龄");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(6);
		headCell.setCellValue("电话");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(7);
		headCell.setCellValue("备注1");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(8);
		headCell.setCellValue("备注2");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(9);
		headCell.setCellValue("备注3");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(10);
		headCell.setCellValue("备注4");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(13);
		headCell.setCellValue("标志1");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(14);
		headCell.setCellValue("备注2");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(15);
		headCell.setCellValue("权限");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(16);
		headCell.setCellValue("部门");
		headCell.setCellStyle(cellStyle);

		// 添加数据内容
		for (int i = 0; i < str.length; i++) {
			hssfRow = sheet.createRow((int) i + 1);
			Youke youke = youkeService.getYouke(Integer.parseInt(str[i]));

			// 创建单元格，并设置值
			HSSFCell cell = hssfRow.createCell(0);
			cell.setCellValue(youke.getYoukeId());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(1);
			cell.setCellValue(youke.getYoukeName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(2);
			cell.setCellValue(youke.getYoukePassword());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(3);
			cell.setCellValue(youke.getYoukeXingming());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(4);
			if (youke.getYoukeSex().intValue() == 0) {
				cell.setCellValue("男");
				cell.setCellStyle(cellStyle);
			} else {
				cell.setCellValue("女");
				cell.setCellStyle(cellStyle);
			}

			cell = hssfRow.createCell(5);
			cell.setCellValue(youke.getYoukeAge());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(6);
			cell.setCellValue(youke.getYoukePhone());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(7);
			cell.setCellValue(youke.getYoukeMark1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(8);
			cell.setCellValue(youke.getYoukeMark2());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(9);
			cell.setCellValue(youke.getYoukeMark3());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(10);
			cell.setCellValue(youke.getYoukeMark4());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(13);
			cell.setCellValue(youke.getYoukeType1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(14);
			cell.setCellValue(youke.getYoukeType2());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(15);
			cell.setCellValue(youke.getYhroleName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(16);
			cell.setCellValue(youke.getYhbumenName());
			cell.setCellStyle(cellStyle);
		}

		// 保存Excel文件
		try {
			Date date = new Date();
			String strdate = DateUtil.formatDate(date, "yyyyMMddhhmmss");
			OutputStream outputStream = new FileOutputStream("D:/youke"
					+ strdate + ".xls");
			workbook.write(outputStream);
			outputStream.close();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
