package folder.design_patterns.rateLimiter.fixedWindow;

import java.util.HashMap;
import java.util.Map;

public class FixedWindowRateLimiter {

    private final int maxRequests;          // Max allowed requests per window
    private final long windowSizeInMillis;  // Window size (e.g., 1000ms = 1 sec)

    private final Map<String, Long> userWindowMap = new HashMap<>();// userId -> currentWindowKey
    private final Map<String, Integer> userRequestCount = new HashMap<>(); // userId -> requestCount

    public FixedWindowRateLimiter(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        long currentWindowKey = currentTime / windowSizeInMillis; // Floor to current window

        // Check if user is in same window
        Long lastWindowKey = userWindowMap.get(userId);

        if (lastWindowKey == null || lastWindowKey != currentWindowKey) {
            // New window → reset count
            userWindowMap.put(userId, currentWindowKey);
            userRequestCount.put(userId, 1);
            return true;
        }

        // Same window → check request count
        int currentCount = userRequestCount.getOrDefault(userId, 0);

        if (currentCount < maxRequests) {
            userRequestCount.put(userId, currentCount + 1);
            return true;
        } else {
            return false; // Too many requests
        }
    }

    // Test the rate limiter
    public static void main(String[] args) throws InterruptedException {
        FixedWindowRateLimiter limiter = new FixedWindowRateLimiter(5, 1000); // 5 req/sec
        String userId = "user1";

        for (int i = 1; i <= 10; i++) {
            boolean allowed = limiter.allowRequest(userId);
            System.out.println("Request " + i + " → " + (allowed ? "ALLOWED" : "BLOCKED"));
            Thread.sleep(100); // 100ms gap
        }
    }
}
