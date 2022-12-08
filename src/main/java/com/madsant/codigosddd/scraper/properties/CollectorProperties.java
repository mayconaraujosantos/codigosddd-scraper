package com.madsant.codigosddd.scraper.properties;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;



@Component
@Data
@Validated
@ConfigurationProperties(prefix = "codigosddd")
public class CollectorProperties {
    @NotNull
    private Mode mode;

    @NotNull
    private Website website;

    public enum Mode {
        GET_AND_SAVE, GET_ALL_AND_SAVE_ALL
    }

    @Data
    @Valid
    public static class Website {

        private String url;
    }
}
