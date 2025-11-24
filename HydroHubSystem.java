import java.util.ArrayList;
import java.util.List;



public class HydroHubSystem {
    // Association: The system manages a collection of PowerStations
    private List<PowerStationUser> powerStations;
    private AIDecisionEngine aiEngine;

    public HydroHubSystem() {
        this.powerStations = new ArrayList<>();
        this.aiEngine = new AIDecisionEngine();
        // Initialize stations
        powerStations.add(new PowerStationUser("PS-101", 145.0, 45.0));
        powerStations.add(new PowerStationUser("PS-102", 152.5, 60.0));
        powerStations.add(new PowerStationUser("PS-103", 148.0, 50.0));
    }

    // Core method to run the integrated decision-making cycle
    public void runDecisionCycle(double predictedWeatherImpact) {
        System.out.println("====================================================");
        System.out.println("Starting HydroHub AI Decision Cycle...");
        System.out.println("====================================================");

        // 1. Collect Real-time Data (Simulation) [cite: 16]
        System.out.println("\n--- Real-time Data Collection ---");
        for (PowerStationUser station : powerStations) {
            System.out.println(station.getDataSnapshot());
        }
        
        // 2. AI Decision-Making [cite: 17]
        System.out.println("\n--- AI Processing and Recommendation ---");
        boolean recommendedAction = aiEngine.recommendAction(powerStations, predictedWeatherImpact);

        // 3. Explainable AI Insight [cite: 18]
        @SuppressWarnings("static-access")
        double totalFlow = powerStations.stream().mapToDouble(station -> station.getFlowRate()).sum();
        String explanation = aiEngine.generateExplanation(recommendedAction, totalFlow);
        
        System.out.println(explanation);

        // 4. Action Execution (Sends 'decisions' back to the Power Stations) [cite: 49]
        System.out.println("\n--- Executing Decision Across All Stations ---");
        for (PowerStationUser station : powerStations) {
            // Apply the recommended action to all stations on the river basin
            station.executeDecision(recommendedAction);
        }
        
        System.out.println("====================================================");
        System.out.println("Decision Cycle Complete.");
        System.out.println("====================================================");
    }
    
    // Main method for execution
    public static void main(String[] args) {
        HydroHubSystem system = new HydroHubSystem();
        
        // Scenario 1: High flow, need for flood mitigation
        system.runDecisionCycle(10.0); // 10.0 simulates predicted rainfall impact
        
        // Scenario 2: Low flow, optimizing water storage
        // Simulate a manual data update (e.g., lower water levels after a dry spell)
        system.powerStations.get(0).updateData(130.0, 20.0);
        system.powerStations.get(1).updateData(135.0, 30.0);
        system.powerStations.get(2).updateData(132.0, 25.0);
        
        system.runDecisionCycle(5.0); // 5.0 simulates low predicted rainfall impact
    }

    public List<PowerStationUser> getPowerStations() {
        return powerStations;
    }

    public void setPowerStations(List<PowerStationUser> powerStations) {
        this.powerStations = powerStations;
    }

    public AIDecisionEngine getAiEngine() {
        return aiEngine;
    }

    public void setAiEngine(AIDecisionEngine aiEngine) {
        this.aiEngine = aiEngine;
    }


}
