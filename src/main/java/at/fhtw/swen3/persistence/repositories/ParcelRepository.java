package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParcelRepository extends JpaRepository<ParcelEntity, Long> {

    List<ParcelEntity> findByTrackingId(String trackingId);

    @Query(value = "SELECT tracking_id FROM parcel WHERE tracking_id = ?1", nativeQuery = true)
    Optional<String> doesTrackingIdExist(String trackingId);
}
