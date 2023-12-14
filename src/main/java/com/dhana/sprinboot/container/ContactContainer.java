package com.dhana.sprinboot.container;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dhana.sprinboot.dao.Contactdao;
import com.dhana.sprinboot.model.model;


@Controller
public class ContactContainer {
	
	@Autowired
	private Contactdao daoMethod;
	
	
	@RequestMapping("index")
	public String index(){
		return "index";
	}
	
	//Add
	@RequestMapping("addContact")
	public String add(model contact){
		daoMethod.save(contact);
		return "index";
	}
	
	
	//GET
	@RequestMapping("getContact")
	public ModelAndView get(@RequestParam int number){
		ModelAndView mav= new ModelAndView("showContact");
		model contact=daoMethod.findById(number).orElse(new model());
		mav.addObject("contactDetails",contact);
		return mav;
	}
	
	//DELETE
	@RequestMapping("deleteContact")
	public ModelAndView delete(@RequestParam int number){
		ModelAndView mav= new ModelAndView("delContact");
		model contact=daoMethod.findById(number).orElse(new model());
		daoMethod.deleteById(number);
		mav.addObject("delDetails",contact);
		return mav;
	}
	
	
	
	
	//UPDATE //parameter as model or reqparam
	@RequestMapping("updateContact")
	public ModelAndView update(model contact){
		ModelAndView mav= new ModelAndView("UpdateContactPage");
		model deletedcontact=daoMethod.findById(contact.getNumber()).orElse(new model());
		daoMethod.deleteById(contact.getNumber());
		mav.addObject("dc",deletedcontact);
		return mav;
	}
	
	
	
	
	

}
