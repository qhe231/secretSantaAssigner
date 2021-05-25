import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestStaffManager {
    private StaffManager manager;
    private StaffMember staff2;

    @Before
    public void setUp(){
        manager = new StaffManager();
        StaffMember staff1 = new StaffMember("1", "Jon Snow", "jons@got.com");
        staff2 = new StaffMember("2","Tyrion Lannister", "tyrionl@got.com");
        manager.addStaffMember(staff1);

    }

    @Test
    public void testAddStaffMember(){
        manager.addStaffMember(staff2);
        assertEquals(2, manager.getStaffList().size());
        assertEquals(staff2, manager.getStaffMember("2"));
    }

    @Test
    public void testDeleteStaffMember(){
        manager.deleteStaffMember("1");
        assertEquals(0, manager.getStaffList().size());
        assertNull(manager.getStaffMember("1"));
    }

    @Test
    public void testUpdateStaffName(){
        manager.updateStaffName("1","Aegon Targaryen");
        assertEquals("Aegon Targaryen (id: 1, email: jons@got.com)", manager.getStaffMember("1").toString());

    }

    @Test
    public void testUpdateStaffEmail(){
        manager.updateStaffEmail("1", "aegont@got.com");
        assertEquals("Jon Snow (id: 1, email: aegont@got.com)", manager.getStaffMember("1").toString());
    }


}
