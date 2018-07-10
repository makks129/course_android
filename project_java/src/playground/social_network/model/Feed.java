package playground.social_network.model;

public class Feed {

    private Post[] posts;
    private int numberOfPosts;

    public void post(Post post) {
        posts[numberOfPosts] = post;
        numberOfPosts++;
    }

}
