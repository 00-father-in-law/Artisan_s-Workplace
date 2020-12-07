package com.father_in_law.artisan_s_workplace.Activity.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class NoInJob implements Parcelable {
    public static final Creator<NoInJob> CREATOR = new Creator<NoInJob>() {

        @Override // android.os.Parcelable.Creator
        public NoInJob createFromParcel(Parcel in) {
            return new NoInJob(in);
        }

        @Override // android.os.Parcelable.Creator
        public NoInJob[] newArray(int size) {
            return new NoInJob[size];
        }
    };

    private String hpNotiEdate;
    private String hpNotiSdate;
    private String intCnt;
    private String jobType;
    private String orgName;
    private String projNo;
    private String projYear;
    private String trnStatNm;
    private String workPlace;

    public NoInJob() {
    }

    public NoInJob(String hpNotiEdate2, String hpNotiSdate2, String intCnt2, String jobType2, String orgName2, String projNo2, String projYear2, String trnStatNm2, String workPlace2) {
        this.hpNotiEdate = hpNotiEdate2;
        this.hpNotiSdate = hpNotiSdate2;
        this.intCnt = intCnt2;
        this.jobType = jobType2;
        this.orgName = orgName2;
        this.projNo = projNo2;
        this.projYear = projYear2;
        this.trnStatNm = trnStatNm2;
        this.workPlace = workPlace2;
    }

    protected NoInJob(Parcel in) {
        this.hpNotiEdate = in.readString();
        this.hpNotiSdate = in.readString();
        this.intCnt = in.readString();
        this.jobType = in.readString();
        this.orgName = in.readString();
        this.projNo = in.readString();
        this.projYear = in.readString();
        this.trnStatNm = in.readString();
        this.workPlace = in.readString();
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

    public String getIntCnt() {
        return this.intCnt;
    }

    public void setIntCnt(String intCnt2) {
        this.intCnt = intCnt2;
    }

    public String getJobType() {
        return this.jobType;
    }

    public void setJobType(String jobType2) {
        this.jobType = jobType2;
    }

    public String getOrgName() {
        return this.orgName;
    }

    public void setOrgName(String orgName2) {
        this.orgName = orgName2;
    }

    public String getProjNo() {
        return this.projNo;
    }

    public void setProjNo(String projNo2) {
        this.projNo = projNo2;
    }

    public String getProjYear() {
        return this.projYear;
    }

    public void setProjYear(String projYear2) {
        this.projYear = projYear2;
    }

    public String getTrnStatNm() {
        return this.trnStatNm;
    }

    public void setTrnStatNm(String trnStatNm2) {
        this.trnStatNm = trnStatNm2;
    }

    public String getWorkPlace() {
        return this.workPlace;
    }

    public void setWorkPlace(String workPlace2) {
        this.workPlace = workPlace2;
    }

    public String toString() {
        return "NoInJob{hpNotiEdate='"+ this.hpNotiEdate + '\'' + ", hpNotiSdate='" + this.hpNotiSdate + '\'' + ", intCnt='" + this.intCnt + '\'' + ", jobType='" + this.jobType + '\'' + ", orgName='" + this.orgName + '\'' + ", projNo='" + this.projNo + '\'' + ", projYear='" + this.projYear + '\''+ ", trnStatNm='" + this.trnStatNm + '\''+ ", workPlace='" + this.workPlace + '}';
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hpNotiEdate);
        parcel.writeString(this.hpNotiSdate);
        parcel.writeString(this.intCnt);
        parcel.writeString(this.jobType);
        parcel.writeString(this.orgName);
        parcel.writeString(this.projNo);
        parcel.writeString(this.projYear);
        parcel.writeString(this.trnStatNm);
        parcel.writeString(this.workPlace);
    }
}
