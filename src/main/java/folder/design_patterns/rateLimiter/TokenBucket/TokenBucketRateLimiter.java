package folder.design_patterns.rateLimiter.TokenBucket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter {
    private final int maxTokens;          // bucket capacity
    private final int refillRate;         // tokens added per second
    private final Map<String, Bucket> userBuckets = new ConcurrentHashMap<>();

    public TokenBucketRateLimiter(int maxTokens, int refillRate) {
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();

        // get or create bucket for user
        Bucket bucket = userBuckets.computeIfAbsent(userId, k -> new Bucket(maxTokens, currentTime));

       // synchronized (bucket) {
            // refill tokens based on elapsed time
            long elapsedTime = currentTime - bucket.lastRefillTimestamp;
            int tokensToAdd = (int) ((elapsedTime / 1000.0) * refillRate);

            if (tokensToAdd > 0) {
                bucket.tokens = Math.min(maxTokens, bucket.tokens + tokensToAdd);
                bucket.lastRefillTimestamp = currentTime;
            }

            // consume token if available
            if (bucket.tokens > 0) {
                bucket.tokens--;
                return true;  // request allowed
            } else {
                return false; // request blocked
            }
       // }
    }

    private static class Bucket {
        int tokens;                 // current tokens in bucket
        long lastRefillTimestamp;   // last time we refilled tokens

        Bucket(int tokens, long lastRefillTimestamp) {
            this.tokens = tokens;
            this.lastRefillTimestamp = lastRefillTimestamp;
        }
    }

    // Test
    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(5, 5); // 5 tokens/sec
        String user = "user1";

        for (int i = 1; i <= 15; i++) {
            boolean allowed = limiter.allowRequest(user);
            System.out.println("Request " + i + " -> " + (allowed ? "ALLOWED" : "BLOCKED"));
            Thread.sleep(200); // send requests every 200 ms
        }
    }
}

