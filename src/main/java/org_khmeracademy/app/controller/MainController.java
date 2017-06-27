package org_khmeracademy.app.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org_khmeracademy.app.model.User;
import org_khmeracademy.app.service.Userservice;

@Controller
public class MainController {
	@Autowired
	Userservice userservice;
	
	@RequestMapping("/")
	public String show(ModelMap map){
		map.put("URL", "/");
		List<User> listuser=new ArrayList<>();
		List<User> listusermale=new ArrayList<>();
		List<User> listuserfemale=new ArrayList<>();
		
		listuser=userservice.findAll();
		listusermale=userservice.maleuser();
		listuserfemale=userservice.femaleuser();
		
		map.put("TOTAL",listuser.size());
		map.put("MALE",listusermale.size());
		map.put("FEMALE",listuserfemale.size());
		return "/admin/dashboard";
	}
	
	@RequestMapping("/user")
	public String User(ModelMap map){
		map.put("URL", "/user");
		map.put("KEY",userservice.findAll());
		return"admin/userlist";
	}
	
	@RequestMapping("/usercu")
	public String showuser(Model model){
		model.addAttribute("KEY",userservice.findAll());
		model.addAttribute("USER",new User());
		model.addAttribute("URL", "/usercu");
		return"/admin/usercu";
	
	}
	
	@RequestMapping(value="/add-user", method=RequestMethod.POST)
	public String Input(@ModelAttribute User user, Model model){
		String uuid = UUID.randomUUID().toString();
		user.setUser_hash(uuid);
		userservice.save(user);
		model.addAttribute("KEY",userservice.findAll());
		model.addAttribute("URL", "/add-user");
		return "redirect:/usercu";
		
	}
	
	@RequestMapping(value="/remove-student/{userhash}")
	public String Remove(@PathVariable("userhash")String userhash,Model model){
		userservice.deleteByHash(userhash);
		model.addAttribute("KEY",userservice.findAll());
		return "redirect:/user";
	}
	
	@RequestMapping("/role-list")
	public String view(Model model){
		model.addAttribute("URL", "/role-list");
		return "/admin/user-role";
	}
	@RequestMapping("/rolecu")
	public String rolecu(Model model){
		model.addAttribute("URL","/rolecu");
		return "/admin/rolecu";
	}
	


	@RequestMapping(value="/update-user/{userhash}", method=RequestMethod.POST)
	public String update(@ModelAttribute User user,@PathVariable("userhash") String userhash, Model model){
		user.setUser_hash(userhash);
		userservice.updatebyUserhash(user);
		model.addAttribute("KEY",userservice.findAll());
		model.addAttribute("URL", "/update-user");
		return "/admin/userlist";
	}
//	get data to form
	
	@RequestMapping("/user-update/{userhash}")
	public String update(@PathVariable("userhash")String userhash, Model model){
		model.addAttribute("USER",userservice.finduserbyhash(userhash));
		model.addAttribute("ACTION","/update-user");
		model.addAttribute("userhash", userhash);
		return "/admin/update";
	}
	
	@RequestMapping("/user-detail/{userhash}")
	public String detail(@PathVariable("userhash")String userhash, Model model){
		model.addAttribute("USER",userservice.finduserbyhash(userhash));
		model.addAttribute("ACTION","/update-user");
		model.addAttribute("userhash", userhash);
		model.addAttribute("URL", "/user-detail");
		return "/admin/detail";
	}
}
