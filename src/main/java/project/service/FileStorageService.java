package project.service;

import project.persistence.entities.UserImageContainer;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	boolean store(MultipartFile mynd, String uuid, String ending);
}
