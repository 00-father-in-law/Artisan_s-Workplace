package com.father_in_law.artisan_s_workplace.Activity.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class TalentShare implements Parcelable {
    public static final Creator<TalentShare> CREATOR = new Creator<TalentShare>() {
        /* class com.father_in_law.artisan_s_workplace.Data.TalentShare.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public TalentShare createFromParcel(Parcel in) {
            return new TalentShare(in);
        }

        @Override // android.os.Parcelable.Creator
        public TalentShare[] newArray(int size) {
            return new TalentShare[size];
        }
    };
    private String hpNotiEdate;
    private String hpNotiSdate;
    private String orgCd;
    private String orgNm;
    private String projEdate;
    private String projName;
    private String projNo;
    private String projSdate;

    public TalentShare() {
    }

    public TalentShare(String hpNotiEdate2, String hpNotiSdate2, String orgCd2, String orgNm2, String projEdate2, String projName2, String projNo2, String projSdate2) {
        this.hpNotiEdate = hpNotiEdate2;
        this.hpNotiSdate = hpNotiSdate2;
        this.orgCd = orgCd2;
        this.orgNm = orgNm2;
        this.projEdate = projEdate2;
        this.projName = projName2;
        this.projNo = projNo2;
        this.projSdate = projSdate2;
    }

    protected TalentShare(Parcel in) {
        this.hpNotiEdate = in.readString();
        this.hpNotiSdate = in.readString();
        this.orgCd = in.readString();
        this.orgNm = in.readString();
        this.projEdate = in.readString();
        this.projName = in.readString();
        this.projNo = in.readString();
        this.projSdate = in.readString();
    }

    public String getHpNotiEdate() {
        return this.hpNotiEdate;
    }

    public void setHpNotiEdate(String hpNotiEdate2) {
        this.hpNotiEdate = hpNotiEdate2;
    }

    public String getHpNotiSdate() {
        return this.hpNotiSdate;
    }

    public void setHpNotiSdate(String hpNotiSdate2) {
        this.hpNotiSdate = hpNotiSdate2;
    }

    public String getOrgCd() {
        return this.orgCd;
    }

    public void setOrgCd(String orgCd2) {
        this.orgCd = orgCd2;
    }

    public String getOrgNm() {
        return this.orgNm;
    }

    public void setOrgNm(String orgNm2) {
        this.orgNm = orgNm2;
    }

    public String getProjEdate() {
        return this.projEdate;
    }

    public void setProjEdate(String projEdate2) {
        this.projEdate = projEdate2;
    }

    public String getProjName() {
        return this.projName;
    }

    public void setProjName(String projName2) {
        this.projName = projName2;
    }

    public String getProjNo() {
        return this.projNo;
    }

    public void setProjNo(String projNo2) {
        this.projNo = projNo2;
    }

    public String getProjSdate() {
        return this.projSdate;
    }

    public void setProjSdate(String projSdate2) {
        this.projSdate = projSdate2;
    }

    public String toString() {
        return "TalentShare{hpNotiEdate='" + this.hpNotiEdate + '\'' + ", hpNotiSdate='" + this.hpNotiSdate + '\'' + ", orgCd='" + this.orgCd + '\'' + ", orgNm='" + this.orgNm + '\'' + ", projEdate='" + this.projEdate + '\'' + ", projName='" + this.projName + '\'' + ", projNo='" + this.projNo + '\'' + ", projSdate='" + this.projSdate + '\'' + '}';
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hpNotiEdate);
        parcel.writeString(this.hpNotiSdate);
        parcel.writeString(this.orgCd);
        parcel.writeString(this.orgNm);
        parcel.writeString(this.projEdate);
        parcel.writeString(this.projName);
        parcel.writeString(this.projNo);
        parcel.writeString(this.projSdate);
    }
}