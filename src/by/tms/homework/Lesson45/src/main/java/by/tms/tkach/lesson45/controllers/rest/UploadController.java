package by.tms.tkach.lesson45.controllers.rest;

import by.tms.tkach.lesson45.dto.UploadResult;
import by.tms.tkach.lesson45.services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
@AllArgsConstructor
public class UploadController {

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<UploadResult> upload(@RequestParam ("file") MultipartFile file) {
        UploadResult upload = fileService.upload(file);
        return ResponseEntity
                .accepted()
                .body(upload);
    }
}
