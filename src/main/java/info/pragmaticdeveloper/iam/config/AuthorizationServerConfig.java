package info.pragmaticdeveloper.iam.config;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private KeyPair keyPair;

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("first")
                .secret(passwordEncoder().encode("secret"))
                .scopes("read")
                .authorizedGrantTypes("password")
                .and()
                .withClient("sec")
                .secret(passwordEncoder().encode("secret"))
                .scopes("read")
                .authorizedGrantTypes("password")
                .and()
                .withClient("first-client")
                .secret(passwordEncoder().encode("noonewilleverguess"))
                .scopes("resource:read")
                .authorizedGrantTypes("authorization_code", "password")
                .redirectUris("http://localhost:8081/api/v1/oauth/login/client-app");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        // @formatter:off
		endpoints
			.authenticationManager(this.authenticationManager)
			.accessTokenConverter(accessTokenConverter())
			.tokenStore(tokenStore());
		// @formatter:on
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(this.keyPair);
        return converter;
    }

    @Bean
    public KeyPair keyPairBean() throws NoSuchAlgorithmException {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(2048);
        KeyPair keyPair = gen.generateKeyPair();
        return keyPair;
    }
}*/
