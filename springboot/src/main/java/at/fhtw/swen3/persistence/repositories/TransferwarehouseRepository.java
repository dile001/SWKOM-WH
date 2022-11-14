package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
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
public class TransferwarehouseRepository implements JpaRepository<TransferwarehouseEntity, Long> {
    @Override
    public List<TransferwarehouseEntity> findAll() {
        return null;
    }

    @Override
    public List<TransferwarehouseEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TransferwarehouseEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<TransferwarehouseEntity> findAllById(Iterable<Long> longs) {
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
    public void delete(TransferwarehouseEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends TransferwarehouseEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends TransferwarehouseEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TransferwarehouseEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<TransferwarehouseEntity> findById(Long aLong) {
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
    public <S extends TransferwarehouseEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends TransferwarehouseEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<TransferwarehouseEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TransferwarehouseEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public TransferwarehouseEntity getById(Long aLong) {
        return null;
    }

    @Override
    public TransferwarehouseEntity getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends TransferwarehouseEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TransferwarehouseEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TransferwarehouseEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends TransferwarehouseEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TransferwarehouseEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TransferwarehouseEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends TransferwarehouseEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
