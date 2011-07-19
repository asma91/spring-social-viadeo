package com.viadeo.social.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.web.client.HttpClientErrorException;

import com.viadeo.social.api.Viadeo;
import com.viadeo.social.api.ViadeoProfile;

public class ViadeoApiAdapter implements ApiAdapter<Viadeo> {

	public boolean test(Viadeo viadeo) {
		try {
			viadeo.userOperations().getUserProfile();
			return true;
		} catch (HttpClientErrorException e) {
			return false;
		}
	}

	public void setConnectionValues(Viadeo viadeo, ConnectionValues values) {
		ViadeoProfile profile = viadeo.userOperations().getUserProfile();
		values.setProviderUserId(profile.getId());
		values.setDisplayName(profile.getFirstName() + " "
				+ profile.getLastName());
		values.setImageUrl(profile.getLargeImageUrl());
		values.setProfileUrl(profile.getProfileUrl());
	}

	public UserProfile fetchUserProfile(Viadeo viadeo) {
		ViadeoProfile profile = viadeo.userOperations().getUserProfile();
		return new UserProfileBuilder().setName(
				profile.getFirstName() + " " + profile.getLastName())
				.setFirstName(profile.getFirstName()).setLastName(
						profile.getLastName()).setUsername(
						profile.getNickName()).build();
	}

	public void updateStatus(Viadeo viadeo, String message) {
		// not supported yet
	}
}
