package com.madsant.codigosddd.scraper.collector;

import com.madsant.codigosddd.domain.model.StatesAreaCode;
import com.madsant.codigosddd.domain.repository.StatesAreaCodeRepository;
import com.madsant.codigosddd.scraper.properties.CollectorProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebsiteContentParser {
    private final StatesAreaCodeRepository statesAreaCodeRepository;
    private static final String TABLE_SELECTOR =
        "table > tbody > tr:not(.ddds)";
    private static final String SECTION_SELECTOR =
        "section.ddds:eq(1) > ul > li ";
    private final WebsiteClient websiteClient;
    private final CollectorProperties collectorProperties;

    public Set<StatesAreaCode> getAllStatesLinksFromPage() throws IOException {
        var urls = Arrays.asList(
            "https://www.codigosddd.com.br/acre",
            "https://www.codigosddd.com.br/alagoas"
        );

        Set<StatesAreaCode> responseDTOS = new HashSet<>();

        for (String url : urls) {
            extractDataFromAreaCode(responseDTOS, url);
        }
        return responseDTOS;
    }

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

        elements.forEach(element -> {
            StatesAreaCode saveStates = getStatesAreaCodes(element);
            responseDTOS.add(saveStates);
//            statesAreaCodeRepository.save(saveStates);
        });
        
        log.info("extract states using url={}", url);
    }

    private static StatesAreaCode getStatesAreaCodes(Element element) {
        var city = element.select("td:lt(1)").text();
        var codeArea = element.select("td:eq(1)").text();
        var states = element.select("td:eq(2)").text();
        var uf = element.select("td:eq(3)").text();
        return StatesAreaCode.builder()
            .city(city)
            .codeArea(codeArea)
            .states(states)
            .uf(uf)
            .build();
    }
}
