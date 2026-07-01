package com.zyozmen.products.adapter.out.persistence;

import com.zyozmen.products.adapter.out.persistence.mapper.MovimientoPersistenceMapper;
import com.zyozmen.products.adapter.out.persistence.repository.MovimientoJpaRepository;
import com.zyozmen.products.domain.model.Movimiento;
import com.zyozmen.products.domain.port.out.MovimientoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MovimientoRepositoryAdapter implements MovimientoRepositoryPort {

    private final MovimientoJpaRepository jpaRepository;
    private final MovimientoPersistenceMapper mapper;

    @Override
    public List<Movimiento> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Movimiento> findById(Long movimientoId) {
        return jpaRepository.findById(movimientoId).map(mapper::toDomain);
    }

    @Override
    public Movimiento save(Movimiento movimiento) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(movimiento)));
    }

    @Override
    public boolean existsById(Long movimientoId) {
        return jpaRepository.existsById(movimientoId);
    }

    @Override
    public void deleteById(Long movimientoId) {
        jpaRepository.deleteById(movimientoId);
    }
}
