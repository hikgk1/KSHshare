package project.service.implementation;

import project.persistence.repositories.FileRepository;
import project.persistence.entities.UserImageContainer;
import project.service.FileUploadService;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.lang.Exception;

import java.util.Properties;
import java.io.InputStream;

import java.util.UUID;
import org.apache.tika.*;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.mime.MimeType;

@Service
public class FileUploadServiceImplementation implements FileUploadService {
	private FileRepository repository;
	private Properties stillingar;

	@Autowired
	public FileUploadServiceImplementation(FileRepository repository) {
		this.repository = repository;
	}

	@Override
	public String store(UserImageContainer userImageContainer) {
		// Load the settings from path.cfg
		try {
			stillingar = new Properties();
			InputStream in = getClass().getResourceAsStream("/path.cfg");
			stillingar.load(in);
			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		String uuid = UUID.randomUUID().toString(); // Generate a new Uuid
		String ending = ".jpg"; // Assume jpg extension as default
		MultipartFile mynd = userImageContainer.getImage();

		// Find out if the file is an image, and what it's extension is
		// Uses apache tika to do this (https://tika.apache.org/)
		try {
			Tika tika = new Tika();
			String type = tika.detect(mynd.getBytes());
			if(!type.substring(0, 5).equals("image")) return "redirect:/notimage";
			TikaConfig config = TikaConfig.getDefaultConfig();
			ending = config.getMimeRepository().forName(type).getExtension();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Save the image to the path defined by path.cfg using the generated uuid and correct extension
		try {
			mynd.transferTo(
				new File(stillingar.getProperty("filePath") + uuid + ending)
				);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		userImageContainer.setUuid(uuid);

		repository.save(userImageContainer);

		return uuid;
	}

	@Override
	public List<UserImageContainer> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<UserImageContainer> findByUuid(String uuid) {
		return repository.findByUuid(uuid);
	}

	@Override
	public List<UserImageContainer> findByTagsContaining(String tag) {
		return repository.findByTagsContaining(tag);
	}
}
