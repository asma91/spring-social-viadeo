package com.viadeo.social.api.impl.json;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;

import com.viadeo.social.api.Career;
import com.viadeo.social.api.Comment;
import com.viadeo.social.api.Experience;
import com.viadeo.social.api.Job;
import com.viadeo.social.api.News;
import com.viadeo.social.api.ViadeoProfile;
import com.viadeo.social.api.impl.Comments;
import com.viadeo.social.api.impl.Contacts;
import com.viadeo.social.api.impl.Feed;
import com.viadeo.social.api.impl.JobsResult;

/**
 * Jackson module for setting up mixin annotations on Viadeo model types. This
 * enables the use of Jackson annotations without directly annotating the model
 * classes themselves.
 */
public class ViadeoModule extends SimpleModule {

	public ViadeoModule() {
		super("ViadeoModule", new Version(1, 0, 0, null));
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(ViadeoProfile.class,
				ViadeoProfileMixin.class);
		context.setMixInAnnotations(Contacts.class,
				ContactsMixin.class);
		context.setMixInAnnotations(Feed.class,
				FeedMixin.class);
		context.setMixInAnnotations(News.class,
				NewsMixin.class);
		context.setMixInAnnotations(Experience.class,
				ExperienceMixin.class);
		context.setMixInAnnotations(Career.class,
				CareerMixin.class);
		context.setMixInAnnotations(Comment.class,
				CommentMixin.class);
		context.setMixInAnnotations(Comments.class,
				CommentsMixin.class);
		context.setMixInAnnotations(Job.class,
				JobMixin.class);
		context.setMixInAnnotations(JobsResult.class,
				JobsResultMixin.class);
	}
}
