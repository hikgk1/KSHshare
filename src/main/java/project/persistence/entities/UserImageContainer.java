package project.persistence.entities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

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

	public UserImageContainer() {
	}

	public UserImageContainer(String name, String uuid) {
		this.name = name;
		this.uuid = uuid;
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

	public String getUuid() { return this.uuid; }
	public void setUuid(String uuid) { this.uuid = uuid; }

	public String getTags() { return this.tags; }
	public void setTags(String tags) { this.tags = tags; }
}
