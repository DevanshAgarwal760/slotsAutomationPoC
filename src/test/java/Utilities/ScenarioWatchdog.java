package Utilities;

import java.util.concurrent.*;
import hooks.Hooks;

public class ScenarioWatchdog {
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    private static long getTimeoutMinutes() {
        try {
            if (Hooks.p != null) {
                String timeoutStr = Hooks.p.getProperty("timeout");
                if (timeoutStr != null) {
                    return Long.parseLong(timeoutStr);
                }
            }
        } catch (Exception e) {
            System.err.println("⚠️ Failed to read timeout from Hooks.p: " + e.getMessage());
        }
        return 10; // default fallback
    }

    public static void runWithTimeout(String scenarioName, Runnable scenarioLogic) {
        long timeout = getTimeoutMinutes();
        Future<?> future = executor.submit(scenarioLogic);

        try {
            future.get(timeout, TimeUnit.MINUTES);
        } catch (TimeoutException e) {
            future.cancel(true);
            throw new RuntimeException("⏰ Scenario '" + scenarioName + "' timed out after " + timeout + " minutes");
        } catch (ExecutionException e) {
            throw new RuntimeException("Scenario '" + scenarioName + "' failed with exception", e.getCause());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Scenario '" + scenarioName + "' was interrupted", e);
        }
    }

    public static void shutdown() {
        executor.shutdownNow();
    }
}
