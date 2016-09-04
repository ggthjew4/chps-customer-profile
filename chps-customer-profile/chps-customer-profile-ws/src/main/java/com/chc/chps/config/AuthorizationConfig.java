package com.chc.chps.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		return new JwtAccessTokenConverter();
	}

	@Override
	public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')").checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')");
	}

	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).accessTokenConverter(accessTokenConverter());
	}

	@Override
	public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
					  .withClient("client-with-registered-redirect")
			          .authorizedGrantTypes("authorization_code")
			          .authorities("ROLE_CLIENT")
			          .scopes("read", "trust")
			          .resourceIds(ResourceConfig.RESOURCE_ID)
			          .refreshTokenValiditySeconds(20000000)
			          .redirectUris("https://tw.yahoo.com")
			          .secret("secret123")
		          .and()
			          .withClient("my-client-with-secret")
			          .authorizedGrantTypes("client_credentials", "password")
			          .authorities("ROLE_CLIENT")
			          .scopes("read")
			          .resourceIds(ResourceConfig.RESOURCE_ID)
			          .secret("secret")
			      .and()
				      .withClient("my-trusted-client")
			          .authorizedGrantTypes("implicit")
			          .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
			          .scopes("read", "write", "trust")
			          .accessTokenValiditySeconds(20000)
			          .refreshTokenValiditySeconds(20000)
			          .redirectUris("https://tw.yahoo.com");
	}

}
