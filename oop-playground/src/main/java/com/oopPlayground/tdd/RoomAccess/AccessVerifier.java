package com.oopPlayground.tdd.RoomAccess;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccessVerifier {
    private Map<DESIGNATION_TYPE, List<ROOM_TYPE>> permissionMap;

    public AccessVerifier() {
        permissionMap = new HashMap<DESIGNATION_TYPE, List<ROOM_TYPE>>();
        permissionMap.put(DESIGNATION_TYPE.STUDENT, Arrays.asList(ROOM_TYPE.CLASS_ROOM));
        permissionMap.put(DESIGNATION_TYPE.TEACHER, Arrays.asList(ROOM_TYPE.CLASS_ROOM, ROOM_TYPE.STAFF_ROOM));
        permissionMap.put(DESIGNATION_TYPE.PRINCIPAL, Arrays.asList(ROOM_TYPE.CLASS_ROOM, ROOM_TYPE.STAFF_ROOM, ROOM_TYPE.PRINCIPALS_ROOM));
    }

    public boolean verify(Person person, Room room) {
        return permissionMap.get(person.getDesignation()).contains(room.getRoomType());
    }
}
