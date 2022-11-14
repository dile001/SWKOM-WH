package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.TrackingInformationEntity;
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
public class TrackingInformationRepository implements JpaRepository<TrackingInformationEntity, Long> {
    @Override
    public List<TrackingInformationEntity> findAll() {
        return null;
    }

    @Override
    public List<TrackingInformationEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TrackingInformationEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<TrackingInformationEntity> findAllById(Iterable<Long> longs) {
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
    public void delete(TrackingInformationEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends TrackingInformationEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends TrackingInformationEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TrackingInformationEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<TrackingInformationEntity> findById(Long aLong) {
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
    public <S extends TrackingInformationEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends TrackingInformationEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<TrackingInformationEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TrackingInformationEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public TrackingInformationEntity getById(Long aLong) {
        return null;
    }

    @Override
    public TrackingInformationEntity getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends TrackingInformationEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TrackingInformationEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TrackingInformationEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends TrackingInformationEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TrackingInformationEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TrackingInformationEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends TrackingInformationEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
