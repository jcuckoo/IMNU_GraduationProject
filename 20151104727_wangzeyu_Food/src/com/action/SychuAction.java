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

import com.util.MatrixToImageWriter;
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
public class SychuAction {
	@Autowired
	private SychuService sychuService;
	@Autowired
	private SptypeService sptypeService;
	@Autowired
	private ShangpinService shangpinService;
	@Autowired
	private YonghuService yonghuService;
	@Autowired
	private UserService userService;
	@Autowired
	private YoukeService youkeService;
	@Autowired
	private SpchuService spchuService;

	/***上传导入开始***/
	private InputStream excelFile;

	public InputStream getExcelFile() {
		return excelFile;
	}
	/***上传导入结束***/

	@RequestMapping("/getSychus")
	public void getSychus(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String page = (String) request.getParameter("page");
		String rows = (String) request.getParameter("rows");
		String sychuName = (String) request.getParameter("sychuName");
		String sychuId = (String) request.getParameter("sychuId");
		String sptypeId = (String) request.getParameter("sptypeId");
		String sychuType = (String) request.getParameter("sychuType");
		String sychuType1 = (String) request.getParameter("sychuType1");
		String userId = (String) request.getParameter("userId");
		String bumenId = (String) request.getParameter("bumenId");
		String roleId = (String) request.getParameter("roleId");
		String yhroleId = (String) request.getParameter("yhroleId");
		String yonghuId = (String) request.getParameter("yonghuId");
		String yhbumenId = (String) request.getParameter("yhbumenId");
		String shangpinId = (String) request.getParameter("shangpinId");
		String youkeId = (String) request.getParameter("youkeId");
		String sdate = (String) request.getParameter("sdate");
		String edate = (String) request.getParameter("edate");
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Sychu sychu = new Sychu();
		try {
			if (StringUtil.isNotEmpty(sychuName)) {
				sychu.setSychuName(sychuName);
			}
			if (StringUtil.isNotEmpty(sychuId)) {
				sychu.setSychuId(Integer.parseInt(sychuId));
			}
			if (StringUtil.isNotEmpty(sptypeId)) {
				sychu.setSptypeId(Integer.parseInt(sptypeId));
			}
			if (StringUtil.isNotEmpty(sychuType)) {
				sychu.setSychuType(Integer.parseInt(sychuType));
			}
			if (StringUtil.isNotEmpty(sychuType1)) {
				sychu.setSychuType1(Integer.parseInt(sychuType1));
			}
			if (StringUtil.isNotEmpty(userId)) {
				sychu.setUserId(Integer.parseInt(userId));
			}
			if (StringUtil.isNotEmpty(bumenId)) {
				sychu.setBumenId(Integer.parseInt(bumenId));
			}
			if (StringUtil.isNotEmpty(roleId)) {
				sychu.setRoleId(Integer.parseInt(roleId));
			}
			if (StringUtil.isNotEmpty(shangpinId)) {
				sychu.setShangpinId(Integer.parseInt(shangpinId));
			}
			if (StringUtil.isNotEmpty(yhroleId)) {
				sychu.setYhroleId(Integer.parseInt(yhroleId));
			}
			if (StringUtil.isNotEmpty(yhbumenId)) {
				sychu.setYhbumenId(Integer.parseInt(yhbumenId));
			}
			if (StringUtil.isNotEmpty(yonghuId)) {
				sychu.setYonghuId(Integer.parseInt(yonghuId));
			}
			if (StringUtil.isNotEmpty(youkeId)) {
				sychu.setYoukeId(Integer.parseInt(youkeId));
			}
			JSONArray jsonArray = JSONArray.fromObject(sychuService.querySychus(
					sychu, pageBean.getStart(), pageBean.getRows(), sdate, edate));
			JSONObject result = new JSONObject();
			int total = sychuService.querySychus(sychu, 0, 0, sdate, edate).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/addSychu")
	public void addSychu(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//购买二维码储存地址
		String dizhi = "D:\\tomcat\\webapps\\cgshipinzhuisum\\file";
		JSONObject result = new JSONObject();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String sychuName = (String) request.getParameter("sychuName");
		String sychuMark = (String) request.getParameter("sychuMark");
		String sychuMark1 = (String) request.getParameter("sychuMark1");
		String sychuMark2 = (String) request.getParameter("sychuMark2");
		String sychuMark3 = (String) request.getParameter("sychuMark3");
		String sychuZong = (String) request.getParameter("sychuZong");
		String sychuDate = (String) request.getParameter("sychuDate");
		String sychuDate1 = (String) request.getParameter("sychuDate1");
		String sychuType = (String) request.getParameter("sychuType");
		String sychuType1 = (String) request.getParameter("sychuType1");
		String sptypeId = (String) request.getParameter("sptypeId");
		String userId = (String) request.getParameter("userId");
		String sychuJine = (String) request.getParameter("sychuJine");
		String shangpinId = (String) request.getParameter("shangpinId");
		String yonghuId = (String) request.getParameter("yonghuId");
		String youkeId = (String) request.getParameter("youkeId");
		String spchuId = (String) request.getParameter("spchuId");
		String sychuId = (String) request.getParameter("sychuId");
		Sychu sychu = new Sychu();

		if (StringUtil.isNotEmpty(sychuId)) {
			sychu = sychuService.getSychu(Integer.parseInt(sychuId));
		}
		if (StringUtil.isNotEmpty(sychuName)) {
			sychu.setSychuName(sychuName);
		}
		if (StringUtil.isNotEmpty(sychuMark)) {
			sychu.setSychuMark(sychuMark);
		}
		if (StringUtil.isNotEmpty(sychuMark1)) {
			sychu.setSychuMark1(sychuMark1);
		}
		if (StringUtil.isNotEmpty(sychuMark2)) {
			sychu.setSychuMark2(sychuMark2);
		}
		if (StringUtil.isNotEmpty(sychuMark3)) {
			sychu.setSychuMark3(sychuMark3);
		}
		if (StringUtil.isNotEmpty(sychuZong)) {
			sychu.setSychuZong(Integer.parseInt(sychuZong));
		}
		if (StringUtil.isNotEmpty(sychuJine)) {
			sychu.setSychuJine(Double.parseDouble(sychuJine));
		}
		if (StringUtil.isNotEmpty(sychuDate)) {
			sychu.setSychuDate(DateUtil.formatString(sychuDate,
					"yyyy-MM-dd hh:mm:ss"));
		}
		if (StringUtil.isNotEmpty(sychuDate1)) {
			sychu.setSychuDate1(DateUtil.formatString(sychuDate1,
					"yyyy-MM-dd hh:mm:ss"));
		}
		if (StringUtil.isNotEmpty(sychuType)) {
			sychu.setSychuType(Integer.parseInt(sychuType));
		}
		if (StringUtil.isNotEmpty(sychuType1)) {
			sychu.setSychuType1(Integer.parseInt(sychuType1));
		}
		if (StringUtil.isNotEmpty(sptypeId)) {
			sychu.setSptypeId(Integer.parseInt(sptypeId));
			Sptype sptype = new Sptype();
			sptype = sptypeService.getSptype(Integer.parseInt(sptypeId));
			sychu.setSptypeName(sptype.getSptypeName());
		}
		if (StringUtil.isNotEmpty(shangpinId)) {
			sychu.setShangpinId(Integer.parseInt(shangpinId));
			Shangpin shangpin = new Shangpin();
			shangpin = shangpinService.getShangpin(Integer.parseInt(shangpinId));
			sychu.setShangpinName(shangpin.getShangpinName());
			sychu.setSptypeId(shangpin.getSptypeId());
			sychu.setSptypeName(shangpin.getSptypeName());
			sychu.setUserId(shangpin.getUserId());
			sychu.setUserName(shangpin.getUserName());
			sychu.setBumenId(shangpin.getBumenId());
			sychu.setBumenName(shangpin.getBumenName());
			sychu.setRoleId(shangpin.getRoleId());
			sychu.setRoleName(shangpin.getRoleName());
		}
		if (StringUtil.isNotEmpty(userId)) {
			sychu.setUserId(Integer.parseInt(userId));
			User user = new User();
			user = userService.getUser(Integer.parseInt(userId));
			sychu.setUserName(user.getUserName());
			sychu.setBumenId(user.getBumenId());
			sychu.setBumenName(user.getBumenName());
			sychu.setRoleId(user.getRoleId());
			sychu.setRoleName(user.getRoleName());
		}
		if (StringUtil.isNotEmpty(yonghuId)) {
			sychu.setYonghuId(Integer.parseInt(yonghuId));
			Yonghu yonghu = new Yonghu();
			yonghu = yonghuService.getYonghu(Integer.parseInt(yonghuId));
			sychu.setYonghuName(yonghu.getYonghuName());
			sychu.setYhbumenId(yonghu.getYhbumenId());
			sychu.setYhbumenName(yonghu.getYhbumenName());
			sychu.setYhroleId(yonghu.getYhroleId());
			sychu.setYhroleName(yonghu.getYhroleName());
		}
		if (StringUtil.isNotEmpty(youkeId)) {
			sychu.setYoukeId(Integer.parseInt(youkeId));
			Youke youke = new Youke();
			youke = youkeService.getYouke(Integer.parseInt(youkeId));
			sychu.setYoukeName(youke.getYoukeName());
		}
		if (StringUtil.isNotEmpty(spchuId)) {
			Spchu spchu = new Spchu();
			spchu = spchuService.getSpchu(Integer.parseInt(spchuId));
			sychu.setShangpinId(spchu.getShangpinId());
			sychu.setShangpinName(spchu.getShangpinName());
			sychu.setSptypeId(spchu.getSptypeId());
			sychu.setSptypeName(spchu.getSptypeName());
			sychu.setUserId(spchu.getUserId());
			sychu.setUserName(spchu.getUserName());
			sychu.setBumenId(spchu.getBumenId());
			sychu.setBumenName(spchu.getBumenName());
			sychu.setRoleId(spchu.getRoleId());
			sychu.setRoleName(spchu.getRoleName());
			sychu.setYonghuId(spchu.getYonghuId());
			sychu.setYonghuName(spchu.getYonghuName());
			sychu.setYhbumenId(spchu.getYhbumenId());
			sychu.setYhbumenName(spchu.getYhbumenName());
			sychu.setYhroleId(spchu.getYhroleId());
			sychu.setYhroleName(spchu.getYhroleName());
			sychu.setSychuImg(spchu.getSpchuImg());
			sychu.setSychuImgName(spchu.getSpchuImgName());
			sychu.setSychuErweima(spchu.getSpchuErweima());
			sychu.setSychuErweimaName(spchu.getSpchuErweimaName());
			sychu.setSychuJine(spchu.getSpchuZe());
			sychu.setSychuDate1(spchu.getSpchuDate1());
		}
		try {
			if (StringUtil.isNotEmpty(sychuId)) {
				sychuService.modifySychu(sychu);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			} else {
				Date date = new Date();
				sychu.setSychuDate(date);
				sychu.setSychuType(0);
				sychu.setSychuZe(sychu.getSychuJine()*sychu.getSychuZong());
				Spchu spchu = new Spchu();
				spchu = spchuService.getSpchu(Integer.parseInt(spchuId));
				if(sychu.getSychuZong()>spchu.getSpchuZong()){
					result.put("success", "true");
					result.put("errorMsg", "商品库存不够！");
					ResponseUtil.write(response, result);
				}else{
					String datenow = DateUtil.formatDate(date, "yyyy-MM-dd-HH-mm-ss");
					String sychuErweimaName = datenow + ".jpg";
					String sychuErweima = "/file/" + sychuErweimaName;
					sychu.setSychuErweima(sychuErweima);
					sychu.setSychuErweimaName(sychuErweimaName);
					sychuService.save(sychu);
					String dateString = DateUtil.formatDate(sychu.getSychuDate1(), "yyyy-MM-dd");
					StringBuffer sychuXinxi = new StringBuffer("商品名称："+sychu.getShangpinName() + "；");
					sychuXinxi.append("商品合格：是；");
					sychuXinxi.append("商品类型："+sychu.getSptypeName() + "；");
					sychuXinxi.append("生成企业："+sychu.getUserName() + "；");
					sychuXinxi.append("经营企业："+sychu.getYonghuName() + "；");
					sychuXinxi.append("生成日期："+dateString + "；");
					sychuXinxi.append("购买人："+sychu.getYoukeName() + "；");
					MatrixToImageWriter.shengcheng(sychuErweimaName, sychuXinxi.toString(),dizhi);
					result.put("success", "true");
					ResponseUtil.write(response, result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/deleteSychu")
	public void deleteSychu(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JSONObject result = new JSONObject();
		String delIds = (String) request.getParameter("delIds");
		try {
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				sychuService.deleteSychu(Integer.parseInt(str[i]));
			}
			result.put("success", "true");
			result.put("delNums", str.length);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/sychuComboList")
	public void sychuComboList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String sychuId = (String) request.getParameter("sychuId");
		String sptypeId = (String) request.getParameter("sptypeId");
		String sychuType = (String) request.getParameter("sychuType");
		String sychuType1 = (String) request.getParameter("sychuType1");
		String userId = (String) request.getParameter("userId");
		String bumenId = (String) request.getParameter("bumenId");
		String shangpinId = (String) request.getParameter("shangpinId");
		Sychu sychu = new Sychu();
		if (StringUtil.isNotEmpty(sychuId)) {
			sychu.setSychuId(Integer.parseInt(sychuId));
		}
		if (StringUtil.isNotEmpty(sptypeId)) {
			sychu.setSptypeId(Integer.parseInt(sptypeId));
		}
		if (StringUtil.isNotEmpty(sychuType)) {
			sychu.setSychuType(Integer.parseInt(sychuType));
		}
		if (StringUtil.isNotEmpty(sychuType1)) {
			sychu.setSychuType1(Integer.parseInt(sychuType1));
		}
		if (StringUtil.isNotEmpty(userId)) {
			sychu.setUserId(Integer.parseInt(userId));
		}
		if (StringUtil.isNotEmpty(bumenId)) {
			sychu.setBumenId(Integer.parseInt(bumenId));
		}
		if (StringUtil.isNotEmpty(shangpinId)) {
			sychu.setShangpinId(Integer.parseInt(shangpinId));
		}
		try {
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("sychuName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(sychuService.querySychus(sychu, 0, 0, null, null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/sychuTongji")
	public void sychuTongji(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		List<Integer> sptypeIds = new ArrayList<Integer>();
		List<String> sptypeNames = new ArrayList<String>();
		List<Integer> sychuZongshus = new ArrayList<Integer>();
		List<Sptype> sptypes = new ArrayList<Sptype>();
		List<Sychu> sychus = new ArrayList<Sychu>();
		Sychu sychu = new Sychu();
		Integer zongshu = 0;
		try {
			sptypes = sptypeService.querySptypes(null, 0,0);
			for(int i=0;i<sptypes.size();i++){
				sptypeIds.add(sptypes.get(i).getSptypeId());
				sptypeNames.add(sptypes.get(i).getSptypeName());
			}
			for(int i=0;i<sptypeIds.size();i++){
				Integer sychuZongshu = 0;
				sychu.setSptypeId(sptypeIds.get(i));
				sychus = sychuService.querySychus(sychu, 0, 0, sdate, edate);
				for(int j=0;j<sychus.size();j++){
					sychuZongshu = sychuZongshu + sychus.size();
				}
				zongshu = zongshu + sychuZongshu;
				sychuZongshus.add(sychuZongshu);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("sptypeNames", sptypeNames);
			session.setAttribute("sychuZongshus", sychuZongshus);
			session.setAttribute("zongshu", zongshu);
			response.sendRedirect("admin/sychutongji.jsp");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/shangchuanSychu")
	public void shangchuanSychu(HttpServletRequest request, HttpServletResponse response,MultipartFile uploadFile)
			throws Exception {
		try {
			String sychuId = (String) request.getParameter("sychuId");
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
			Sychu sychu = sychuService.getSychu(Integer.parseInt(sychuId));
			sychu.setSychuImg(shangchuandizhi);
			sychu.setSychuImgName(shangchuanname);
			sychuService.modifySychu(sychu);
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/daoruSychu")
	public void daoruSychu(HttpServletRequest request, HttpServletResponse response,MultipartFile uploadFile)
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
				Sychu sychu = new Sychu();
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
					}

					switch (j) {// 通过列数来判断对应插如的字段
					case 1:
						sychu.setSychuName(cellValue);
						break;
					case 2:
						sychu.setSychuMark(cellValue);
						break;
					}
				}
				sychuService.save(sychu);
			}
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/daochuSychu")
	public void daochuSychu(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String delIds = (String) request.getParameter("delIds");
		JSONObject result = new JSONObject();
		String str[] = delIds.split(",");

		// 创建一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表
		HSSFSheet sheet = workbook.createSheet("sychus记录");
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
			Sychu sychu = sychuService.getSychu(Integer.parseInt(str[i]));

			// 创建单元格，并设置值
			HSSFCell cell = hssfRow.createCell(0);
			cell.setCellValue(sychu.getSychuId());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(1);
			cell.setCellValue(sychu.getSychuName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(7);
			cell.setCellValue(sychu.getSychuMark());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(16);
			cell.setCellValue(sychu.getSptypeName());
			cell.setCellStyle(cellStyle);
		}

		// 保存Excel文件
		try {
			Date date = new Date();
			String strdate = DateUtil.formatDate(date, "yyyyMMddhhmmss");
			OutputStream outputStream = new FileOutputStream("D:/sychu"
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
