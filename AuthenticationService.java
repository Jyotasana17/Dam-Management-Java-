import java.util.ArrayList;
import java.util.List;
// Assuming PowerStationUser and SessionToken are defined in their own files
// in the same package (or imported if in a different package)

public class AuthenticationService {
    
    // In a real system, this would interact with a Firebase Firestore/Auth API
    private final List<PowerStationUser> userDatabase; 

    // Constructor to initialize the user database list
    public AuthenticationService() {
        this.userDatabase = new ArrayList<>();
        
        // Users in the "Ganga" River Basin (Can access each other's data)
        userDatabase.add(new PowerStationUser(
            "U001", 
            "dam_ps1_op", 
            "hashed_pass1", // Should be a B-Crypt hash in reality
            "PS-101", 
            "Ganga" // This is the crucial shared authorization key
        ));

        userDatabase.add(new PowerStationUser(
            "U002", 
            "hydro_ps2_op", 
            "hashed_pass2", 
            "PS-102", 
            "Ganga" // Same basin ID means access is allowed
        ));

        // User in the "Narmada" River Basin (Cannot access Ganga basin data)
        userDatabase.add(new PowerStationUser(
            "U003", 
            "narmada_office", 
            "hashed_pass3", 
            "PS-201", 
            "Narmada" // Different basin ID
        ));
    }

    // --- Login Method (Copied from previous response for completeness) ---

    // Returns a session token on successful login
    public SessionToken login(String username, String password) throws SecurityException {
        PowerStationUser user = userDatabase.stream()
            .filter(u -> u.getUsername().equals(username))
            .findFirst()
            .orElseThrow(() -> new SecurityException("Invalid Username."));

        // NOTE: The verifyPassword method needs to be implemented in PowerStationUser
        if (user.verifyPassword(password)) { 
            // Success: Create a session token with the necessary authorization data
            return new SessionToken(user.getUserId(), user.getRiverBasinId());
        } else {
            throw new SecurityException("Invalid Password.");
        }
    }
}