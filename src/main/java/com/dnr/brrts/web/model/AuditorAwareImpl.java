package com.dnr.brrts.web.model;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String>{

    @Override
    public String getCurrentAuditor() {
        return "srinath";
    }
}
