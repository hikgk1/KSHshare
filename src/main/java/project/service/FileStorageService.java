package project.service;

import project.persistence.entities.UserImageContainer;
import java.util.List;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	void store(MultipartFile mynd, String uuid, String ending);
}
