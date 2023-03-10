package com.Fashion.portfolio.domain.common_project.values;

import com.Fashion.portfolio.generic.ValueObject;

public class MediaContent extends Content implements ValueObject<MediaContent.Props> {

    private final String mediaURL;

    public MediaContent(String title, String description, String author, String mediaURL) {
        super(title, description, author);
        this.mediaURL = mediaURL;
    }

    private MediaContent(String title, String description, String author, String mediaURL, Boolean isPublic) {
        super(title, description, author, isPublic);
        this.mediaURL = mediaURL;
    }

    @Override
    public MediaContent publish() {
        return new MediaContent(this.title, this.description, this.author, this.mediaURL, true);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String title() {
                return title;
            }

            @Override
            public String description() {
                return description;
            }

            @Override
            public String author() {
                return author;
            }

            @Override
            public Boolean isPublic() {
                return isPublic;
            }

            @Override
            public String mediaURL() {
                return mediaURL;
            }
        };
    }

    public interface Props{
        String title();
        String description();
        String author();
        Boolean isPublic();
        String mediaURL();
    }

}
