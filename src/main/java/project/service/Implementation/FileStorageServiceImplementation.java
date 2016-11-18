package project.service.implementation;

import project.service.FileStorageService;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class FileStorageServiceImplementation implements FileStorageService {
	private static final String bucketName = System.getenv("KSHBUCKET");

	@Override
	public void store(MultipartFile mynd, String uuid, String ending) {
		AmazonS3 s3client = new AmazonS3Client();
		try {
			String keyName = "images/" + uuid + ending;

			s3client.putObject(new PutObjectRequest(bucketName, keyName, mynd.getInputStream(), null));
		} catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
            		"means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
            		"means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        } catch (IOException e) {
			System.out.println(e);
		}
	}
}