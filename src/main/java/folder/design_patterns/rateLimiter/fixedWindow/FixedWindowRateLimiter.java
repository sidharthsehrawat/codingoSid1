package folder.design_patterns.rateLimiter.fixedWindow;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter {
    private final int maxRequests;       // max requests allowed per window
    private final long windowSizeInMs;   // window size in milliseconds
    private final Map<String, Window> userWindows = new ConcurrentHashMap<>();

    public FixedWindowRateLimiter(int maxRequests, long windowSizeInMs) {
        this.maxRequests = maxRequests;
        this.windowSizeInMs = windowSizeInMs;
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        long windowKey = currentTime / windowSizeInMs; // floor to current window

        // get or create user window
        Window window = userWindows.get(userId);   // try to get user's window

        if (window == null) {                      // if not found
            window = new Window(windowKey);        // create a new one
            userWindows.put(userId, window);       // save it in the map
        }


       // synchronized (window) {
            if (window.windowKey != windowKey) {
                // New window started → reset counter
                window.windowKey = windowKey;
                window.counter.set(0);
            }

            if (window.counter.incrementAndGet() <= maxRequests) {
                return true; // allowed
            } else {
                return false; // blocked
            }
      //  }
    }

    private static class Window {
        long windowKey;
        AtomicInteger counter;

        Window(long windowKey) {
            this.windowKey = windowKey;
            this.counter = new AtomicInteger(0);
        }
    }

    // Test
    public static void main(String[] args) throws InterruptedException {
        FixedWindowRateLimiter limiter = new FixedWindowRateLimiter(5, 1000); // 5 req/sec
        String user = "user1";

        for (int i = 1; i <= 10; i++) {
            boolean allowed = limiter.allowRequest(user);
            System.out.println("Request " + i + " -> " + (allowed ? "ALLOWED" : "BLOCKED"));
            Thread.sleep(100); // 100 ms gap
        }
    }
}

