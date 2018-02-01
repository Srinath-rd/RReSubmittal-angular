package com.dnr.brrts.web.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class GISRepository {
    private static final Logger logger = LoggerFactory.getLogger(GISRepository.class);



    private JdbcTemplate jdbcTemplate;


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setJdbcTemplate(@Qualifier("gisJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }


    public GISRepository() {
    }


    public String getMunicipalityFromInputxy(double latitude, double longitude)
    {
        String sql = "select mcd_name from " +
                "SDEDNR.EN_MCD_AR_VAR fc " +
                "WHERE st_intersects(fc.shape, (sde.st_transform(sde.st_geometry('point ('|| :longitude ||' '||:latitude||')', 4326), 3071, 1580))) = 1";

        Map<String, Object> params = new HashMap<>();
        params.put("latitude", latitude);
        params.put("longitude", longitude);
        String municipality = namedParameterJdbcTemplate.queryForObject(sql, params, String.class);

        return municipality;
    }

}
