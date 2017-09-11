package com.lzf.mvcModule.controller;



import com.lzf.mvcModule.utils.FileUploadResponseUtil;
import com.lzf.mvcModule.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

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



    /**
     *  文件上传
     */
    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    @ResponseBody
    public  String uploadImg(HttpServletRequest request) {
        FileUploadResponseUtil responseUtil = new FileUploadResponseUtil();
        responseUtil.setAppend(true);
        List<String> initialPreview = new ArrayList<>();
        List<Map<String,String>> initialPreviewConfig = new ArrayList<>();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            String fileName = file.getOriginalFilename(); //源文件名称
            String filePath = FILEUPLOADPATH; //文件上传位置
            try {
                String targetFileName = FileUtil.uploadFile(file.getBytes(), filePath, fileName);
                makePreview(initialPreview,fileName,targetFileName);
                makePreviewConfig(initialPreviewConfig,fileName,targetFileName);
            } catch (Exception e) {
                responseUtil.setError("上传失败，请重新上传！");
            }
        }
        responseUtil.setInitialPreview(initialPreview);
        responseUtil.setInitialPreviewConfig(initialPreviewConfig);
       /* JSONObject json = (JSONObject) JSON.toJSON(responseUtil);
        System.out.println(json.toJSONString());*/
        return "";
    }
//    width='284' height='160'
    private void makePreview(List<String> initialPreview, String fileName, String targetFileName) {
        StringBuffer str = new StringBuffer("<div class='file-preview-text'><h1><i class='glyphicon glyphicon-picture'></i></h1></div>");
       // StringBuffer str = new StringBuffer("<div src='/img/222.txt' class='file-preview-other file-other-icon glyphicon glyphicon-file'>");
        initialPreview.add(str.toString());

    }

    private void makePreviewConfig(List<Map<String, String>> initialPreviewConfig, String fileName, String targetFileName) {
        targetFileName = targetFileName.replace('.','/');
        Map<String, String> map = new HashMap<>();
        map.put("caption",fileName);
        map.put("width","120px");
        map.put("url","/upload/deletefile/"+targetFileName);
        map.put("frameClass","my-custom-frame-css");
        map.put("key",targetFileName);
        initialPreviewConfig.add(map);
    }


    /**
     *  删除文件
     */
    @RequestMapping(value = "/deletefile/{fileName}/{suffix}" )
    @ResponseBody
    public  String deletefile(HttpServletRequest request ,
                              @PathVariable("fileName") String fileName,
                              @PathVariable("suffix") String suffix) {
        fileName = FILEUPLOADPATH + fileName+"."+suffix;
        boolean falg = FileUtil.deleteFile(fileName);
        System.out.println(fileName);
        return "{}";
    }

    /**
     *  文件下载
     */
    @RequestMapping(value = "/downloadfile/{fileName}/{suffix}" )
    public  void downloadFile(HttpServletResponse res,
                              @PathVariable("fileName") String fileName,
                              @PathVariable("suffix") String suffix) {
        fileName = FILEUPLOADPATH + fileName+"."+suffix;
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
    }

}
