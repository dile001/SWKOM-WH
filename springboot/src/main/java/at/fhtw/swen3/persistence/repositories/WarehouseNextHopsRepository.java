package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class WarehouseNextHopsRepository implements JpaRepository<WarehouseEntity, Long> {
    @Override
    public List<WarehouseEntity> findAll() {
        return null;
    }

    @Override
    public List<WarehouseEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<WarehouseEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<WarehouseEntity> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(WarehouseEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends WarehouseEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends WarehouseEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends WarehouseEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<WarehouseEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends WarehouseEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends WarehouseEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<WarehouseEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public WarehouseEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public WarehouseEntity getById(Long aLong) {
        return null;
    }

    @Override
    public WarehouseEntity getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends WarehouseEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends WarehouseEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends WarehouseEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends WarehouseEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends WarehouseEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends WarehouseEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends WarehouseEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
