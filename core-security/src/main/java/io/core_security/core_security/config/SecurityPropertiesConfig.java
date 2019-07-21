package io.core_security.core_security.config;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("security")
@RefreshScope
public class SecurityPropertiesConfig {

	private JwtConfig jwt = new JwtConfig();
	private List<String> whitelist = new LinkedList<>();

	public JwtConfig getJwt() {
		return jwt;
	}

	public void setJwt(JwtConfig jwt) {
		this.jwt = jwt;
	}

	public List<String> getWhitelist() {
		return whitelist;
	}

	public void setWhitelist(List<String> whitelist) {
		this.whitelist = whitelist;
	}

}