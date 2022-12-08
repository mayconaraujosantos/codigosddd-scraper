package com.madsant.codigosddd.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "states_area_code")
public class StatesAreaCode {
    @Id
    private String id;

    private String city;
    private String states;
    private String codeArea;
    private String uf;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
