package com.main.repository;

import com.main.model.TipoColegio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoColegioRepository extends JpaRepository<TipoColegio, Long> {
}
