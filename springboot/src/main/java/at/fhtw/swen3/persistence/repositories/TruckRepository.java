package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
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
public class TruckRepository implements JpaRepository<TruckEntity, Long> {
    @Override
    public List<TruckEntity> findAll() {
        return null;
    }

    @Override
    public List<TruckEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TruckEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<TruckEntity> findAllById(Iterable<Long> longs) {
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
    public void delete(TruckEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends TruckEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends TruckEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TruckEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<TruckEntity> findById(Long aLong) {
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
    public <S extends TruckEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends TruckEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<TruckEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TruckEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public TruckEntity getById(Long aLong) {
        return null;
    }

    @Override
    public TruckEntity getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends TruckEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TruckEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TruckEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends TruckEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TruckEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TruckEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends TruckEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
