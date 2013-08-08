package com.oopPlayground.tdd.RoomAccess;

public class RoomAccessController {

    CollegeDataProvider dataProvider;
    AccessVerifier verifier;

    public RoomAccessController(CollegeDataProvider dataProvider) {
        this.dataProvider = dataProvider;
        this.verifier = new AccessVerifier();
    }

    public boolean verifyAccess(String id, String accessScannerId) {
        Person person = getPersonBy(id);
        Room room = getRoomBy(accessScannerId);
        return verifyAccess(person, room);
    }

    private Person getPersonBy(String id) {
        return dataProvider.getPersonDetails(id);
    }

    private Room getRoomBy(String accessScannerId) {
        return dataProvider.getRoomDetails(accessScannerId);
    }

    private boolean verifyAccess(Person person, Room room) {
        if (person == null || room == null) {
            return false;
        }
        return verifier.verify(person, room);
    }
}

