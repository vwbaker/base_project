package base;

public class SignedOnUser {
   private Long userId;
   private String name;
   private String contact;

   private Post[] posts;

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public Post[] getPosts() {
        return posts;
    }
}
