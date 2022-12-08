package com.madsant.codigosddd.rest;

import com.madsant.codigosddd.domain.model.StatesAreaCode;
import com.madsant.codigosddd.domain.service.StatesAreaCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/area-code")
public class StatesAreaCodeController {

    @Autowired
    private StatesAreaCodeService statesAreaCodeService;

    @GetMapping(path = "/{states}")
    public Set<StatesAreaCode> findAllStatesLinks(@PathVariable String states) {
        return statesAreaCodeService.listOfAreaCodeByState(states);
    }

    @GetMapping()
    public Set<StatesAreaCode> findAllStates() {
        try {
            return statesAreaCodeService.getAllStatesFromPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
