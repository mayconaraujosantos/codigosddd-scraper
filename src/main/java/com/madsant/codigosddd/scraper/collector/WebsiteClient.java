package com.madsant.codigosddd.scraper.collector;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WebsiteClient {

    public Document call(String url) {
        try {
            Instant start = Instant.now();
            log.info("Calling url {}", url);
            Document document = Jsoup.connect(url).get();
            log.info(
                "got document from url {} in {} ms",
                url,
                Duration.between(start, Instant.now()).toMillis()
            );
            return document;
        } catch (IOException ex) {
            log.error(
                "Unable to get states from {}. Error message: {}",
                url,
                ex.getMessage()
            );
            return null;
        }
    }
}
