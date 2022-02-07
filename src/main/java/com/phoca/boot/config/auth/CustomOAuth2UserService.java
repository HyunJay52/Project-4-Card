package com.phoca.boot.config.auth;

import com.phoca.boot.config.auth.dto.OAuthAttributes;
import com.phoca.boot.config.auth.dto.SessionUser;
import com.phoca.boot.domain.guest.User;
import com.phoca.boot.domain.guest.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        //registrationId - 현재 로그인 진행 중인 서비스 구분하는 코드, 이후에 여라기 추가할때 네이버인지 구글인지 구분
        String registrationId =userRequest.getClientRegistration().getRegistrationId();

        //userNameAttributeName - OAuth2 로그인 시 키가 되는 필드값(PK), 구글 기본 코드=sub/네이버 카카오 등은 지원 안함, 네이버/구글 동시 로그인 지원 시 사용
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        //OAuthAttributes - OAuth2UserService를 통해 가져온 OAuth2User의 attribute, 다른 소셜 로그인도 이 클래스를 사용
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
        User user = saveOrUpdate(attributes);

        //SesstionUser - 세션에 사용자 정보를 저장하기 위한 dto 클래스, user 클래스를 사용하지 않고 새로 만듬
        httpSession.setAttribute("user", new SessionUser(user));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey()
        );
    }

    private User saveOrUpdate(OAuthAttributes attributes) {
        User user = userRepository.findByEmail(attributes.getEmail())
              //  .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());

        return userRepository.save(user);
    }
}
