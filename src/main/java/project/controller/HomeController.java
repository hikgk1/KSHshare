package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import project.service.FileUploadService;
import project.persistence.entities.UserImageContainer;


@Controller
public class HomeController {
	private FileUploadService fileUploadService;

	@Autowired
	public HomeController(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("userImageContainer", new UserImageContainer());

		return "Index";
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public String submit(@ModelAttribute("userImageContainer") UserImageContainer userImageContainer, Model model) {
		String uuid = fileUploadService.store(userImageContainer);

		return "redirect:/img/" + uuid;
	}
}
