package project.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import project.service.FileUploadService;
import project.persistence.entities.UserImageContainer;

@RestController
public class UploadRestController {
	private FileUploadService fileUploadService;

	@Autowired
	public UploadRestController(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

	@RequestMapping(value="/uploadr", method=RequestMethod.POST)
	public Object submit(@ModelAttribute("userImageContainer") UserImageContainer userImageContainer, Model model) {
		String uuid = fileUploadService.store(userImageContainer);

		List<UserImageContainer> imgList = fileUploadService.findByUuid(uuid);

		if(!imgList.isEmpty()) {
			UserImageContainer res = imgList.get(0);
			return res;
		} else {
			UserImageContainer res = new UserImageContainer();
			res.setUuid("Error");
			return res;
		}
	}
}
