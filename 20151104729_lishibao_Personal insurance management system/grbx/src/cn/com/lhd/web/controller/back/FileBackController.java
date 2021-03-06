package cn.com.lhd.web.controller.back;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.lhd.core.JsonViewData;
import cn.com.lhd.core.ResultCode;
import cn.com.lhd.web.controller.CommonController;
import cn.com.lhd.web.utils.BlankUtil;
import cn.com.lhd.web.utils.DateUtil;

/**
*
* @desc
* 
* @author luohaidian
* @date 2018年12月21日
* @time 下午5:39:09
*/
@Controller
@RequestMapping(value = "/manage/file")
public class FileBackController extends CommonController {
	
	/**
	 * 上传封面/头像图片
	 * 
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/upload")
	public JsonViewData uploadImg(@RequestParam("file") MultipartFile file){
		try {
			if (BlankUtil.isBlank(file)) {
				return setJsonViewData(ResultCode.NO_EXISTS);
			}
			String originalFileName = file.getOriginalFilename();
			String ext = originalFileName.substring(originalFileName.indexOf("."), originalFileName.length());
			String newFileName = BlankUtil.randomUUID() + ext;
	        // 获取文件上传的真实路径
	        String rootPath = httpRequest.getSession().getServletContext().getRealPath("");
	        String path = "/upload/" + DateUtil.formatCurrentDate("yyyyMMdd");
	        File destFile = new File(rootPath + path);
	        if (!destFile.exists()) {
				destFile.mkdirs();
			}
			file.transferTo(new File(destFile + "/" + newFileName));
			return setJsonViewData(path + "/" + newFileName);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return setJsonViewData(ResultCode.NO_EXISTS);
	}

}
