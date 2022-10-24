package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.model.entites.RecipientEntity;
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
public class RecipientRepository implements JpaRepository<RecipientEntity, Long> {
    @Override
    public List<RecipientEntity> findAll() {
        return null;
    }

    @Override
    public List<RecipientEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<RecipientEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<RecipientEntity> findAllById(Iterable<Long> longs) {
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
    public void delete(RecipientEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends RecipientEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends RecipientEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends RecipientEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<RecipientEntity> findById(Long aLong) {
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
    public <S extends RecipientEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends RecipientEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<RecipientEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public RecipientEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public RecipientEntity getById(Long aLong) {
        return null;
    }

    @Override
    public RecipientEntity getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends RecipientEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends RecipientEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends RecipientEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends RecipientEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends RecipientEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends RecipientEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends RecipientEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
