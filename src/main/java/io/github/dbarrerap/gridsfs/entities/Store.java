package io.github.dbarrerap.gridsfs.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("store")
public class Store implements Serializable {
    private static final long serialVersionUUID = 1L;
    @Id
    private String id;
    private String filename;
    private String resourceId;
    private Long size;
    private String contentType;
}
