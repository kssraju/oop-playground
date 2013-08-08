package com.oopPlayground.tdd.RoomAccess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.BDDMockito.*;

public class RoomAccessSpec {

    private RoomAccessController controller;
    private CollegeDataProvider dataProvider;

    private static Person student;
    private static Person teacher;
    private static Person principal;
    private static Room classRoom;
    private static Room staffRoom;
    private static Room principalRoom;

    @BeforeClass
    public static void initialize() {
        student = new Person();
        student.setDesignation(DESIGNATION_TYPE.STUDENT);

        teacher = new Person();
        teacher.setDesignation(DESIGNATION_TYPE.TEACHER);

        principal = new Person();
        principal.setDesignation(DESIGNATION_TYPE.PRINCIPAL);

        classRoom = new Room();
        classRoom.setRoomType(ROOM_TYPE.CLASS_ROOM);

        staffRoom = new Room();
        staffRoom.setRoomType(ROOM_TYPE.STAFF_ROOM);

        principalRoom = new Room();
        principalRoom.setRoomType(ROOM_TYPE.PRINCIPALS_ROOM);
    }

    @Before
    public void setup() {
        dataProvider = mock(CollegeDataProvider.class);
        controller = new RoomAccessController(dataProvider);
    }

    @Test
    public void shouldGrantAccessToStudentIfClassRoom() {
        String id = "student";
        String accessScannerId = "classRoom";
        given(dataProvider.getPersonDetails(id)).willReturn(student);
        given(dataProvider.getRoomDetails(accessScannerId)).willReturn(classRoom);

        boolean isAccessGranted = controller.verifyAccess(id, accessScannerId);

        Assert.assertTrue(isAccessGranted);
    }

    @Test
    public void shouldGrantAccessToTeacherIfStaffRoom() {
        String id = "teacher";
        String accessScannerId = "staffRoom";
        given(dataProvider.getPersonDetails(id)).willReturn(teacher);
        given(dataProvider.getRoomDetails(accessScannerId)).willReturn(staffRoom);

        boolean isAccessGranted = controller.verifyAccess(id, accessScannerId);

        Assert.assertTrue(isAccessGranted);
    }

    @Test
    public void shouldRejectAccessToStudentIfStaffRoom() {
        String id = "student";
        String accessScannerId = "staffRoom";
        given(dataProvider.getPersonDetails(id)).willReturn(student);
        given(dataProvider.getRoomDetails(accessScannerId)).willReturn(staffRoom);

        boolean isAccessGranted = controller.verifyAccess(id, accessScannerId);

        Assert.assertFalse(isAccessGranted);
    }

    @Test
    public void shouldGrantAccessToPrincipalIfPrincipalsRoom() {
        String id = "principal";
        String accessScannerId = "principalRoom";
        given(dataProvider.getPersonDetails(id)).willReturn(principal);
        given(dataProvider.getRoomDetails(accessScannerId)).willReturn(principalRoom);

        boolean isAccessGranted = controller.verifyAccess(id, accessScannerId);

        Assert.assertTrue(isAccessGranted);
    }

    @Test
    public void shouldRejectAccessToTeacherIfPrincipalsRoom() {
        String id = "teacher";
        String accessScannerId = "principalRoom";
        given(dataProvider.getPersonDetails(id)).willReturn(teacher);
        given(dataProvider.getRoomDetails(accessScannerId)).willReturn(principalRoom);

        boolean isAccessGranted = controller.verifyAccess(id, accessScannerId);

        Assert.assertFalse(isAccessGranted);
    }

    @Test
    public void shouldRejectAccessToStudentIfPrincipalsRoom() {
        String id = "student";
        String accessScannerId = "principalRoom";
        given(dataProvider.getPersonDetails(id)).willReturn(student);
        given(dataProvider.getRoomDetails(accessScannerId)).willReturn(principalRoom);

        boolean isAccessGranted = controller.verifyAccess(id, accessScannerId);

        Assert.assertFalse(isAccessGranted);
    }
}
