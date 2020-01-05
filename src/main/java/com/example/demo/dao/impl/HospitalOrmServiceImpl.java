package com.example.demo.dao.impl;

import com.example.demo.dao.HospitalOrmService;
import com.example.demo.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Author:Created by wx on 2019/12/31
 * Desc:
 */
@Repository
public class HospitalOrmServiceImpl implements HospitalOrmService {


    @Autowired
    @Qualifier("ds2JdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long addOne(Hospital hospital) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int result = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "INSERT INTO bl_hospital (name,status,code) VALUES (?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"oid"});
                ps.setString(1,hospital.getName());
                ps.setString(2,hospital.getStatus());
                ps.setString(3,hospital.getCode());
                return ps;
            }
        }, keyHolder);

        if (result == 1) {
            return keyHolder.getKey().longValue();
        }
        return null;
    }

    @Override
    public void batchInsert(List<Hospital> hospitalList) {
        String sql = "INSERT INTO bl_hospital (name,status,code) VALUES (?,?,?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Hospital hospital = hospitalList.get(i);
                ps.setString(1,hospital.getName());
                ps.setString(2,hospital.getStatus());
                ps.setString(3,hospital.getCode());
            }
            @Override
            public int getBatchSize() {
                return hospitalList.size();
            }
        });

    }

    @Override
    public void batchUpdate(List<Hospital> hospitalList) {

    }

    @Override
    public void update(Hospital hospital) {

    }

    @Override
    public Hospital findOneByOid(Long oid) {
        Hospital hospital = null;
        try {
            String sql = "SELECT * FROM bl_hospital WHERE oid = ? ";
            hospital = jdbcTemplate.queryForObject(sql, new Object[]{oid},Hospital.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hospital;
    }

    @Override
    public Hospital findOneByCode(String code) {
        Hospital hospital = null;
        try {
            String sql = "SELECT * FROM bl_hospital WHERE code = ? ";
            hospital = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Hospital.class),code );
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return hospital;
    }

    @Override
    public Long getOid(String code) {
        Long oid = null;
        try {
            String sql = "SELECT * FROM bl_hospitl WHERE code = ? ";
            oid = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Long.class),code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return oid;
    }
}
