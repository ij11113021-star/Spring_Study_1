package com.jutjoy.domain.profile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProfileEditForm {

    @NotEmpty(message = "＊名前は必ず入力してください。")
    @Size(max = 20, message = "＊名前は20文字以内で設定してください。")
    private String name;

    @NotEmpty(message = "＊どちらか選択してください。")
    private String gender;
    
    @Size(max = 20, message = "＊趣味は20文字以内で設定してください。")
    private String hobby;
    
    @Size(max = 20, message = "＊自己紹介は20文字以内で設定してください。")
    private String introduction;    
}
