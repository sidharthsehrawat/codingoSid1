package folder.design_patterns.rateLimiter.slidingWindow;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowCounterRateLimiter {

    private final int maxRequests;
    private final long windowSizeInMs;

    // Replacing the Window class with 3 maps
    private final Map<String, Long> userWindowKey = new ConcurrentHashMap<>();
    private final Map<String, Integer> currentWindowCount = new ConcurrentHashMap<>();
    private final Map<String, Integer> previousWindowCount = new ConcurrentHashMap<>();

    public SlidingWindowCounterRateLimiter(int maxRequests, long windowSizeInMs) {
        this.maxRequests = maxRequests;
        this.windowSizeInMs = windowSizeInMs;
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        long currentWindow = currentTime / windowSizeInMs;
        long previousWindow = currentWindow - 1;

        Long lastWindow = userWindowKey.get(userId);

        if (lastWindow == null || lastWindow != currentWindow) {
            // Moved to a new window
            if (lastWindow != null && lastWindow == previousWindow) {
                // Shift current → previous
                int prevCount = currentWindowCount.getOrDefault(userId, 0);
                previousWindowCount.put(userId, prevCount);
            } else {
                // Too old, discard previous
                previousWindowCount.put(userId, 0);
            }

            // Reset current count
            currentWindowCount.put(userId, 0);
            userWindowKey.put(userId, currentWindow);
        }

        // Increment current count
        int currentCount = currentWindowCount.getOrDefault(userId, 0) + 1;
        currentWindowCount.put(userId, currentCount);

        // Weighted calculation
        long elapsedTimeInWindow = currentTime % windowSizeInMs;
        double weight = (double)(windowSizeInMs - elapsedTimeInWindow) / windowSizeInMs;

        int prevCount = previousWindowCount.getOrDefault(userId, 0);

        double estimatedCount = prevCount * weight + currentCount;

        return estimatedCount <= maxRequests;
    }

    // Test
    public static void main(String[] args) throws InterruptedException {
        SlidingWindowCounterRateLimiter limiter = new SlidingWindowCounterRateLimiter(5, 1000); // 5 req/sec
        String user = "user1";

        for (int i = 1; i <= 20; i++) {
            boolean allowed = limiter.allowRequest(user);
            System.out.println("Request " + i + " -> " + (allowed ? "ALLOWED" : "BLOCKED"));
            Thread.sleep(200); // 200 ms gap
        }
    }
}

