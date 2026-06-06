package vini.evictmap;

import java.util.Random;

/**
 * Small mutable runtime state shared by lifecycle and server-console commands.
 */
final class EvictRuntimeState {

    boolean autoGenerate = false;
    Long nextSeed = null;
    Long lastSeed = null;

    long consumeNextSeed() {
        long seed = nextSeed == null ? randomSeed() : nextSeed;
        nextSeed = null;
        return seed;
    }

    long randomSeed() {
        return new Random().nextLong();
    }

    Long parseSeedOrRandom(String[] args) {
        if (args.length == 0 || args[0].equalsIgnoreCase("random")) {
            return randomSeed();
        }

        try {
            return Long.parseLong(args[0]);
        } catch (NumberFormatException exception) {
            return null;
        }
    }
}
