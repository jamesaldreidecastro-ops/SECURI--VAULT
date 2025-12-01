public class VaultEntry {

    private String accountName;
    private String password;

    public VaultEntry(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setAccountName(String accountName) {
        if (accountName == null || accountName.trim().isEmpty()) {
            throw new IllegalArgumentException("Account name cannot be empty");
        }
        this.accountName = accountName;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 5) {
            throw new IllegalArgumentException("Password must be at least 5 characters");
        }
        this.password = password;
    }


    @Override
    public String toString() {
        return String.format("Account: %-20s | Password: %s", accountName, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof VaultEntry)) return false;
        VaultEntry v = (VaultEntry) obj;
        return accountName.equals(v.accountName);
    }

    @Override
    public int hashCode() {
        return accountName.hashCode();
    }
}