package com.szpx.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * coder:lishihui
 * 2020级软件工程各班分组及任务情况表
 */
@Data
@Table(name = "class_groups")
public class ClassGroups {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    // 学生编号
    private Integer std_number;
    // 项目编号
    private Integer project_number;
    // 项目名称
    private String project_name;
    // 项目主管姓名
    private String project_leader;
    // 项目组成员
    private String project_member;
    // 分工模块
    private String project_assignment;
    // 所属院系
    private String information;
    // 所属年级
    private String class_grade;
    // 所属班级
    private String class_number;
    // 学号
    private String std_code_number;
    // 个人主连接
    private String std_index;
    // 审核结果
    private String findings_result;
    // 主管考核结果
    private String leader_result;
    // 成员考核结果
    private String member_result;
    // 项目总进度
    private String total_progress;
    // 进度系数
    private String progress_nun;
    // 更新日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date update_time;
    // 备注
    private String remark;

    @Override
    public String toString() {
        return "ClassGroups{" +
                "id=" + id +
                ", std_number=" + std_number +
                ", project_number=" + project_number +
                ", project_name='" + project_name + '\'' +
                ", project_leader='" + project_leader + '\'' +
                ", project_member='" + project_member + '\'' +
                ", project_assignment='" + project_assignment + '\'' +
                ", information='" + information + '\'' +
                ", class_grade='" + class_grade + '\'' +
                ", class_number='" + class_number + '\'' +
                ", std_code_number='" + std_code_number + '\'' +
                ", std_index='" + std_index + '\'' +
                ", findings_result='" + findings_result + '\'' +
                ", leader_result='" + leader_result + '\'' +
                ", member_result='" + member_result + '\'' +
                ", total_progress='" + total_progress + '\'' +
                ", progress_nun='" + progress_nun + '\'' +
                ", update_time=" + update_time +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getStd_code_number() {
        return std_code_number;
    }

    public String getStd_index() {
        return std_index;
    }

    public void setStd_code_number(String std_code_number) {
        this.std_code_number = std_code_number;
    }

    public void setStd_index(String std_index) {
        this.std_index = std_index;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStd_number() {
        return std_number;
    }

    public Integer getProject_number() {
        return project_number;
    }

    public String getProject_name() {
        return project_name;
    }

    public String getProject_leader() {
        return project_leader;
    }

    public String getProject_member() {
        return project_member;
    }

    public String getProject_assignment() {
        return project_assignment;
    }

    public String getInformation() {
        return information;
    }

    public String getClass_grade() {
        return class_grade;
    }

    public String getClass_number() {
        return class_number;
    }

    public String getFindings_result() {
        return findings_result;
    }

    public String getLeader_result() {
        return leader_result;
    }

    public String getMember_result() {
        return member_result;
    }

    public String getTotal_progress() {
        return total_progress;
    }

    public String getProgress_nun() {
        return progress_nun;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStd_number(Integer std_number) {
        this.std_number = std_number;
    }

    public void setProject_number(Integer project_number) {
        this.project_number = project_number;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public void setProject_leader(String project_leader) {
        this.project_leader = project_leader;
    }

    public void setProject_member(String project_member) {
        this.project_member = project_member;
    }

    public void setProject_assignment(String project_assignment) {
        this.project_assignment = project_assignment;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setClass_grade(String class_grade) {
        this.class_grade = class_grade;
    }

    public void setClass_number(String class_number) {
        this.class_number = class_number;
    }

    public void setFindings_result(String findings_result) {
        this.findings_result = findings_result;
    }

    public void setLeader_result(String leader_result) {
        this.leader_result = leader_result;
    }

    public void setMember_result(String member_result) {
        this.member_result = member_result;
    }

    public void setTotal_progress(String total_progress) {
        this.total_progress = total_progress;
    }

    public void setProgress_nun(String progress_nun) {
        this.progress_nun = progress_nun;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
