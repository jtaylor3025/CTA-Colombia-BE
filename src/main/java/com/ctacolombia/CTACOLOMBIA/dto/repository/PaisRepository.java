package com.ctacolombia.CTACOLOMBIA.dto.repository;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    boolean existsByPaisNombre(@NonNull String paisNombre);

}
