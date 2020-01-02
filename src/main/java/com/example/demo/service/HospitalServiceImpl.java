package com.example.demo.service;

import com.example.demo.dao.HospitalOrmService;
import com.example.demo.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:Created by wx on 2019/12/20
 * Desc:
 */
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalOrmService hospitalOrmService;

    @Override
    public Long addOne(Hospital hospital) {
        Long oid = null;
        if (hospital != null){
            Hospital hospitalInDB = hospitalOrmService.findOneByCode(hospital.getCode());
            if (hospitalInDB != null){
                throw new RuntimeException(hospitalInDB.getName()+"已存在");
            }else {
                oid = hospitalOrmService.addOne(hospital);
            }
        }
        return oid;

    }

    @Override
    public void batchInsert(List<Hospital> hospitalList) {
        hospitalOrmService.batchInsert(hospitalList);
    }

    @Override
    public void batchUpdate(List<Hospital> hospitalList) {
        hospitalOrmService.batchUpdate(hospitalList);
    }

    @Override
    public void update(Hospital hospital) {
        hospitalOrmService.update(hospital);
    }

    @Override
    public Hospital findOneByOid(Long oid) {
        return hospitalOrmService.findOneByOid(oid);
    }

    @Override
    public Hospital findOneByCode(String code) {
        return hospitalOrmService.findOneByCode(code);
    }

    @Override
    public Long getOid(String code) {
        return hospitalOrmService.getOid(code);
    }
}
