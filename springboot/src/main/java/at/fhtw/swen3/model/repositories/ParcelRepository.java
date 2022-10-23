package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.model.entites.ParcelEntity;
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
public class ParcelRepository implements JpaRepository<ParcelEntity, Long> {
    @Override
    public List<ParcelEntity> findAll() {
        return null;
    }

    @Override
    public List<ParcelEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ParcelEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ParcelEntity> findAllById(Iterable<Long> longs) {
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
    public void delete(ParcelEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends ParcelEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ParcelEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ParcelEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ParcelEntity> findById(Long aLong) {
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
    public <S extends ParcelEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ParcelEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ParcelEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ParcelEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public ParcelEntity getById(Long aLong) {
        return null;
    }

    @Override
    public ParcelEntity getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends ParcelEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ParcelEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ParcelEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ParcelEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ParcelEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ParcelEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ParcelEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
