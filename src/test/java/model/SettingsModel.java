package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettingsModel {

    public String baseUrl;
    public LoginData loginData;
}
