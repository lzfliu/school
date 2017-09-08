package com.lzf.school.utils;



import lombok.*;

import java.util.List;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadResponseUtil {

    private String error;

    private List<String> initialPreview;

    private List<Map<String,String>> initialPreviewConfig;

    private List<Map<String,String>> initialPreviewThumbTags;

    private Boolean append;



}
