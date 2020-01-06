package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Benefits;
import com.example.service.BenefitsService;

@RestController
@RequestMapping("benefits")
public class BenefitsController {
	
	private static final Logger logger = LoggerFactory.getLogger(BenefitsController.class);
	
	@Autowired
	BenefitsService benefitsService;
	
	@RequestMapping(value = "/show/{employeeId}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("employeeId") Integer id) {
		logger.info("Inside Find Emp By Id....................Emp");
	  ModelAndView model = new ModelAndView("benefit");
        List<Benefits> benefits = benefitsService.findBenefitsById(id);
        model.addObject("benefits", benefits);
        return model;
    }

}
