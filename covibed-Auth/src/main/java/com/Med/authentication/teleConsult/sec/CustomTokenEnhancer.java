package com.Med.authentication.teleConsult.sec;


import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.client.RestTemplate;

import com.Med.authentication.teleConsult.dao.IActivitesLogoutDao;
import com.Med.authentication.teleConsult.dao.UserRepository;
import com.Med.authentication.teleConsult.model.ActivitesLogout;
import com.Med.authentication.teleConsult.model.Role;
import com.Med.authentication.teleConsult.model.User;



public class CustomTokenEnhancer extends JwtAccessTokenConverter {
@Autowired
IActivitesLogoutDao logDao;
@Autowired
 UserRepository userDao;
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        Map<String, Object> info = new LinkedHashMap<String, Object>(accessToken.getAdditionalInformation());

        info.put("email", user.getEmail());
        info.put("roles", user.getRoles());

        DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
        customAccessToken.setAdditionalInformation(info);
        user.setStatus("En ligne");
        user.setConnect(true);
        userDao.save(user);
        ActivitesLogout activite = new ActivitesLogout();
        activite.setDate((java.sql.Date) new Date(System.currentTimeMillis()));
        activite.setType("logIn");
        activite.setUsername(user.getUsername());
        logDao.save(activite);





        return super.enhance(customAccessToken, authentication);
    }
}