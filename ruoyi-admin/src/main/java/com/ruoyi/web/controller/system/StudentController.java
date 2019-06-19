package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Student;
import com.ruoyi.system.service.IStudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-06-15
 */
@Controller
@RequestMapping("/system/student")
public class StudentController extends BaseController
{
    private String prefix = "system/student";
	
	@Autowired
	private IStudentService studentService;
	
	@RequiresPermissions("system:student:view")
	@GetMapping()
	public String student()
	{
	    return prefix + "/student";
	}
	
	/**
	 * 查询学生列表
	 */
	@RequiresPermissions("system:student:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Student student)
	{
		startPage();
        List<Student> list = studentService.selectStudentList(student);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学生列表
	 */
	@RequiresPermissions("system:student:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Student student)
    {
    	List<Student> list = studentService.selectStudentList(student);
        ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
        return util.exportExcel(list, "student");
    }
	
	/**
	 * 新增学生
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学生
	 */
	@RequiresPermissions("system:student:add")
	@Log(title = "学生", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Student student)
	{		
		return toAjax(studentService.insertStudent(student));
	}

	/**
	 * 修改学生
	 */
	@GetMapping("/edit/{studentId}")
	public String edit(@PathVariable("studentId") Integer studentId, ModelMap mmap)
	{
		Student student = studentService.selectStudentById(studentId);
		mmap.put("student", student);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学生
	 */
	@RequiresPermissions("system:student:edit")
	@Log(title = "学生", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Student student)
	{		
		return toAjax(studentService.updateStudent(student));
	}
	
	/**
	 * 删除学生
	 */
	@RequiresPermissions("system:student:remove")
	@Log(title = "学生", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(studentService.deleteStudentByIds(ids));
	}
	
}
