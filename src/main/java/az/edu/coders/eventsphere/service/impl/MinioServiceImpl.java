package az.edu.coders.eventsphere.service.impl;

import az.edu.coders.eventsphere.config.MinioConfig;
import az.edu.coders.eventsphere.service.MinioService;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@RequiredArgsConstructor
@Service
public class MinioServiceImpl implements MinioService {

    private final MinioClient minioClient;
    private final MinioConfig minioConfig;

    @Override
    public void putObject(InputStream inputStream, String bucketName, String fileName, String fileType)
            throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.putObject(PutObjectArgs.builder().bucket(bucketName)
                        .object(fileName)
                        .stream(inputStream, -1, minioConfig.getFileSize())
                .build());
    }

    @Override
    public InputStream getObject(String bucketName, String filename) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(bucketName)
                        .object(filename)
                        .build()
        );
    }


}
