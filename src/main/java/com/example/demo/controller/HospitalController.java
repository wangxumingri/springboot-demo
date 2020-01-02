package com.example.demo.controller;

import com.example.demo.dto.BaseResponse;
import com.example.demo.entity.Hospital;
import com.example.demo.enums.ResponseEnums;
import com.example.demo.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Author:Created by wx on 2019/12/20
 * Desc:
 */
@Controller
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private ApplicationContext applicationContext;


    @RequestMapping(path = "/addOne",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse addHospitalCode(@RequestBody Hospital hospital) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            Long oid = hospitalService.addOne(hospital);
            baseResponse.setResultCode(ResponseEnums.Success.getCode());
            baseResponse.setResultMessage(ResponseEnums.Success.getDesc());
        } catch (Exception e) {
            baseResponse.setResultCode(ResponseEnums.Fail.getCode());
            baseResponse.setResultMessage(e.getCause()+e.getMessage());
        }

        return baseResponse;
    }

    @RequestMapping(path = "/findOne",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findOne(@RequestParam("code") String code){

        Object hospitalServiceImpl = applicationContext.getBean("hospitalServiceImpl");
        BaseResponse baseResponse = new BaseResponse();
        try {
            Hospital hospital = hospitalService.findOneByCode(code);
            baseResponse.setResultCode(ResponseEnums.Success.getCode());
            baseResponse.setResultMessage(ResponseEnums.Success.getDesc());
            baseResponse.setResultContent(hospital);
        } catch (Exception e) {
            baseResponse.setResultCode(ResponseEnums.Fail.getCode());
            baseResponse.setResultMessage(e.getMessage());
        }
        return baseResponse;
    }

}
