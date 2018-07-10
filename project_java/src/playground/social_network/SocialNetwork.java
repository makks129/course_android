package playground.social_network;

import playground.social_network.model.Group;
import playground.social_network.model.Person;

public class SocialNetwork {

    public static void main(String[] args) {

        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

        // Create groups here first but them suggest that only people can create groups

        p1.addFriend(p2);
        p2.addFriend(p3);
        p3.addFriend(p1);

        Group g1 = p1.createGroup();
        p1.inviteToGroup(p2, g1);

    }

}
