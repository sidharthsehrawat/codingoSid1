package folder.design_patterns.circuitBreaker;

class CircuitBreaker {
    private enum State { CLOSED, OPEN, HALF_OPEN }
    private State state = State.CLOSED;

    private int failureCount = 0;
    private final int failureThreshold = 3;
    private final long resetTimeout = 5000; // 5 sec
    private long lastFailureTime = 0;

    public String callService() {
        long currentTime = System.currentTimeMillis();

        // Check state
        if (state == State.OPEN) {
            if (currentTime - lastFailureTime > resetTimeout) {
                state = State.HALF_OPEN; // try again after timeout
            } else {
                return "Circuit OPEN: Call blocked ❌";
            }
        }

        try {
            // Simulate external service call
            String response = externalService();

            // Success → reset breaker
            failureCount = 0;
            state = State.CLOSED;
            return "Success ✅: " + response;

        } catch (Exception e) {
            failureCount++;
            lastFailureTime = currentTime;

            if (failureCount >= failureThreshold) {
                state = State.OPEN; // too many failures → open breaker
            }
            return "Failure ❌ (" + e.getMessage() + ")";
        }
    }

    // Dummy external service
    private String externalService() throws Exception {
        if (Math.random() < 0.7) { // 70% failure chance
            throw new RuntimeException("Service down");
        }
        return "Hello from service!";
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CircuitBreaker cb = new CircuitBreaker();

        for (int i = 0; i < 15; i++) {
            System.out.println("Call " + i + " → " + cb.callService());
            Thread.sleep(1000);
        }
    }
}
