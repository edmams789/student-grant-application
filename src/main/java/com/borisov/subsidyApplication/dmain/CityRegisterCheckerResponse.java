package com.borisov.subsidyApplication.dmain;

public class CityRegisterCheckerResponse { // ответ из городского реестра
    
    private boolean existing;
    private Boolean temporal; //true - false - null

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }

    public Boolean getTemporal() {
        return temporal;
    }

    public void setTemporal(Boolean temporal) {
        this.temporal = temporal;
    }
    
    
}