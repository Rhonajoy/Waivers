package com.example.Waivers.Repositories;

import com.example.Waivers.Entities.Waivers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface WaiverRepository extends JpaRepository<Waivers, Long> {
//    List<Waivers> findByWaiverTypeId(Long waiverTypeId);
}
