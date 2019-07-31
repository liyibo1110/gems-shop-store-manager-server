package com.liyibo1110.gemsshop.store.manager.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * @author liyibo
 *
 */
@ConfigurationProperties(prefix="app.custom")
public class EnvConfig {

	private boolean cronEnabled;
	private String uploadGoodImagePath;
	
	public boolean isCronEnabled() {
		return cronEnabled;
	}
	public void setCronEnabled(boolean cronEnabled) {
		this.cronEnabled = cronEnabled;
	}
	public String getUploadGoodImagePath() {
		return uploadGoodImagePath;
	}
	public void setUploadGoodImagePath(String uploadGoodImagePath) {
		this.uploadGoodImagePath = uploadGoodImagePath;
	}
}
