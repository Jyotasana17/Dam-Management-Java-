import java.util.List;


public class AIDecisionEngine {
    private static final double FLOOD_RISK_THRESHOLD = 150.0; // Example threshold

    // Method to analyze data and recommend an action
    // Simulates the AI algorithm that analyzes data and makes decisions [cite: 17]
    public boolean recommendAction(List<PowerStationUser> stations, double weatherForecastImpact) {
        // Simple logic for demonstration: Calculate total flow and check against threshold
        double totalFlow = 0;
        for (@SuppressWarnings("unused")
PowerStationUser station : stations) {
            totalFlow += PowerStationUser.getFlowRate();
        }

        // Incorporate weather impact for predictive analysis
        double combinedRisk = totalFlow + weatherForecastImpact;

        System.out.println("\nAI Analysis: Total Calculated Flow/Risk: " + combinedRisk);

        // Decision logic to prevent flooding and optimize operations [cite: 17]
        return combinedRisk > FLOOD_RISK_THRESHOLD; // Recommend opening downstream flow to prevent flooding
        // For optimization, perhaps only open flow if water level is very high but risk is low
        // Returning false to keep the flow closed (optimizing water storage)
    }

    // Method for Explainable AI insights [cite: 18, 34]
    public String generateExplanation(boolean decision, double totalFlow) {
        String explanation = "Explanation AI Insight:\n";
        explanation += "The AI recommended **" + (decision ? "OPENING" : "CLOSING") + "** the downstream flow.\n";

        if (decision) {
            explanation += String.format("Reasoning: The combined water flow (%.2f cumecs) exceeded the critical flood risk threshold (%.2f). Opening the gates is a **flood mitigation** decision.", totalFlow, FLOOD_RISK_THRESHOLD);
        } else {
            explanation += String.format("Reasoning: The combined water flow (%.2f cumecs) is below the flood threshold (%.2f). Keeping the gates closed is an **optimization** decision to maintain water storage.", totalFlow, FLOOD_RISK_THRESHOLD);
        }
        return explanation;
    }
}
