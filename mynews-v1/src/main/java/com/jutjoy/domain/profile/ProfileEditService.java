package com.jutjoy.domain.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class ProfileEditService {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProfileHistoriesRepository profileHistoriesRepository;
    
    private void registerHistory(Integer id) {
        ProfileHistories entity = new ProfileHistories();
        entity.setProfileId(id);
        profileHistoriesRepository.save(entity);
    }

    public void edit(int id, ProfileEditForm form) {

        Profile entity = profileRepository.findById(id).get();

        // プロフィール更新処理
        editProfile(entity, form);
        
     // プロフィール編集履歴登録
        registerHistory(entity.getId());

    }

    public Profile findProfile(int id) {

        // プロフィール、編集履歴参照
        Profile profile = profileRepository.findById(id).get();
        return profile;
    }

    private Profile editProfile(Profile entity, ProfileEditForm form) {

        entity.setName(form.getName());
        entity.setGender(form.getGender());
        entity.setHobby(form.getHobby());
        entity.setIntroduction(form.getIntroduction());
                
        return profileRepository.save(entity);
    }
}
