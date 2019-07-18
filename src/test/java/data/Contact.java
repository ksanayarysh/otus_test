package data;

import java.util.Objects;

public class Contact {
    private String socialName;
    private String socialLink;

    public Contact(String socialName, String socialLink) {
        this.socialName = socialName;
        this.socialLink = socialLink;
    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public String getSocialLink() {
        return socialLink;
    }

    public void setSocialLink(String socialLink) {
        this.socialLink = socialLink;
    }

    @Override
    public String toString() {
        return String.format("%s:%s", socialName, socialLink);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return socialName.equals(contact.socialName) &&
                socialLink.equals(contact.socialLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socialName, socialLink);
    }
}
