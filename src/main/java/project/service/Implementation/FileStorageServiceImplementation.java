package project.service.implementation;

import project.service.FileStorageService;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FilenameFilter;

@Service
public class FileStorageServiceImplementation implements FileStorageService {

	@Override
	public boolean store(MultipartFile mynd, String uuid, String ending) {
		try {
			mynd.transferTo(
				new File(System.getenv("KSHIMGPATH") + uuid + ending)
				);
            return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

        return false;
	}
}
