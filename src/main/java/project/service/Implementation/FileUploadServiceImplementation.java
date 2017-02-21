package project.service.implementation;

import project.persistence.repositories.FileRepository;
import project.persistence.entities.UserImageContainer;
import project.service.FileUploadService;
import project.service.FileStorageService;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import org.apache.tika.*;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.mime.MimeType;

@Service
public class FileUploadServiceImplementation implements FileUploadService {
	private FileRepository repository;
	private FileStorageService storage;

	@Autowired
	public FileUploadServiceImplementation(FileRepository repository, FileStorageService storage) {
		this.repository = repository;
		this.storage = storage;
	}

	@Override
	public String store(UserImageContainer userImageContainer) {
		String uuid = userImageContainer.makeUuid(); // Generate a new Uuid
		String ending = ".jpg"; // Assume jpg extension as default
		MultipartFile mynd = userImageContainer.getImage();
		if(mynd == null) System.out.println("Fékk ekki mynd");

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

		storage.store(mynd, uuid, ending);

		userImageContainer.setEnding(ending);

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
