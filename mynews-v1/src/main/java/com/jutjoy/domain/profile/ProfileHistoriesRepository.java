package com.jutjoy.domain.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileHistoriesRepository extends JpaRepository<ProfileHistories, Integer> {
}