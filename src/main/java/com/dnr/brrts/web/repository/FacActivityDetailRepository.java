package com.dnr.brrts.web.repository;


import com.dnr.brrts.web.model.Address;
import com.dnr.brrts.web.model.FacilityRO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

@org.springframework.stereotype.Repository
public class FacActivityDetailRepository {

    private static final Logger logger = LoggerFactory.getLogger(FacActivityDetailRepository.class);
    private static final String STATE = "WI";
    //private final String query = "select detail_seq_no, activity_detail_name from sw_fac_act_detail fac  where activity_detail_name like ? and rownum < 20 ";

    private final String query = "SELECT d.activity_detail_no BrrtsNo,   " +
            "f.fac_name LocName ,   " +
            "f.loc_addr LocAddr,   " +
            "f.loc_city LocCity,   " +
            "f.loc_zip_code LocZip,   " +
            "UPPER(c.county_name) County, " +
            "f.region_abbr Region,   " +
            "f.fid Fid,   " +
            "f.loc_state state 	" +
            "FROM S71584.sw_fac_act_detail d " +
            "left join S71584W.SW_ACTIVITY_STATUS_V v on d.detail_seq_no = v.DETAIL_SEQ_NO " +
            "right join S71591.sw_facility f on f.site_id = d.site_id " +
            "inner join X86054.dw_county c on f.COUNTY_CODE = c.COUNTY_CODE " +
            "WHERE f.fac_name LIKE ? AND f.loc_state = ? and rownum < 20 ORDER BY d.activity_detail_no ASC ";
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<FacilityRO> getFacilitiesByName(String name) {
        String inputparam1 = "%" + name.toUpperCase().trim() + "%";
        logger.info("filter by:" + name);
        List<FacilityRO> facilitiesList = jdbcTemplate.query(query, new Object[]{inputparam1, STATE},
                (rs, rowNum) -> {
                    FacilityRO fac = new FacilityRO();
                    fac.setBrrtsNumber(rs.getString("BrrtsNo"));
                    fac.setFacilityName(rs.getString("LocName"));
                    Address address = new Address();
                    address.setStreetAddress1(rs.getString("LocAddr"));
                    address.setCity(rs.getString("LocCity"));
                    address.setZipcode(rs.getString("LocZip"));
                    address.setCounty(rs.getString("County"));
                    address.setRegion(rs.getString("Region"));
                    address.setState(rs.getString("state"));
                    fac.setAddress(address);
                    return fac;
                }
        );
        logger.info("size:" + facilitiesList.size());
        facilitiesList.forEach(facility -> logger.info(facility.getFacilityName()));
        return facilitiesList;

    }

}
