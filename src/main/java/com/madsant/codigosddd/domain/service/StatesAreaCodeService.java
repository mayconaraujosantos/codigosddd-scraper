package com.madsant.codigosddd.domain.service;

import com.madsant.codigosddd.domain.model.StatesAreaCode;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

public interface StatesAreaCodeService {
    public void loadContents() throws MalformedURLException, IOException;

    public List<String> listStates();

    public Set<StatesAreaCode> listOfAreaCodeByState(String states);

    public List<StatesAreaCode> listOfAreaCodeByCity(String city);

    public List<StatesAreaCode> listOfAreaCodeByDDD(String ddd);
    
    public Set<StatesAreaCode> getAllStatesFromPage() throws IOException;
}
