package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import project.service.FileUploadService;
import project.persistence.entities.UserImageContainer;

@Controller
public class ImgController {
	private FileUploadService fileUploadService;

	@Autowired
	public ImgController(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

	@RequestMapping(value="/img/{imgId}", method=RequestMethod.GET)
	public String imgHome(@PathVariable String imgId, Model model) {
		// Find the ending and the tags associated with the image
		List<UserImageContainer> imgList = fileUploadService.findByUuid(imgId);

		if(!imgList.isEmpty()) {
			String imgExt = imgList.get(0).getEnding();
			String imgTags = imgList.get(0).getTags();
			String imgName = imgList.get(0).getName();

			model.addAttribute("imgTags", imgTags);
			model.addAttribute("imgName", imgName);
			model.addAttribute("imgExt", imgExt);
			model.addAttribute("imgId", imgId);

			return "Img";
		}

		return "redirect:/filenotfound";
	}
}
