package project.persistence.repositories;

import project.persistence.entities.UserImageContainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<UserImageContainer, Long> {
	UserImageContainer save(UserImageContainer userImageContainer);
	List<UserImageContainer> findByName(String name);
	List<UserImageContainer> findByUuid(String uuid);
	List<UserImageContainer> findByTagsContaining(String tag);
}
