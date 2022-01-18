package io.github.dbarrerap.gridsfs.api;

import io.github.dbarrerap.gridsfs.services.SubirFicheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/api/files")
public class SubirFicheroController {
    @Autowired
    SubirFicheroService service;

    @PostMapping("/store")
    public Object upload(@RequestParam MultipartFile file) throws IOException {
        return service.uploadFile(file);
    }

    @GetMapping("/store")
    public Object retrieve() {
        return service.retrieveAll();
    }

    @GetMapping("/store/{id}")
    public Object retrieveById(@PathVariable String id) {
        return service.retrieveFileById(id);
    }

//    @GetMapping("/view/{id}")
//    public Object viewStore(@PathVariable String id) throws IOException {
//        return service.retrieveFile(id);
//    }
}
