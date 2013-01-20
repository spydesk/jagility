/**
 * 
 */
package com.jagility.web.action.admin;

import java.net.URI;

import net.sourceforge.stripes.action.FileBean;

/**
 * @author sbarbey
 */
public class SettingsForm {

	private String gameName;
	private URI externalGameUrl;
	private FileBean gameLogo;
	private String gameClubName;

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public URI getExternalGameUrl() {
		return externalGameUrl;
	}

	public void setExternalGameUrl(URI externalGameUrl) {
		this.externalGameUrl = externalGameUrl;
	}

	public FileBean getGameLogo() {
		return gameLogo;
	}

	public void setGameLogo(FileBean gameLogo) {
		this.gameLogo = gameLogo;
	}

	public String getGameClubName() {
		return gameClubName;
	}

	public void setGameClubName(String gameClubName) {
		this.gameClubName = gameClubName;
	}

}
