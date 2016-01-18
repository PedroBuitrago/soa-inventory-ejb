package co.com.qabox.soainv.resources;

import javax.enterprise.inject.Produces;

import co.com.qabox.soainv.to.TechnicalServiceTO;

public class Resources {
    
    @Produces
    private TechnicalServiceTO techServTo;
}