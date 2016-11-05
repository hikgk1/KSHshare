package project.service;

import project.persistence.entities.UserImageContainer;
import java.util.List;

public interface FileUploadService {
	String store(UserImageContainer userImageContainer);
	List<UserImageContainer> findByName(String name);
	List<UserImageContainer> findByUuid(String uuid);
	List<UserImageContainer> findByTagsContaining(String tag);
}
