package com.authority.manager.web.controller;

import com.authority.manager.component.error.BusinessException;
import com.yls.common.utils.StringFormatUtils;
import com.yls.core.http.HttpResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @Author yls
 * @Date 2020/4/12 9:32
 * @Description
 * @Version 1.0
 **/
@RestController
@Api(tags = "文件上传接口")
@RequestMapping("/test")
public class FileUpload {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    @ApiOperation(value = "单个文件上传")
    @ApiImplicitParam(name = "uploadFile",value = "上常的单个文件",required = true)
    @PostMapping("/uploadOneFile")
    public HttpResultVO uploadOneFile(MultipartFile uploadFile, HttpServletRequest request) {
        try{
            List<MultipartFile> multipartFiles = new ArrayList<>();
            multipartFiles.add(uploadFile);
            return uploadFiles(multipartFiles,request);
        }catch (Exception e){
            throw new BusinessException("文件失败");
        }
    }

    @ApiOperation(value = "多个文件上传")
    @ApiImplicitParam(name = "uploadFiles",value = "上传的文件数组",required = true)
    @PostMapping("/uploadFiles")
    public HttpResultVO uploadSomeFiles(MultipartFile[] uploadFiles, HttpServletRequest request){
        return uploadFiles(Arrays.asList(uploadFiles), request);
    }

    /**
     * 上传文件的具体实现方法
     * @param uploadFiles 文件集合
     * @param request request请求
     * @return
     */
    private HttpResultVO uploadFiles(List<MultipartFile> uploadFiles, HttpServletRequest request) {
        //String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        String realPath = "E:\\uploaFileTemp\\uploadFile\\";
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()){
            folder.mkdirs();
        }

        List<String> result = new ArrayList<>();
        try {
            for (MultipartFile uploadFile:uploadFiles) {
                String oldFileName = uploadFile.getOriginalFilename();
                String newFileName = StringFormatUtils.getUUID()
                        + oldFileName.substring(oldFileName.lastIndexOf("."), oldFileName.length());
                uploadFile.transferTo(new File(folder,newFileName));
                String filePath = request.getScheme() + "://" + request.getServerName()
                        + ":" + request.getServerPort()
                        + "/uploadFile/" + format + newFileName;
                result.add(filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResultVO.error("上传文件失败");
        }
        return HttpResultVO.ok(result);
    }

}
