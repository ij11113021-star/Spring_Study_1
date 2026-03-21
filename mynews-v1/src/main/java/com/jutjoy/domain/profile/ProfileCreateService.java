package com.jutjoy.domain.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProfileCreateService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile createProfile(ProfileCreateForm form) {

        Profile entity = new Profile();
        entity.setName(form.getName());
        entity.setGender(form.getGender());
        entity.setHobby(form.getHobby());
        entity.setIntroduction(form.getIntroduction());

        return profileRepository.save(entity);
    }
}
