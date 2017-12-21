package com.lzf.mvcModule.controller;

import com.alibaba.fastjson.JSON;
import com.lzf.mvcModule.entity.ResponseData;
import com.lzf.mvcModule.utils.HttpUtil;
import com.lzf.mvcModule.utils.PinYinUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/city")
public class CityPickerController {

    @RequestMapping( value = "/cityData", method = RequestMethod.GET )
    @ResponseBody
    @CrossOrigin
    public Map<String,Object> bootstrapTable(Map<String,Object> map) throws IOException {

        Map<String,Object> data = new HashMap<>();
        Map<String,List> provinceDataAll = new HashMap<>();
        provinceDataAll.put("A-G",new ArrayList<HashMap<String,Object>>());
        provinceDataAll.put("H-K",new ArrayList<HashMap<String,Object>>());
        provinceDataAll.put("L-S",new ArrayList<HashMap<String,Object>>());
        provinceDataAll.put("T-Z",new ArrayList<HashMap<String,Object>>());
        String url = "http://172.16.1.235:9999/base/areas/";
        String proviceUrl = url+"0";
        String proviceJsonResult = HttpUtil.get(proviceUrl, HttpUtil.CONTENT_TYPE_FORM);
        ResponseData proviceResult = JSON.parseObject(proviceJsonResult, ResponseData.class);
        List<Map<String,Object>> dBProvincelist = (List<Map<String,Object>>)proviceResult.getData().get("list");
        for (Map<String, Object> proviceMap : dBProvincelist) {
            String provinceId = (String)proviceMap.get("id");
            String provinceName = (String)proviceMap.get("areaName");
            char pinYinHeadChar = PinYinUtils.getPinYinFirstChar(provinceName);
            pinYinHeadChar = Character.toUpperCase(pinYinHeadChar);
            if(('A' <= pinYinHeadChar && 'G' >= pinYinHeadChar )){
                List provinceList = provinceDataAll.get("A-G");
                Map<String,Object> provinceData = new HashMap<>();
                provinceData.put("code",provinceId);
                provinceData.put("address",provinceName);
                provinceList.add(provinceData);
            }else if(('H' <= pinYinHeadChar && 'K' >= pinYinHeadChar )){
                List provinceList = provinceDataAll.get("H-K");
                Map<String,Object> provinceData = new HashMap<>();
                provinceData.put("code",provinceId);
                provinceData.put("address",provinceName);
                provinceList.add(provinceData);
            }else if(('L' <= pinYinHeadChar && 'S' >= pinYinHeadChar )){
                List provinceList = provinceDataAll.get("L-S");
                Map<String,Object> provinceData = new HashMap<>();
                provinceData.put("code",provinceId);
                provinceData.put("address",provinceName);
                provinceList.add(provinceData);
            }else if(('T' <= pinYinHeadChar && 'Z' >= pinYinHeadChar )){
                List provinceList = provinceDataAll.get("T-Z");
                Map<String,Object> provinceData = new HashMap<>();
                provinceData.put("code",provinceId);
                provinceData.put("address",provinceName);
                provinceList.add(provinceData);
            }
            String cityUrl = url+provinceId;
            String cityJsonResult = HttpUtil.get(cityUrl, HttpUtil.CONTENT_TYPE_FORM);
            ResponseData cityResult = JSON.parseObject(cityJsonResult, ResponseData.class);
            List<Map<String,Object>> dBCityList = (List<Map<String,Object>>)cityResult.getData().get("list");
            Map<String,Object> cityData = new HashMap<>();
            for (Map<String, Object> stringObjectMap : dBCityList) {
                String cityId = (String)stringObjectMap.get("id");
                String cityName = (String)stringObjectMap.get("areaName");
                cityData.put(cityId,cityName);
                String districtUrl = url+cityId;
                String districtJsonResult = HttpUtil.get(districtUrl, HttpUtil.CONTENT_TYPE_FORM);
                ResponseData districtResult = JSON.parseObject(districtJsonResult, ResponseData.class);
                List<Map<String,Object>> dBDistrictList = (List<Map<String,Object>>)districtResult.getData().get("list");
                Map<String,Object> districtData = new HashMap<>();
                for (Map<String, Object> objectMap : dBDistrictList) {
                    String districtId = (String)objectMap.get("id");
                    String districtName = (String)objectMap.get("areaName");
                    districtData.put(districtId,districtName);
                }
                data.put(cityId,districtData);
            }
            data.put(provinceId,cityData);
        }
        data.put("86",provinceDataAll);
        System.out.println(JSON.toJSONString(data));
        return data;
    }

}
