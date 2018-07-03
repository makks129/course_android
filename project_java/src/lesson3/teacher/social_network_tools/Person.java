package lesson3.teacher.social_network_tools;

public class Person {

    private Profile profile; // first flatten profile, than suggest to group into Profile class
    private Person[] friends;
    private int numberOfFriends;
    private Feed feed; // first flatten feed (array of posts), than suggest to group into Feed class
    private Photo[] photos;
    private int numberOfPhotos;
    private Group[] groups;
    private int numberOfGroups;

    public void addFriend(Person person) {
        friends[numberOfFriends] = person;
        numberOfFriends++;
    }

    public void postToFeed(Post post) {
        feed.post(post);
    }

    public void inviteToGroup(Person person, Group group) {
        if (group.isAdmin(this)) {
            group.addParticipant(person);
        } else {
            System.out.println("Error: you are not an admin of group " + group.getGroupProfile().getName());
        }
    }

    public Group createGroup() {
        return new Group();
    }


}
