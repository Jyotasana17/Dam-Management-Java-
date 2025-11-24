public class SessionToken {
    private String userId;
    private String riverBasinId;
    // JWT fields (e.g., expiry, issuer) would be added in a real application

    public SessionToken(String userId, String riverBasinId) {
        this.userId = userId;
        this.riverBasinId = riverBasinId;
    }

    public String getRiverBasinId() {
        return riverBasinId;
    }
    
    // Simulates an API call's access check
    public boolean canAccessBasin(String targetBasinId) {
        return this.riverBasinId.equals(targetBasinId);
    }

    public void setRiverBasinId(String riverBasinId) {
        this.riverBasinId = riverBasinId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
} 