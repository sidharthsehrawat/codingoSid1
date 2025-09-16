package folder.design_patterns.rateLimiter.TokenBucket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter {

    private final int maxTokens;   // bucket capacity
    private final int refillRate;  // tokens added per second
    private final Map<String, long[]> userBuckets = new ConcurrentHashMap<>();
    // long[0] = tokens, long[1] = lastRefillTimestamp

    public TokenBucketRateLimiter(int maxTokens, int refillRate) {
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();

        // 1. Get or create bucket for user
        long[] bucket;
        if (userBuckets.containsKey(userId)) {
            bucket = userBuckets.get(userId);
        } else {
            bucket = new long[]{maxTokens, currentTime};
            userBuckets.put(userId, bucket);
        }

        // 2. Refill tokens based on elapsed time
        long elapsedTime = currentTime - bucket[1];
        int tokensToAdd = (int) ((elapsedTime / 1000.0) * refillRate);
        if (tokensToAdd > 0) {
            bucket[0] = Math.min(maxTokens, bucket[0] + tokensToAdd);
            bucket[1] = currentTime;
        }

        // 3. Consume token if available
        if (bucket[0] > 0) {
            bucket[0]--;
            return true;  // request allowed
        } else {
            return false; // request blocked
        }
    }

    // ----------------- Test -----------------
    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(5, 5);
        String user = "user1";

        for (int i = 1; i <= 15; i++) {
            boolean allowed = limiter.allowRequest(user);
            System.out.println("Request " + i + " -> " + (allowed ? "ALLOWED" : "BLOCKED"));
            Thread.sleep(200);
        }
    }
}
