package com.crud_operations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud_operartions.model.StudentContactModel;
import com.crud_operations.response.ErrorObject;
import com.crud_operations.response.Response;
import com.crud_operations.service.StudentContactService;
import com.crud_operations.status.StatusCode;
import com.crud_operations.utils.CommonUtils;

@RestController
public class StudentContactController {
	
	@Autowired
	StudentContactService studentcontactservice;
	
	@RequestMapping(value = "/add/student-contact", method = RequestMethod.POST, produces = "application/json")
	public void addStudentContact(@RequestBody StudentContactModel studentcontactmodel) throws Exception {	
		studentcontactservice.addStudentContact(studentcontactmodel);  
	}
	
	
	
	@RequestMapping(value="/get/{id}/student-contact",method=RequestMethod.GET,produces = "application/json")
	public  @ResponseBody String getUser(@PathVariable("id") int id) throws Exception {
		StudentContactModel model=studentcontactservice.getStudent(id);
		Response res = CommonUtils.getResponseObject(" Student contact found");
		if (model==null) {
			ErrorObject err = CommonUtils.getErrorResponse("Student Contact Not Found", "Student Contact Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
		} else {
			res.setData(model);
		}
		return CommonUtils.getJson(res);	
	}
	
	@RequestMapping(value="/delete/{id}/student-contact",method=RequestMethod.DELETE,produces = "application/json")
	public @ResponseBody Response deleteStudent(@PathVariable("id") int id) throws Exception {
		return studentcontactservice.deleteStudent(id);
	}
	
	@RequestMapping(value="/update/student-contact", method=RequestMethod.PUT,produces = "application/json")
	public @ResponseBody Response updateStudent( @RequestParam int id) throws Exception{
		 return studentcontactservice.updateStudent(id);  
       }
}
