package com.father_in_law.artisan_s_workplace.data;

import java.io.Serializable;

/**
 *  Serializable를 통해 Intent로 Data 통신이 가능해
 *
 * Intent intent = new Intent();
 *             intent.putExtra("data", jobItem);
 */
public class JobItem implements Serializable {
    private String primaryKey; //연번
    private String recruitmentDate; //구인 등록일
    private String recruitmentPeriod; //모집 기간
    private String establishmentName; //사업자명
    private String recruitmentType; //모집 직종
    private String employmentType; //고용형태
    private String wageFrom; //임금 형태
    private String wages; //임금
    private String workPlace; //근무지
    private String entranceType; //입사 형태
    private String requiredCareer; //요구 경력
    private String requiredEducational; //요구 학력
    private String major; //전공 계열
    private String requiredCertificate; //요구 자격증
    private String establishmentAddress; //사업장 주소
    private String corporateForm; //기업형태
    private String agency; //담당 기관
    private String registrationDate; //등록일
    private String contactInformation; //연락처

    public JobItem(String primaryKey, String recruitmentDate, String recruitmentPeriod,
                   String establishmentName, String recruitmentType,
                   String employmentType, String wageFrom, String wages,
                   String workPlace, String entranceType, String requiredCareer,
                   String requiredEducational, String major,
                   String requiredCertificate, String establishmentAddress,
                   String corporateForm, String agency,
                   String registrationDate, String contactInformation)
    {
        this.primaryKey = primaryKey;
        this.recruitmentDate = recruitmentDate;
        this.recruitmentPeriod = recruitmentPeriod;
        this.establishmentName = establishmentName;
        this.recruitmentType = recruitmentType;
        this.employmentType = employmentType;
        this.wageFrom = wageFrom;
        this.wages = wages;
        this.workPlace = workPlace;
        this.entranceType = entranceType;
        this.requiredCareer = requiredCareer;
        this.requiredEducational = requiredEducational;
        this.major = major;
        this.requiredCertificate = requiredCertificate;
        this.establishmentAddress = establishmentAddress;
        this.corporateForm = corporateForm;
        this.agency = agency;
        this.registrationDate = registrationDate;
        this.contactInformation = contactInformation;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(String recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    public String getRecruitmentPeriod() {
        return recruitmentPeriod;
    }

    public void setRecruitmentPeriod(String recruitmentPeriod) {
        this.recruitmentPeriod = recruitmentPeriod;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        this.establishmentName = establishmentName;
    }

    public String getRecruitmentType() {
        return recruitmentType;
    }

    public void setRecruitmentType(String recruitmentType) {
        this.recruitmentType = recruitmentType;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getWageFrom() {
        return wageFrom;
    }

    public void setWageFrom(String wageFrom) {
        this.wageFrom = wageFrom;
    }

    public String getWages() {
        return wages;
    }

    public void setWages(String wages) {
        this.wages = wages;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getEntranceType() {
        return entranceType;
    }

    public void setEntranceType(String entranceType) {
        this.entranceType = entranceType;
    }

    public String getRequiredCareer() {
        return requiredCareer;
    }

    public void setRequiredCareer(String requiredCareer) {
        this.requiredCareer = requiredCareer;
    }

    public String getRequiredEducational() {
        return requiredEducational;
    }

    public void setRequiredEducational(String requiredEducational) {
        this.requiredEducational = requiredEducational;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getRequiredCertificate() {
        return requiredCertificate;
    }

    public void setRequiredCertificate(String requiredCertificate) {
        this.requiredCertificate = requiredCertificate;
    }

    public String getEstablishmentAddress() {
        return establishmentAddress;
    }

    public void setEstablishmentAddress(String establishmentAddress) {
        this.establishmentAddress = establishmentAddress;
    }

    public String getCorporateForm() {
        return corporateForm;
    }

    public void setCorporateForm(String corporateForm) {
        this.corporateForm = corporateForm;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
}
