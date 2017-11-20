package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.SubstanceRO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class SubstanceDetailRepository {

    private static final Logger logger = LoggerFactory.getLogger(SubstanceDetailRepository.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String query = "SELECT sw_substance_sub_ref.substance_sub_cd cd,   "
            + "sw_substance_sub_ref.substance_sub_desc descrip, " + "r1.substance_cd cd1 , "
            + "r1.substance_name descrip1 " + "FROM s71584.sw_substance_sub_ref, "
            + "s71584.sw_substance_ref r1, s71584.sw_substance_sub_xref x1 "
            + "where sw_substance_sub_ref.substance_sub_cd = x1.substance_sub_cd "
            + "and x1.substance_cd = r1.substance_cd  order by sw_substance_sub_ref.substance_sub_desc asc ";

    public List<SubstanceRO> getAllSubstances() {

        List<SubstanceRO> substances = jdbcTemplate.query(query,
                (rs, rowNum) -> {
                    SubstanceRO substance = new SubstanceRO();
                    substance.setCode1(rs.getString("cd1"));
                    substance.setDescription1(rs.getString("descrip1"));
                    substance.setCodep(rs.getString("cd"));
                    substance.setDescriptionp(rs.getString("descrip"));
                    return substance;
                });
        logger.info("size:" + substances.size());
        substances.forEach(substance -> logger.info(substance.getDescriptionp()));
        return substances;
    }

}
