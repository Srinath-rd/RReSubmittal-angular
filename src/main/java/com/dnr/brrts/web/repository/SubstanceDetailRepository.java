package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.SubstanceRO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class SubstanceDetailRepository {

    private static final Logger logger = LoggerFactory.getLogger(SubstanceDetailRepository.class);


   private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setJdbcTemplate(@Qualifier("primaryJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    public List<SubstanceRO> getAllSubstances() {
        String query = "SELECT sw_substance_sub_ref.substance_sub_cd cd,   "
                + "sw_substance_sub_ref.substance_sub_desc descrip, " + "r1.substance_cd cd1 , "
                + "r1.substance_name descrip1 " + "FROM s71584.sw_substance_sub_ref, "
                + "s71584.sw_substance_ref r1, s71584.sw_substance_sub_xref x1 "
                + "where sw_substance_sub_ref.substance_sub_cd = x1.substance_sub_cd "
                + "and x1.substance_cd = r1.substance_cd  order by sw_substance_sub_ref.substance_sub_desc asc ";

        List<SubstanceRO> substances = getAllSubstancesQuery(query);
        logger.debug("size:" + substances.size());
        substances.forEach(substance -> logger.debug(substance.getDescriptionp()));
        return substances;
    }

    public List<SubstanceRO> getAllSubstanceCategories(){
        String query = "select substance_cd , substance_name, substance_desc from sw_substance_ref";

        return getSubstances(query);
    }


    public List<SubstanceRO> getAllSubstanceTypes(){
        String query = "select substance_cd , substance_name, substance_desc from sw_substance_group_ref";
        return getSubstances(query);
    }

    private List<SubstanceRO> getSubstances(String query){
        List<SubstanceRO> substances = jdbcTemplate.query(query,  (rs, rowNum) -> {
            SubstanceRO substance = new SubstanceRO();
            substance.setCode1(rs.getString("substance_cd"));
            substance.setDescription1(rs.getString("substance_name"));
            return substance;
        });

        return substances;
    }


    public List<SubstanceRO> getSubstanceSublist(String inputSubstance1, String inputSubstance2) {
        String query = "SELECT sw_substance_sub_ref.substance_sub_cd cd, " +
                "sw_substance_sub_ref.substance_sub_desc descrip, r1.substance_cd cd1 , " +
                "r1.substance_name descrip1 FROM " +
                "s71584.sw_substance_sub_ref " +
                "INNER JOIN s71584.sw_substance_sub_xref x1 on SW_SUBSTANCE_SUB_REF.SUBSTANCE_SUB_CD = x1.SUBSTANCE_SUB_CD " +
                "INNER JOIN s71584.sw_substance_ref r1 on x1.SUBSTANCE_CD = r1.SUBSTANCE_CD " +
                "where r1.SUBSTANCE_NAME like :substance1 or r1.SUBSTANCE_NAME like :substance2 or SW_SUBSTANCE_SUB_REF.SUBSTANCE_SUB_DESC like :substance2 " +
                "order by sw_substance_sub_ref.substance_sub_desc asc ";

        List<SubstanceRO> substances = getSublistSubstances(query, inputSubstance1, inputSubstance2);
        logger.debug("size:" + substances.size());
        substances.forEach(substance -> logger.debug(substance.getDescriptionp()));
        return substances;
    }

    private List<SubstanceRO> getSublistSubstances(String query, String substance1, String substance2) {
        Map<String, Object> params = new HashMap<>();
        if(substance1.trim().equals("")) substance1 = "none";
        if(substance2.trim().equals("")) substance2 = "none";
        params.put("substance1", "%" + substance1 + "%");
        params.put("substance2", "%" + substance2 + "%");
        return this.namedParameterJdbcTemplate.query(query, params,  (rs, rowNum) -> getSubstanceRO(rs));
    }

    private SubstanceRO getSubstanceRO(ResultSet rs) throws SQLException {
        SubstanceRO substance = new SubstanceRO();
        substance.setCode1(rs.getString("cd1"));
        substance.setDescription1(rs.getString("descrip1"));
        substance.setCodep(rs.getString("cd"));
        substance.setDescriptionp(rs.getString("descrip"));
        return substance;
    }

    private List<SubstanceRO> getAllSubstancesQuery(String query) {

        List<SubstanceRO> substances = jdbcTemplate.query(query,
                (rs, rowNum) -> getSubstanceRO(rs));
        substances.forEach(substanceRO -> logger.debug(substanceRO.getCode1() + ":" + substanceRO.getDescriptionp()));
        return substances;
    }
}
