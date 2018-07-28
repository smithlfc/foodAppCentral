package com.xmith.sweb;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nimbusds.jose.proc.SecurityContext;
import com.xmith.dao.UserDataServices;
import com.xmith.dao.UserDataServicesImpl;
import com.xmith.models.UserAccount;
import com.xmith.models.UserAccountImag;
import com.xmith.models.UserDetails;
import com.xmith.services.UserServices;



@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private UserServices services;
	private TokenGenerator tokengenerator;
	
	@Autowired
	public void setTokengenerator(TokenGenerator tokengenerator) {
	this.tokengenerator = tokengenerator;
	}
	@Autowired
	public void setServices(UserServices services) {
	this.services = services;
	}
	
	@RequestMapping(value={"/all/home"},method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getHome(){
		logger.info("getHome entry");
		ModelAndView view= new ModelAndView("home");
		//go get generation of token
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//update attempts to zero
		services.updateAttemptsService(services.getUserId(authentication.getName()), "0");
		String token=tokengenerator.generateToken(authentication.getName());
		view.addObject("webtoken", token);
		logger.info("getHome exit");
		return view;

	}
	
    @RequestMapping(value={"/all/secure/getname"},method={RequestMethod.GET,RequestMethod.POST},produces={MediaType.TEXT_PLAIN_VALUE})
	public @ResponseBody String getdummydata(){
		
    	logger.info("this method is invoked after jwt passing");
    	//used for dummy use
        
    	return "hardcodedvalue";
    	
	}


	
	
@RequestMapping(value={"/login"},method={RequestMethod.GET})
	public ModelAndView loginpage(){
		logger.info("login method entry");
		ModelAndView view=new ModelAndView("login");
		
		
		logger.info("login methods exit");
		return view;
	}

@RequestMapping(value={"/reg"},method={RequestMethod.GET})
public ModelAndView getRegistration(){
logger.info("getRegistration: Entry");
ModelAndView modelAndView = new ModelAndView("registration");
modelAndView.addObject("userDetails", new UserDetails());
modelAndView.addObject("fname", true);
logger.info("getRegistration: Exit");
return modelAndView;
}

//this method will accept reg details validate + insert
@RequestMapping(value={"/setReg"},method={RequestMethod.GET,RequestMethod.POST})
public ModelAndView setRegistration( @Valid @ModelAttribute("userDetails") UserDetails userDetails,BindingResult bindingResult){
logger.info("setRegistration :Entry");
if(bindingResult.hasErrors()){
logger.info("binding failure");	
ModelAndView modelAndView= new ModelAndView("registration");
return modelAndView;
}
else{
logger.info("binding success");	
//inserting here
boolean insertUserRegDetails = services.insertUserRegDetails(userDetails);
if(insertUserRegDetails){
ModelAndView modelAndView = new ModelAndView("login");
//display message in front end
return modelAndView;
}
}
logger.info("setRegistration :Exit");
ModelAndView modelAndView = new ModelAndView("registration");	
//display message in front end
return modelAndView;
}


@RequestMapping(value={"/all/secure/getAccounts"},method={RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody List<UserAccountImag>  getAccountdetails(){
logger.info("getAccountdetails: Entry");
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
String userId = services.getUserId(authentication.getName());
List<UserAccount> accounts = services.getAccounts(userId);
List<UserAccountImag> accImagelist= new ArrayList<UserAccountImag>();
//total nonsense but ignore this
for (UserAccount userAccount : accounts) {
UserAccountImag accImage= new UserAccountImag();

accImage.setAccount_no(userAccount.getAccount_no());
accImage.setAccount_type(userAccount.getAccount_type());
accImage.setIfsc_no(userAccount.getIfsc_no());
accImage.setUser_id(userAccount.getUser_id());
accImage.setPrimary(userAccount.getPrimary());
//for iamges
if(accImage.getIfsc_no().contains("BKDN")){accImage.setHttimage("http://localhost:8080/sweb/resources/home/dena.jpg");}
if(accImage.getIfsc_no().contains("SBIN")){accImage.setHttimage("http://localhost:8080/sweb/resources/home/sbi.png");}
if(accImage.getIfsc_no().contains("ICIC")){accImage.setHttimage("http://localhost:8080/sweb/resources/home/icic.jpg");}
if(accImage.getIfsc_no().contains("HDFC")){accImage.setHttimage("http://localhost:8080/sweb/resources/home/hdfc.jpg");}
accImagelist.add(accImage);
logger.info(accImage.getAccount_no());
}
logger.info("getAccountdetails: Exit");
return accImagelist;
}

	
}
