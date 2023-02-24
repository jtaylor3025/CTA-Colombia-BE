package com.ctacolombia.CTACOLOMBIA.dto.repository;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Arl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArlRepository extends JpaRepository<Arl, Long> {

    Page<Arl> findByOrderByArlIdAsc(Pageable pageable);

    boolean existsByArlNombre(String arlNombre);

    Optional<Arl> findByArlId(Long arlId);

}
