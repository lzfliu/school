package com.lzf.school.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzf.school.utils.FileUploadResponseUtil;
import com.lzf.school.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class BootStarpFileUpload {

    @Value("${fileupload.path}")
    private String FILEUPLOADPATH;


    @RequestMapping("/index")
    public String bootstrapfileuplaod(){
        return "freemarker/plugins/fileupload/bootstrapfileuplaod";
    }

    @RequestMapping("/index1")
    public String bootstrapfileuplaod_1(){
        return "freemarker/plugins/fileupload/bootstrapfileuplaod_1";
    }



    //处理文件上传
    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    @ResponseBody
    public  String uploadImg(HttpServletRequest request) {
        FileUploadResponseUtil responseUtil = new FileUploadResponseUtil();
        responseUtil.setAppend(true);
        List<Map<String,String>> initialPreview = new ArrayList<>();
        List<Map<String,String>> initialPreviewConfig = new ArrayList<>();
        List<Map<String,String>> initialPreviewThumbTags = new ArrayList<>();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            String fileName = file.getOriginalFilename(); //源文件名称
            String filePath = FILEUPLOADPATH; //文件上传位置
            try {
                FileUtil.uploadFile(file.getBytes(), filePath, fileName);

            } catch (Exception e) {
                // TODO: handle exception
                responseUtil.setError("上传失败，请重新上传！");
            }
        } //返回json



        responseUtil.setInitialPreview(null);
        responseUtil.setInitialPreviewConfig(null);
        responseUtil.setInitialPreviewThumbTags(null);
        JSONObject json = (JSONObject) JSON.toJSON(responseUtil);
        System.out.println(json.toJSONString());
        return "{}";
    }



    //处理文件上传
    @RequestMapping(value = "/deletefile" , method = RequestMethod.POST)
    @ResponseBody
    public  String deletefile(HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        return "success";
    }
}
