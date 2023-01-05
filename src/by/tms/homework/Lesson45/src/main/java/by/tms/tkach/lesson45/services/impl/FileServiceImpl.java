package by.tms.tkach.lesson45.services.impl;

import by.tms.tkach.lesson45.dto.UploadResult;
import by.tms.tkach.lesson45.exceptions.UploadFailedException;
import by.tms.tkach.lesson45.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService {

    private static final Path RELATIVE_PATH = Path.of("./files");

    @Override
    public UploadResult upload(MultipartFile file) {

        Path destinationFile = RELATIVE_PATH.resolve(
                        Paths.get(file.getOriginalFilename()))
                .normalize().toAbsolutePath();

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationFile,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            throw new UploadFailedException(String.format("Can't upload file: %s", ex.getMessage()));
        }

        return UploadResult.builder().message("Uploaded successfully").build();
    }
}
