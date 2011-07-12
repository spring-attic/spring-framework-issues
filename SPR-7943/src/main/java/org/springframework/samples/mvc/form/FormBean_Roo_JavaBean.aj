package org.springframework.samples.mvc.form;

import java.lang.String;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import org.springframework.samples.mvc.form.InquiryType;

privileged aspect FormBean_Roo_JavaBean {
    
	public String FormBean.getSecretValue() {
        return this.secretValue;
    }
    
    public void FormBean.setSecretValue(String secretValue) {
        this.secretValue = secretValue;
    }
	
    public String FormBean.getName() {
        return this.name;
    }
    
    public void FormBean.setName(String name) {
        this.name = name;
    }
    
    public int FormBean.getAge() {
        return this.age;
    }
    
    public void FormBean.setAge(int age) {
        this.age = age;
    }
    
    public Date FormBean.getBirthDate() {
        return this.birthDate;
    }
    
    public void FormBean.setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    public String FormBean.getPhone() {
        return this.phone;
    }
    
    public void FormBean.setPhone(String phone) {
        this.phone = phone;
    }
    
    public BigDecimal FormBean.getCurrency() {
        return this.currency;
    }
    
    public void FormBean.setCurrency(BigDecimal currency) {
        this.currency = currency;
    }
    
    public BigDecimal FormBean.getPercent() {
        return this.percent;
    }
    
    public void FormBean.setPercent(BigDecimal percent) {
        this.percent = percent;
    }
    
    public InquiryType FormBean.getInquiry() {
        return this.inquiry;
    }
    
    public void FormBean.setInquiry(InquiryType inquiry) {
        this.inquiry = inquiry;
    }
    
    public String FormBean.getInquiryDetails() {
        return this.inquiryDetails;
    }
    
    public void FormBean.setInquiryDetails(String inquiryDetails) {
        this.inquiryDetails = inquiryDetails;
    }
    
    public boolean FormBean.isSubscribeNewsletter() {
        return this.subscribeNewsletter;
    }
    
    public void FormBean.setSubscribeNewsletter(boolean subscribeNewsletter) {
        this.subscribeNewsletter = subscribeNewsletter;
    }
    
    public Map<String, String> FormBean.getAdditionalInfo() {
        return this.additionalInfo;
    }
    
    public void FormBean.setAdditionalInfo(Map<String, String> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    
}
