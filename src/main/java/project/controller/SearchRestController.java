package project.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import project.service.FileUploadService;
import project.persistence.entities.UserImageContainer;
import project.persistence.entities.SearchInput;


@RestController
public class SearchRestController {
	private FileUploadService fileUploadService;

	@Autowired
	public SearchRestController(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

    @RequestMapping(value="/searchr", method=RequestMethod.POST)
	public UserImageContainer[] searchSubmit(@ModelAttribute("searchInput") SearchInput searchInput, Model model) {
		String query = searchInput.getTag();
		List<UserImageContainer> results = fileUploadService.findByTagsContaining(query);

		return (UserImageContainer[]) results.toArray();
	}
}
