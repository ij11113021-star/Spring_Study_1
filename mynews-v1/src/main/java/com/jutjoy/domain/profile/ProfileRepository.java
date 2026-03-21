package com.jutjoy.domain.profile;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	public List<Profile> findAllByOrderById();
	public List<Profile> findByNameLike(String name);
}
