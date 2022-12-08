package com.madsant.codigosddd.domain.service;

import com.madsant.codigosddd.domain.model.StatesAreaCode;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.madsant.codigosddd.domain.repository.StatesAreaCodeRepository;
import com.madsant.codigosddd.scraper.collector.WebsiteContentParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatesAreaCodeServiceImpl implements StatesAreaCodeService {
    
    private final WebsiteContentParser websiteContentParser;
   
    
    @Override
    public void loadContents() throws MalformedURLException, IOException {}

    @Override
    public List<String> listStates() {
        return null;
    }

    @Override
    public Set<StatesAreaCode> listOfAreaCodeByState(String states) {
        Set<StatesAreaCode> respStatesAreaCodes = new HashSet<>();
        return respStatesAreaCodes;
    }

    @Override
    public List<StatesAreaCode> listOfAreaCodeByCity(String city) {
        return null;
    }

    @Override
    public List<StatesAreaCode> listOfAreaCodeByDDD(String ddd) {
        return null;
    }

    @Override
    public Set<StatesAreaCode> getAllStatesFromPage() throws IOException{
        return websiteContentParser.getAllStatesLinksFromPage();
    }
}
