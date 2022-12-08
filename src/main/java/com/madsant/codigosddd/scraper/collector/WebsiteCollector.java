package com.madsant.codigosddd.scraper.collector;

import com.madsant.codigosddd.domain.model.StatesAreaCode;
import com.madsant.codigosddd.scraper.properties.CollectorProperties;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebsiteCollector {

    private final CollectorProperties collectorProperties;
    private final WebsiteClient websiteClient;
    private final WebsiteContentParser websiteContentParser;

    private List<StatesAreaCode> statesAreaCodes = new ArrayList<>();
    // private static <T> CompletableFuture<T> makeCompletableFuture(
    //     Future<T> future
    // ) {
    //     return CompletableFuture.supplyAsync(() -> {
    //         try {
    //             return future.get();
    //         } catch (InterruptedException | ExecutionException e) {
    //             throw new RuntimeException(e);
    //         }
    //     });
    // }
}
