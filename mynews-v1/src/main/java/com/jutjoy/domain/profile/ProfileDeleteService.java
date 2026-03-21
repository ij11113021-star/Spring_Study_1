package com.jutjoy.domain.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProfileDeleteService {

    @Autowired
    private ProfileRepository profileRepository;

    public void delete(Integer id) {

        // ニュース削除処理
        profileRepository.deleteById(id);

        
    }
}
