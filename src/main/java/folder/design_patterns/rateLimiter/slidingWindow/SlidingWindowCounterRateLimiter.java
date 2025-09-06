package folder.design_patterns.rateLimiter.slidingWindow;

import folder.design_patterns.rateLimiter.fixedWindow.FixedWindowRateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowCounterRateLimiter {
    private final int maxRequests;       // max requests allowed per window
    private final long windowSizeInMs;   // window size in milliseconds
    private final Map<String, Window> userWindows = new ConcurrentHashMap<>();

    public SlidingWindowCounterRateLimiter(int maxRequests, long windowSizeInMs) {
        this.maxRequests = maxRequests;
        this.windowSizeInMs = windowSizeInMs;
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        long currentWindowKey = currentTime / windowSizeInMs;   // current window number
        long previousWindowKey = currentWindowKey - 1;          // previous window number

        Window window = userWindows.get(userId);   // try to get user's window

        if (window == null) {                      // if not found
            window = new Window(currentWindowKey);        // create a new one
            userWindows.put(userId, window);       // save it in the map
        }

      //  synchronized (window) {
            // if moved to a new window, reset counter
            if (window.windowKey != currentWindowKey) {
                if (window.windowKey == previousWindowKey) {
                    // shift counters: previous → store old count
                    window.prevCount = window.counter;
                } else {
                    // too old → discard
                    window.prevCount = 0;
                }
                window.counter = 0;
                window.windowKey = currentWindowKey;
            }

            // increment for current window
            window.counter++;

            // calculate weighted requests
            long elapsedTimeInWindow = currentTime % windowSizeInMs; // how far into the current window we are
            double weight = (double)(windowSizeInMs - elapsedTimeInWindow) / windowSizeInMs;

            double estimatedCount = window.prevCount * weight + window.counter;

            if (estimatedCount <= maxRequests) {
                return true; // allowed
            } else {
                return false; // blocked
            }
       // }
    }

    private static class Window {
        long windowKey;   // current window number
        int counter;      // current window counter
        int prevCount;    // previous window counter

        Window(long windowKey) {
            this.windowKey = windowKey;
            this.counter = 0;
            this.prevCount = 0;
        }
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
