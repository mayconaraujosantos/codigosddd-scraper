package com.madsant.codigosddd.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResponseDTO implements Serializable {

    private String city;
    private String states;
    private String codeArea;
    private String uf;
}
