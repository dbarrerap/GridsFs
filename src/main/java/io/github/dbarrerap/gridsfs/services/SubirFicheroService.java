package io.github.dbarrerap.gridsfs.services;

import com.mongodb.client.gridfs.model.GridFSFile;
import io.github.dbarrerap.gridsfs.entities.Store;
import io.github.dbarrerap.gridsfs.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SubirFicheroService {
    @Autowired
    StoreRepository repository;
    GridFsTemplate fsTemplate;

    public SubirFicheroService(StoreRepository repository, GridFsTemplate fsTemplate) {
        this.repository = repository;
        this.fsTemplate = fsTemplate;
    }

    public Store uploadFile(MultipartFile file) throws IOException {
        Store store = new Store();
        store.setFilename(file.getOriginalFilename());
        store.setContentType(file.getContentType());
        store.setSize(file.getSize());

        String resourceId = fsTemplate.store(file.getInputStream(), file.getOriginalFilename()).toString();

        store.setResourceId(resourceId);

        return repository.save(store);
    }

    public Store retrieveFileById(String id) {
        Optional<Store> optionalStore = repository.findById(id);
        if (optionalStore.isEmpty()) return null;
        return optionalStore.get();
    }

    public List<Store> retrieveAll() {
        return repository.findAll();
    }

//    public Object retrieveFile(String id) throws IOException {
//        Optional<Store> optionalStore = repository.findById(id);
//        if (optionalStore.isEmpty()) return null;
//
//        Query query = new Query(Criteria.where("_id").is(optionalStore.get().getResourceId()));
//        GridFSFile file = fsTemplate.findOne(query);
//        GridFsResource resource = fsTemplate.getResource(file);
//
//
//    }
}
