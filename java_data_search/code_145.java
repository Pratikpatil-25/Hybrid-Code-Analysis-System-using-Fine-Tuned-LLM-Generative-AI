package io.github.erp.service;



import io.github.erp.service.dto.CountyCodeDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CountyCodeService {
    
    CountyCodeDTO save(CountyCodeDTO countyCodeDTO);

    
    Optional<CountyCodeDTO> partialUpdate(CountyCodeDTO countyCodeDTO);

    
    Page<CountyCodeDTO> findAll(Pageable pageable);

    
    Page<CountyCodeDTO> findAllWithEagerRelationships(Pageable pageable);

    
    Optional<CountyCodeDTO> findOne(Long id);

    
    void delete(Long id);

    
    Page<CountyCodeDTO> search(String query, Pageable pageable);
}