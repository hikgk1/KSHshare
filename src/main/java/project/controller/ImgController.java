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
	public String home(@PathVariable String imgId, Model model) {
		final String finalId = imgId;

		try {
			stillingar = new Properties();
			InputStream in = getClass().getResourceAsStream("/path.cfg");
			stillingar.load(in);
			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		String imgExt = ".jpg";
		try {
			File dir = new File(stillingar.getProperty("filePath"));
			File[] tmp = dir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.startsWith(finalId + ".");
				}
			});
			if(tmp.length == 0) return "redirect:/filenotfound";
			imgExt = tmp[0].getName();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<UserImageContainer> tagsList = fileUploadService.findByUuid(imgId);
		if(!tagsList.isEmpty()) {
			String tags = tagsList.get(0).getTags();
			model.addAttribute("imgTags", tags);
		}

		model.addAttribute("imgExt", imgExt.substring(imgExt.lastIndexOf(".") + 1));

		model.addAttribute("imgId", imgId);
		return "Img";
	}
}
