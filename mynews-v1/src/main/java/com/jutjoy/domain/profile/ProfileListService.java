package com.jutjoy.domain.profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProfileListService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> list() {

        List<Profile> profileList = new ArrayList<>();
        // 一覧取得
        profileList = profileRepository.findAllByOrderById();

        return profileList;
    }
    
    public List<Profile> list(String name) {

        List<Profile> profileList = new ArrayList<>();

        if (Objects.isNull(name) || name.isEmpty()) {
            // 一覧取得
            profileList = profileRepository.findAllByOrderById();
        } else {
            // 検索
            profileList = profileRepository.findByNameLike(createLikeParam(name));
        }

        return profileList;
    }

    private String createLikeParam(String param) {
        return "%" + param + "%";
    }
}
