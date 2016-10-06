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
		try {
			stillingar = new Properties();
			InputStream in = getClass().getResourceAsStream("/path.cfg");
			stillingar.load(in);
			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		String uuid = UUID.randomUUID().toString();
		String ending = ".jpg";
		MultipartFile mynd = userImageContainer.getImage();

		try {
			Tika test = new Tika();
			String type = test.detect(mynd.getBytes());
			if(!type.substring(0, 5).equals("image")) return "redirect:/notimage";
			TikaConfig config = TikaConfig.getDefaultConfig();
			ending = config.getMimeRepository().forName(type).getExtension();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			mynd.transferTo(
				new File(stillingar.getProperty("filePath") + uuid + ending)
				);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		repository.save(new UserImageContainer(userImageContainer.getName(), uuid));

		return uuid;
	}

	@Override
	public List<UserImageContainer> findByName(String name) {
		return repository.findByName(name);
	}
}