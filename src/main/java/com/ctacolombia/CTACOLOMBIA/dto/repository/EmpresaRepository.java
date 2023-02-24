package com.ctacolombia.CTACOLOMBIA.dto.repository;

import com.ctacolombia.CTACOLOMBIA.dto.entity.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {

    Page<Empresa> findByOrderByEmpresaNombreAsc(Pageable pageable);

    boolean existsByEmpresaNit(String empresaNit);


}
