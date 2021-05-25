import java.util.ArrayList;
import java.util.List;

public class SecretSantaAssigner {

    List<Integer> unassignedStaffIndexes = new ArrayList<>();

    public void assignSecretSanta(List<StaffMember> staffMembers) {

        for (int i = 0; i < staffMembers.size(); i++) {
            unassignedStaffIndexes.add(i);
        }

        for (int i = 0; i < staffMembers.size(); i++) {
            int giftReceiverIndex = assignGiftReceiver(i);
            staffMembers.get(i).setBuyGiftFor(staffMembers.get(giftReceiverIndex));
            staffMembers.get(giftReceiverIndex).setReceiveGiftFrom(staffMembers.get(i));
        }

    }

    private int assignGiftReceiver(int buyerIndex) {
        int n = (int) (Math.random() * unassignedStaffIndexes.size());
        int receiverIndex = unassignedStaffIndexes.get(n);
        if (receiverIndex == buyerIndex) {
            return assignGiftReceiver(buyerIndex);
        }
        unassignedStaffIndexes.remove(n);
        return receiverIndex;
    }
}
