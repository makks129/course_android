package lesson3.teacher.social_network_tools;

public class Feed {

    private Post[] posts;
    private int numberOfPosts;

    public void post(Post post) {
        posts[numberOfPosts] = post;
        numberOfPosts++;
    }

}
