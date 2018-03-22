package com.example.auction.application.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="author_detail")
public class Author {
    @Id
    @GeneratedValue
    /**
     * 作家ID
     * BIGINT
     */
    @Column(name="author_id")
    private Long authorId;

    /**
     * 作家姓名
     * VARCHAR
     */
    @Column(name="author_name")
    private String authorName;

    /**
     * 头像图片
     * VARCHAR
     */
    @Column(name="author_picture_portrait")
    private String authorPicturePortrait;

    /**
     * 宣传图片
     * VARCHAR
     */
    @Column(name="author_picture_publicity")
    private String authorPicturePublicity;

    /**
     * 作家级别
     * TINYINT(0：国家级;1：中书协/中美协;2：省级)
     */
    @Column(name="author_level")
    private Integer authorLevel;

    /**
     * 是否签约（0：未签约；1：已签约）
     * TINYINT
     */
    @Column(name="is_sign_up")
    private Integer isSignUp;

    /**
     * 作者录入时间
     * TIMESTAMP
     */
    @Column(name="author_input_time")
    private Date authorInputTime;
    /**
     * 作者修改时间
     * TIMESTAMP
     */
    @Column(name="author_update_time")
    private Date authorUpdateTime;
    /**
     * 作者录入员工
     * BIGINT
     */
    @Column(name="author_input_staff")
    private Long authorInputStaff;
    /**
     * 作者修改员工
     * BIGINT
     */
    @Column(name="author_update_staff")
    private Long authorUpdateStaff;

    /**
     * 作者视频
     */
    @Column(name="author_video")
    private String authorVideo;


    /**
     * 作者简介
     */
    @Column(name="author_profile")
    private String authorProfile;

    /**
     * 富文本信息
     */
    @Column(name="rich_text")
    private String richText ;

    @Column(name="is_delete")
    private Integer isDelete;

    private String remark2;
    private String remark3;
    private String remark4;
    private String remark5;
    private String remark6;
    private String remark7;
    private String remark8;
    private String remark9;
    private String remark10;
    private String remark11;
    private String remark12;
    private String remark13;
    private String remark14;
    private String remark15;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorPicturePortrait() {
        return authorPicturePortrait;
    }

    public void setAuthorPicturePortrait(String authorPicturePortrait) {
        this.authorPicturePortrait = authorPicturePortrait;
    }

    public String getAuthorPicturePublicity() {
        return authorPicturePublicity;
    }

    public void setAuthorPicturePublicity(String authorPicturePublicity) {
        this.authorPicturePublicity = authorPicturePublicity;
    }

    public Integer getAuthorLevel() {
        return authorLevel;
    }

    public void setAuthorLevel(Integer authorLevel) {
        this.authorLevel = authorLevel;
    }

    public Integer getIsSignUp() {
        return isSignUp;
    }

    public void setIsSignUp(Integer isSignUp) {
        this.isSignUp = isSignUp;
    }

    public Date getAuthorInputTime() {
        return authorInputTime;
    }

    public void setAuthorInputTime(Date authorInputTime) {
        this.authorInputTime = authorInputTime;
    }

    public Date getAuthorUpdateTime() {
        return authorUpdateTime;
    }

    public void setAuthorUpdateTime(Date authorUpdateTime) {
        this.authorUpdateTime = authorUpdateTime;
    }

    public Long getAuthorInputStaff() {
        return authorInputStaff;
    }

    public void setAuthorInputStaff(Long authorInputStaff) {
        this.authorInputStaff = authorInputStaff;
    }

    public Long getAuthorUpdateStaff() {
        return authorUpdateStaff;
    }

    public void setAuthorUpdateStaff(Long authorUpdateStaff) {
        this.authorUpdateStaff = authorUpdateStaff;
    }

    public String getAuthorVideo() {
        return authorVideo;
    }

    public void setAuthorVideo(String authorVideo) {
        this.authorVideo = authorVideo;
    }

    public String getAuthorProfile() {
        return authorProfile;
    }

    public void setAuthorProfile(String authorProfile) {
        this.authorProfile = authorProfile;
    }

    public String getRichText() {
        return richText;
    }

    public void setRichText(String richText) {
        this.richText = richText;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRemark6() {
        return remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }

    public String getRemark7() {
        return remark7;
    }

    public void setRemark7(String remark7) {
        this.remark7 = remark7;
    }

    public String getRemark8() {
        return remark8;
    }

    public void setRemark8(String remark8) {
        this.remark8 = remark8;
    }

    public String getRemark9() {
        return remark9;
    }

    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }

    public String getRemark10() {
        return remark10;
    }

    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }

    public String getRemark11() {
        return remark11;
    }

    public void setRemark11(String remark11) {
        this.remark11 = remark11;
    }

    public String getRemark12() {
        return remark12;
    }

    public void setRemark12(String remark12) {
        this.remark12 = remark12;
    }

    public String getRemark13() {
        return remark13;
    }

    public void setRemark13(String remark13) {
        this.remark13 = remark13;
    }

    public String getRemark14() {
        return remark14;
    }

    public void setRemark14(String remark14) {
        this.remark14 = remark14;
    }

    public String getRemark15() {
        return remark15;
    }

    public void setRemark15(String remark15) {
        this.remark15 = remark15;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authorPicturePortrait='" + authorPicturePortrait + '\'' +
                ", authorPicturePublicity='" + authorPicturePublicity + '\'' +
                ", authorLevel=" + authorLevel +
                ", isSignUp=" + isSignUp +
                ", authorInputTime=" + authorInputTime +
                ", authorUpdateTime=" + authorUpdateTime +
                ", authorInputStaff=" + authorInputStaff +
                ", authorUpdateStaff=" + authorUpdateStaff +
                ", authorVideo='" + authorVideo + '\'' +
                ", authorProfile='" + authorProfile + '\'' +
                ", richText='" + richText + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", remark2='" + remark2 + '\'' +
                ", remark3='" + remark3 + '\'' +
                ", remark4='" + remark4 + '\'' +
                ", remark5='" + remark5 + '\'' +
                ", remark6='" + remark6 + '\'' +
                ", remark7='" + remark7 + '\'' +
                ", remark8='" + remark8 + '\'' +
                ", remark9='" + remark9 + '\'' +
                ", remark10='" + remark10 + '\'' +
                ", remark11='" + remark11 + '\'' +
                ", remark12='" + remark12 + '\'' +
                ", remark13='" + remark13 + '\'' +
                ", remark14='" + remark14 + '\'' +
                ", remark15='" + remark15 + '\'' +
                '}';
    }
}
