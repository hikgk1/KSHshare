package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;
import java.util.List;
import java.io.InputStream;
import java.io.File;
import java.io.FilenameFilter;

import project.service.FileUploadService;
import project.persistence.entities.UserImageContainer;

@Controller
public class ImgController {
	private Properties stillingar;
	private FileUploadService fileUploadService;

	@Autowired
	public ImgController(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

	@RequestMapping(value="/img/{imgId}", method=RequestMethod.GET)
	public String imgHome(@PathVariable String imgId, Model model) {
		final String finalId = imgId;

		// Load the settings from path.cfg
		try {
			stillingar = new Properties();
			InputStream in = getClass().getResourceAsStream("/path.cfg");
			stillingar.load(in);
			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Find the file on the hdd, and it's extension
		String imgExt = ".jpg"; // Assume jpg extension as default
		try {
			File dir = new File(stillingar.getProperty("filePath"));
			File[] tmp = dir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.startsWith(finalId + "."); // Find all the files that have the name from the imgId in the file path defined in path.cfg
				}
			});
			if(tmp.length == 0) return "redirect:/filenotfound"; // No file found with that name
			imgExt = tmp[0].getName(); // Otherwise store the full file name with extension
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Find the tags associated with the image
		// To-do: Do some work with the tags string before displaying it
		List<UserImageContainer> tagsList = fileUploadService.findByUuid(imgId);
		if(!tagsList.isEmpty()) {
			String tags = tagsList.get(0).getTags();
			model.addAttribute("imgTags", tags);
		}

		model.addAttribute("imgExt", imgExt.substring(imgExt.lastIndexOf(".") + 1)); // Add just the extension to the imgExt attribute

		model.addAttribute("imgId", imgId);
		return "Img";
	}
}
