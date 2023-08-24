package com.example.Waivers.Repositories;

import com.example.Waivers.Entities.Waivertype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface WaivertypeRepository extends JpaRepository<Waivertype, Long> {


}
