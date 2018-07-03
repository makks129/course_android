package lesson3.teacher.social_network_tools;

public class Group {

    private GroupProfile groupProfile;
    private Person admin;
    private Person[] participants;
    private int numberOfParticipants;

    public Person getAdmin() {
        return admin;
    }

    public GroupProfile getGroupProfile() {
        return groupProfile;
    }

    public boolean isAdmin(Person person) {
        return admin.equals(person);
    }

    void addParticipant(Person person) { // create public at first but then suggest that only people can invite other people
        participants[numberOfParticipants] = person;
        numberOfParticipants++;
    }
}
