package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生表 sys_student
 * 
 * @author ruoyi
 * @date 2019-06-15
 */
public class Student extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 学生编号 */
	private Integer studentId;
	/** 学生名称 */
	private String studentName;
	/** 学生年龄 */
	private Integer studentAge;

	public void setStudentId(Integer studentId) 
	{
		this.studentId = studentId;
	}

	public Integer getStudentId() 
	{
		return studentId;
	}
	public void setStudentName(String studentName) 
	{
		this.studentName = studentName;
	}

	public String getStudentName() 
	{
		return studentName;
	}
	public void setStudentAge(Integer studentAge) 
	{
		this.studentAge = studentAge;
	}

	public Integer getStudentAge() 
	{
		return studentAge;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("studentId", getStudentId())
            .append("studentName", getStudentName())
            .append("studentAge", getStudentAge())
            .toString();
    }
}
