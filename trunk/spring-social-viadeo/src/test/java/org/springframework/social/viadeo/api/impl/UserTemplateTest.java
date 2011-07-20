package org.springframework.social.viadeo.api.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.body;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.util.List;

import org.junit.Test;
import org.springframework.social.ApiException;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.support.URIBuilder;
import org.springframework.social.viadeo.api.Experience;
import org.springframework.social.viadeo.api.News;
import org.springframework.social.viadeo.api.ViadeoProfile;

public class UserTemplateTest extends AbstractViadeoApiTest {

	@Test
	public void getCurrentUser() {
		mockServer.expect(requestTo("https://api.viadeo.com/me")).andExpect(
				method(GET)).andRespond(
				withResponse(jsonResource("testdata/full-profile-me"),
						responseHeaders));

		ViadeoProfile profile = viadeo.userOperations().getUserProfile();
		assertEquals("EjtftevbyiugaIfDfVizDgymxg", profile.getId());
		assertEquals("M", profile.getGender());
		assertEquals("Vincent", profile.getFirstName());
		assertEquals("DEVILLERS", profile.getLastName());
		assertEquals("vincent.devillers1", profile.getNickName());
		assertEquals("http://www.viadeo.com/profile/0021g557w9j1iw4m", profile
				.getProfileUrl());
		assertEquals(Long.valueOf(146), profile.getContactCount());
		assertEquals(
				"Karaté (2ème Dan), piano, natation, apnée libre, robotique",
				profile.getInterests());
		assertEquals("Ingénieur d'études et de développement, Viadeo", profile
				.getHeadline());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void getCurrentUser_unauthorized() {
		unauthorizedViadeo.userOperations().getUserProfile();
	}

	@Test
	public void getUserProfileById() {
		mockServer.expect(
				requestTo("https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg"))
				.andExpect(method(GET)).andRespond(
						withResponse(
								jsonResource("testdata/full-profile-by-id"),
								responseHeaders));

		ViadeoProfile profile = viadeo.userOperations().getUserProfile(
				"EjtftevbyiugaIfDfVizDgymxg");
		assertEquals("EjtftevbyiugaIfDfVizDgymxg", profile.getId());
		assertEquals("M", profile.getGender());
		assertEquals("Vincent", profile.getFirstName());
		assertEquals("DEVILLERS", profile.getLastName());
		assertEquals("vincent.devillers1", profile.getNickName());
		assertEquals("http://www.viadeo.com/profile/0021g557w9j1iw4m", profile
				.getProfileUrl());
		assertEquals(Long.valueOf(146), profile.getContactCount());
		assertEquals(
				"Karaté (2ème Dan), piano, natation, apnée libre, robotique",
				profile.getInterests());
		assertEquals("Ingénieur d'études et de développement, Viadeo", profile
				.getHeadline());
		mockServer.verify();
	}

	@Test
	public void getCurrentContacts() {
		mockServer.expect(
				requestTo(URIBuilder.fromUri(
						"https://api.viadeo.com/me/contacts?user_detail=full")
						.build())).andExpect(method(GET)).andRespond(
				withResponse(jsonResource("testdata/full-contacts-for-me"),
						responseHeaders));

		List<ViadeoProfile> contacts = viadeo.userOperations().getContacts();
		assertNotNull(contacts);
		assertEquals(10, contacts.size());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void getCurrentContacts_unauthorized() {
		unauthorizedViadeo.userOperations().getContacts();
	}

	@Test
	public void getContactsForId() {
		mockServer
				.expect(
						requestTo(URIBuilder
								.fromUri(
										"https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg/contacts?user_detail=full")
								.build())).andExpect(method(GET)).andRespond(
						withResponse(
								jsonResource("testdata/full-contacts-for-id"),
								responseHeaders));

		List<ViadeoProfile> contacts = viadeo.userOperations().getContacts(
				"EjtftevbyiugaIfDfVizDgymxg");
		assertNotNull(contacts);
		assertEquals(10, contacts.size());
		mockServer.verify();
	}

	@Test
	public void getCurrentNewsFeed() {
		mockServer
				.expect(
						requestTo(URIBuilder
								.fromUri(
										"https://api.viadeo.com/me/home_newsfeed?user_detail=full&limit=50")
								.build()))
				.andExpect(method(GET))
				.andRespond(
						withResponse(
								jsonResource("testdata/full-home_newsfeed-for-me"),
								responseHeaders));

		List<News> news = viadeo.userOperations().getNewsFeed();
		assertNotNull(news);
		assertEquals(10, news.size());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void getCurrentNewsFeed_unauthorized() {
		unauthorizedViadeo.userOperations().getNewsFeed();
	}

	@Test
	public void getNewsFeedForId() {
		mockServer
				.expect(
						requestTo(URIBuilder
								.fromUri(
										"https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg/home_newsfeed?user_detail=full&limit=50")
								.build()))
				.andExpect(method(GET))
				.andRespond(
						withResponse(
								jsonResource("testdata/full-home_newsfeed-for-id"),
								responseHeaders));

		List<News> news = viadeo.userOperations().getNewsFeed(
				"EjtftevbyiugaIfDfVizDgymxg");
		assertNotNull(news);
		assertEquals(10, news.size());
		mockServer.verify();
	}

	@Test
	public void getCurrentExperiences() {
		mockServer.expect(
				requestTo(URIBuilder.fromUri(
						"https://api.viadeo.com/me/career?user_detail=full")
						.build())).andExpect(method(GET)).andRespond(
				withResponse(jsonResource("testdata/career-for-me"),
						responseHeaders));

		List<Experience> experiences = viadeo.userOperations().getExperiences();
		assertNotNull(experiences);
		assertEquals(6, experiences.size());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void getCurrentExperiences_unauthorized() {
		unauthorizedViadeo.userOperations().getExperiences();
	}

	@Test
	public void getExperiencesForId() {
		mockServer
				.expect(
						requestTo(URIBuilder
								.fromUri(
										"https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg/career?user_detail=full")
								.build())).andExpect(method(GET)).andRespond(
						withResponse(jsonResource("testdata/career-for-id"),
								responseHeaders));

		List<Experience> experiences = viadeo.userOperations().getExperiences(
				"EjtftevbyiugaIfDfVizDgymxg");
		assertNotNull(experiences);
		assertEquals(6, experiences.size());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void updateStatus_unauthorized() {
		unauthorizedViadeo.userOperations().updateStatus("Mon nouveau status");
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateStatus_statusTooLong() {
		viadeo
				.userOperations()
				.updateStatus(
						"Veeeeeeeeeeeeeeeeeeeeeerrrrrrrrrrryyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy" +
						" looooooooooooooooooooooooooooonnnnnnnnnnnnngggggg " +
						"staaaaaaaaatuuuuuuuuuuuuuuuuuusssssssssssss");
	}
	
	@Test
	public void updateStatus() {
		mockServer
				.expect(
						requestTo(URIBuilder
								.fromUri(
										"https://api.viadeo.com/status")
								.build())).andExpect(method(POST)).andExpect(body("message=Mon+nouveau+status"))
								.andRespond(withResponse("STATUS SENT", responseHeaders));

		viadeo.userOperations().updateStatus("Mon nouveau status");
		mockServer.verify();
	}
	
	@Test(expected = NotAuthorizedException.class)
	public void search_unauthorized() {
		unauthorizedViadeo.userOperations().search("Vincent DEVILLERS");
	}
	
	@Test
	public void search() {
		mockServer.expect(
				requestTo(URIBuilder.fromUri(
						"https://api.viadeo.com/search/users?user_detail=full&keyword=Vincent+DEVILLERS&limit=50")
						.build())).andExpect(method(GET)).andRespond(
				withResponse(jsonResource("testdata/search-contacts"),
						responseHeaders));

		List<ViadeoProfile> contacts = viadeo.userOperations().search("Vincent DEVILLERS");
		assertNotNull(contacts);
		assertEquals(50, contacts.size());
		mockServer.verify();
	}
}
