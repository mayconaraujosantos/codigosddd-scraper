package com.madsant.codigosddd.scraper.runner;

import com.madsant.codigosddd.scraper.collector.WebsiteContentParser;
import com.madsant.codigosddd.scraper.properties.CollectorProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CollectorRunner implements CommandLineRunner {

    private final CollectorProperties collectorProperties;
    private final WebsiteContentParser websiteContentParser;

    @Override
    public void run(String... args) throws Exception {
         
    }
}
