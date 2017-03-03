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
	public UserImageContainer submit(@ModelAttribute("userImageContainer") UserImageContainer userImageContainer, Model model) {
		String uuid = fileUploadService.store(userImageContainer);

		System.out.println(uuid);

		List<UserImageContainer> imgList = fileUploadService.findByUuid(uuid);

		if(!imgList.isEmpty()) {
			System.out.println("Fékk niðurstöðu");
			System.out.println(imgList.get(0).getUuid());
			UserImageContainer res = imgList.get(0);
			System.out.println(res.getUuid());
			return res;
		} else {
			System.out.println("Fékk ekki niðurstöðu");
			UserImageContainer res = new UserImageContainer();
			res.setUuid("Error");
			return res;
		}
	}
}
