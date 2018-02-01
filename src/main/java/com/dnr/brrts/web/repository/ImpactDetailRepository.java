package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.ImpactRO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImpactDetailRepository {

    private static final Logger logger = LoggerFactory.getLogger(ImpactDetailRepository.class);

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate jdbcTemplate;

    private final String query = "select impact_code, impact_desc, applicable_risk_code from "
            + "sw_impact_ref order by impact_desc asc ";

    public List<ImpactRO> getImpactList() {

        List<ImpactRO> impacts = jdbcTemplate.query(query, (rs, rowNum) -> {
            ImpactRO impact = new ImpactRO();
            impact.setImpactCode(rs.getString("impact_code"));
            impact.setImpactDescription(rs.getString("impact_desc"));
            impact.setApplicableRisk(rs.getString("applicable_risk_code"));

            return impact;
        });
        logger.info("size:" + impacts.size());
        impacts.forEach(impact -> logger.info(impact.getApplicableRisk()));
        return impacts;
    }

}
