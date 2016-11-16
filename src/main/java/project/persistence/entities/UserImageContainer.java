package project.persistence.entities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "filedata")
public class UserImageContainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Transient
	private MultipartFile image;
	private String name;
	private String uuid;
	private String tags;
	private String ending;

	public UserImageContainer() {
	}

	public UserImageContainer(MultipartFile image, String name) {
		this.image = image;
		this.name = name;
	}

	public MultipartFile getImage() { return this.image; }
	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }

	public String makeUuid() {
		String uuid = UUID.randomUUID().toString(); // Generate a new Uuid
		this.uuid = uuid;
		return uuid;
	}
	public String getUuid() { return this.uuid; }
	public void setUuid(String uuid) { this.uuid = uuid; }

	public String getTags() { return this.tags; }
	public void setTags(String tags) { this.tags = tags; }

	public String getEnding() { return this.ending; }
	public void setEnding(String ending) { this.ending = ending; }
}
