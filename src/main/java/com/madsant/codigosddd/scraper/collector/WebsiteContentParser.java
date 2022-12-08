package com.madsant.codigosddd.scraper.collector;

import com.madsant.codigosddd.domain.model.StatesAreaCode;
import com.madsant.codigosddd.scraper.properties.CollectorProperties;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebsiteContentParser {

    private static final String TABLE_SELECTOR =
        "table > tbody > tr:not(.ddds)";
    private static final String SECTION_SELECTOR =
        "section.ddds:eq(1) > ul > li ";
    private final WebsiteClient websiteClient;
    private final CollectorProperties collectorProperties;

    public List<StatesAreaCode> parse(Document document) {
        if (document == null) {
            return Collections.emptyList();
        }
        Elements elements = document.select(TABLE_SELECTOR);
        return elements
            .stream()
            .map(this::makeElementSelector)
            .collect(Collectors.toList());
    }

    private StatesAreaCode makeElementSelector(Element element) {
        var city = element.select("td:lt(1)").text();
        var codeArea = element.select("td:eq(1)").text();
        var states = element.select("td:eq(2)").text();
        var uf = element.select("td:eq(3)").text();
        return StatesAreaCode
            .builder()
            .city(city)
            .codeArea(codeArea)
            .states(states)
            .uf(uf)
            .build();
    }

    // public Set<StatesAreaCode> getAllStatesLinksFromPage() throws IOException {

    //     // var urls = makeStatesUrls();

    //     // Set<StatesAreaCode> responseDTOS = new HashSet<>();

    //     // for (String url : urls) {
    //     //     extractDataFromAreaCode(responseDTOS, url);
    //     // }
    //     // return responseDTOS;
    // }

    private Set<String> makeStatesUrls() {
        Set<String> links = new HashSet<>();
        Document document = websiteClient.call(
            collectorProperties.getWebsite().getUrl()
        );
        Elements elements = document.select(SECTION_SELECTOR);
        elements.forEach(link -> {
            links.add(link.select("a").attr("href"));
        });
        return links;
    }

    private void extractDataFromAreaCode(
        Set<StatesAreaCode> responseDTOS,
        String url
    ) {
        Document documentLinks = websiteClient.call(url);
        Elements elements = documentLinks.select(TABLE_SELECTOR);

        for (Element states : elements) {
            StatesAreaCode responseDTO = new StatesAreaCode();
            responseDTO.setCity(states.select("td:lt(1)").text());
            responseDTO.setCodeArea(states.select("td:eq(1)").text());
            responseDTO.setStates(states.select("td:eq(2)").text());
            responseDTO.setUf(states.select("td:eq(3)").text());
            responseDTOS.add(responseDTO);
        }
        log.info("call url by elements: {} {}", url, elements);
    }
}
