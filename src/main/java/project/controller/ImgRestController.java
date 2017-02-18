package project.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import project.service.FileUploadService;
import project.persistence.entities.UserImageContainer;

@RestController
public class ImgRestController {
	private FileUploadService fileUploadService;

	@Autowired
	public ImgRestController(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

	@RequestMapping(value="/imgr/{imgId}", method=RequestMethod.GET)
	public UserImageContainer imgRest(@PathVariable String imgId, Model model) {
		// Find the ending and the tags associated with the image
		List<UserImageContainer> imgList = fileUploadService.findByUuid(imgId);

    if(!imgList.isEmpty()) {
      return imgList.get(0);
    }

		return new UserImageContainer();
	}
}
