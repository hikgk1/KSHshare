package project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import project.service.FileUploadService;
import project.persistence.entities.UserImageContainer;
import project.persistence.entities.SearchInput;


@Controller
public class SearchController {
	private FileUploadService fileUploadService;

	@Autowired
	public SearchController(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String searchHome(Model model) {
        model.addAttribute("searchInput", new SearchInput());

		return "Search";
	}

    @RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchSubmit(@ModelAttribute("searchInput") SearchInput searchInput, Model model) {
        List<UserImageContainer> results = fileUploadService.findByTagsContaining(searchInput.getTag());
        model.addAttribute("gallery", results);

		return "Gallery";
	}
}
