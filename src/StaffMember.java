public class StaffMember {
    private final String id;
    private String name;
    private String email;
    private StaffMember buyGiftFor;
    private StaffMember receiveGiftFrom;

    public StaffMember(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " (id: " + id + ", email: " + email + ')';
    }

    public String generateResult() {
        return name + " will buy a gift for " + buyGiftFor.toString() + " and receive a gift from " + receiveGiftFrom.toString() + ".";
    }

    public StaffMember getBuyGiftFor() {
        return buyGiftFor;
    }

    public StaffMember getReceiveGiftFrom() {
        return receiveGiftFrom;
    }

    public void setBuyGiftFor(StaffMember buyGiftFor) {
        this.buyGiftFor = buyGiftFor;
    }

    public void setReceiveGiftFrom(StaffMember receiveGiftFrom) {
        this.receiveGiftFrom = receiveGiftFrom;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
