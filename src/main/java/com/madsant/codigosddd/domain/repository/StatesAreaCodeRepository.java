package com.madsant.codigosddd.domain.repository;

import com.madsant.codigosddd.domain.model.StatesAreaCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatesAreaCodeRepository
  extends MongoRepository<StatesAreaCode, String> {}
