package com.crud_operations.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.crud_operartions.model.StudentModel;
import com.crud_operations.response.ErrorObject;
import com.crud_operations.response.Response;
import com.crud_operations.service.StudentService;
import com.crud_operations.status.StatusCode;
import com.crud_operations.utils.CommonUtils;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;


	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public void addStudent(@RequestBody StudentModel studentModel) throws Exception {	
		studentService.addStudent(studentModel);  
	}
	
	//get all
		@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
		public  String getStudents() throws Exception {
			List<StudentModel> students=((StudentService) studentService).getStudents();
			Response res = CommonUtils.getResponseObject("List of students");
			if (students.isEmpty()) {
				ErrorObject err = CommonUtils.getErrorResponse("students Not Found", "students Not Found");
				res.setErrors(err);
				res.setStatus(StatusCode.ERROR.name());
			} else {
				res.setData(students);
			}
			return CommonUtils.getJson(res);
			
		}

	
	
	
	//get bank by id
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET,produces = "application/json")
	public  @ResponseBody String getUser(@PathVariable("id") int id) throws Exception {
		StudentModel model=studentService.getStudent(id);
		Response res = CommonUtils.getResponseObject(" Student found");
		if (model==null) {
			ErrorObject err = CommonUtils.getErrorResponse("Student Not Found", "Student Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
		} else {
			res.setData(model);
		}
		return CommonUtils.getJson(res);
		
		
	}
	//delete bank by id
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE,produces = "application/json")
	public @ResponseBody Response deleteStudent(@PathVariable("id") int id) throws Exception {
		return studentService.deleteStudent(id);
	}
	/*//delete all
	@RequestMapping(value="/deleteAll",method=RequestMethod.DELETE)
    public void deleteAll() {
		 bankService.deleteAll();
	}*/
	// Update a Note
	@RequestMapping(value="/update", method=RequestMethod.PUT,produces = "application/json")
	public @ResponseBody Response updateStudent( @RequestParam int id) throws Exception{
		 return studentService.updateStudent(id);  
       }
	/*
	@RequestMapping(value="/exists/{id}"),method=RequestMethod.GET)
	public Boolean exists(@RequestBody Bank bank,@pathvariable int id){
	return bankService.updateUser(bank);
	}
	*/


}
