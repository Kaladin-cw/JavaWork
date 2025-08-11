public class Customer {
    private String customerId;
    private String customerName;
    private String email;
    private String phone;

    public Customer(String customerId, String customerName, String email, String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Customer: " + customerName + " (ID: " + customerId + ")";
    }
}