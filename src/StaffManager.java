import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StaffManager {
    Map<String, StaffMember> staffBook;

    public StaffManager() {
        staffBook = new TreeMap<>();
    }

    public List<StaffMember> getStaffList() {
        return new ArrayList<>(staffBook.values());
    }

    public void addStaffMember(StaffMember staffMember) {
        staffBook.put(staffMember.getId(), staffMember);
    }

    public void updateStaffName(String staffId, String newName) {
        staffBook.get(staffId).setName(newName);
    }


    public void updateStaffEmail(String staffId, String newEmail) {
        staffBook.get(staffId).setEmail(newEmail);
    }

    public void deleteStaffMember(String staffId) {
        staffBook.remove(staffId);
    }

    public StaffMember getStaffMember(String staffId) {
        return staffBook.get(staffId);
    }

    public boolean hasStaffMember(String staffId) {
        return staffBook.containsKey(staffId);
    }
}
