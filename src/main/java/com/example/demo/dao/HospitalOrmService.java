package com.example.demo.dao;

import com.example.demo.entity.Hospital;

import java.util.List;

/**
 * Author:Created by wx on 2019/12/31
 * Desc:
 */
public interface HospitalOrmService {
    Long addOne(Hospital hospital);

    void batchInsert(List<Hospital> hospitalList);

    void batchUpdate(List<Hospital> hospitalList);

    void update(Hospital hospital);

    Hospital findOneByOid(Long oid);

    Hospital findOneByCode(String code);

    Long getOid(String code);
}
