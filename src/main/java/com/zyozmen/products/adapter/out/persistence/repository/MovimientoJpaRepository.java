package com.zyozmen.products.adapter.out.persistence.repository;

import com.zyozmen.products.adapter.out.persistence.entity.MovimientoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoJpaRepository extends JpaRepository<MovimientoJpaEntity, Long> {
}
