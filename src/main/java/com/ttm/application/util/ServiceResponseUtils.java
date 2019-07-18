package com.ttm.application.util;

import com.ttm.application.action.vo.ServiceResponse;

/**
 * <p>@Author tangtaiming</p>
 * <p>@Date 2019-07-17</p>
 * <p>@Version 1.0</p>
 **/
public class ServiceResponseUtils {

    public static String success(String result) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setCode(200);
        serviceResponse.setMsg("success");
        serviceResponse.setResult(result);
        return Json.toJson(serviceResponse);
    }

}
