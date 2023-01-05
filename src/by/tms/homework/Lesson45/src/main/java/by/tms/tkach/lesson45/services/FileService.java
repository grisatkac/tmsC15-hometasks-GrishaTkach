package by.tms.tkach.lesson45.services;

import by.tms.tkach.lesson45.dto.UploadResult;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    UploadResult upload(MultipartFile file);

}
