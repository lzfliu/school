package com.lzf.mvcModule.utils;



import java.util.List;
import java.util.Map;



public class FileUploadResponseUtil {

    private String error;

    private List<String> initialPreview;

    private List<Map<String,String>> initialPreviewConfig;

    private List<Map<String,String>> initialPreviewThumbTags;

    private Boolean append;


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<String> getInitialPreview() {
        return initialPreview;
    }

    public void setInitialPreview(List<String> initialPreview) {
        this.initialPreview = initialPreview;
    }

    public List<Map<String, String>> getInitialPreviewConfig() {
        return initialPreviewConfig;
    }

    public void setInitialPreviewConfig(List<Map<String, String>> initialPreviewConfig) {
        this.initialPreviewConfig = initialPreviewConfig;
    }

    public List<Map<String, String>> getInitialPreviewThumbTags() {
        return initialPreviewThumbTags;
    }

    public void setInitialPreviewThumbTags(List<Map<String, String>> initialPreviewThumbTags) {
        this.initialPreviewThumbTags = initialPreviewThumbTags;
    }

    public Boolean getAppend() {
        return append;
    }

    public void setAppend(Boolean append) {
        this.append = append;
    }
}
