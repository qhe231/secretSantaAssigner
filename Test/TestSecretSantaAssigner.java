import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestSecretSantaAssigner {
    SecretSantaAssigner assigner;
    List<StaffMember> staffMembers;
    StaffMember staff1;
    StaffMember staff2;
    StaffMember staff3;
    StaffMember staff4;
    StaffMember staff5;

    @Before
    public void setUp() {
        assigner = new SecretSantaAssigner();
        staff1 = new StaffMember("1", "Jon Snow", "jons@got.com");
        staff2 = new StaffMember("2", "Tyrion Lannister", "tyrionl@got.com");
        staff3 = new StaffMember("3", "Bran Stark", "brans@got.com");
        staff4 = new StaffMember("4", "Theon Greyjoy", "thoeng@got.com");
        staff5 = new StaffMember("5", "Renly Baratheon", "renlyb@got.com");
        staffMembers = new ArrayList<>();

        staffMembers.add(staff1);
        staffMembers.add(staff2);
        staffMembers.add(staff3);
        staffMembers.add(staff4);
        staffMembers.add(staff5);
    }

    @Test
    public void testAssigner() {
        assigner.assignSecretSanta(staffMembers);

        //Everyone will buy a gift for and receive a gift from someone.
        assertNotNull(staff1.getBuyGiftFor());
        assertNotNull(staff1.getReceiveGiftFrom());
        assertNotNull(staff2.getBuyGiftFor());
        assertNotNull(staff2.getReceiveGiftFrom());
        assertNotNull(staff3.getBuyGiftFor());
        assertNotNull(staff3.getReceiveGiftFrom());
        assertNotNull(staff4.getBuyGiftFor());
        assertNotNull(staff4.getReceiveGiftFrom());
        assertNotNull(staff5.getBuyGiftFor());
        assertNotNull(staff5.getReceiveGiftFrom());

        //If A will buy a gift for B, B will receive a gift from A
        assertEquals(staff1, staff1.getBuyGiftFor().getReceiveGiftFrom());
        assertEquals(staff2, staff2.getBuyGiftFor().getReceiveGiftFrom());
        assertEquals(staff3, staff3.getBuyGiftFor().getReceiveGiftFrom());
        assertEquals(staff4, staff4.getBuyGiftFor().getReceiveGiftFrom());
        assertEquals(staff5, staff5.getBuyGiftFor().getReceiveGiftFrom());

        //No one is going to buy a gift for himself/herself.
        assertNotEquals(staff1, staff1.getBuyGiftFor());
        assertNotEquals(staff2, staff2.getBuyGiftFor());
        assertNotEquals(staff3, staff3.getBuyGiftFor());
        assertNotEquals(staff4, staff4.getBuyGiftFor());
        assertNotEquals(staff5, staff5.getBuyGiftFor());

    }
}
