package com.ruoyi.system.service;

import com.ruoyi.system.domain.Student;
import java.util.List;

/**
 * 学生 服务层
 * 
 * @author ruoyi
 * @date 2019-06-15
 */
public interface IStudentService 
{
	/**
     * 查询学生信息
     * 
     * @param studentId 学生ID
     * @return 学生信息
     */
	public Student selectStudentById(Integer studentId);
	
	/**
     * 查询学生列表
     * 
     * @param student 学生信息
     * @return 学生集合
     */
	public List<Student> selectStudentList(Student student);
	
	/**
     * 新增学生
     * 
     * @param student 学生信息
     * @return 结果
     */
	public int insertStudent(Student student);
	
	/**
     * 修改学生
     * 
     * @param student 学生信息
     * @return 结果
     */
	public int updateStudent(Student student);
		
	/**
     * 删除学生信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteStudentByIds(String ids);
	
}
