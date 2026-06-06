package vini.evictmap;

import arc.util.CommandHandler;

/**
 * Single entry point for every player-facing chat command.
 */
final class EvictClientCommands {

    private final EvictCommands gameplay;
    private final InviteManager invites;
    private final RoundEndCommands roundEnd;
    private final EvictHelpCommands help;

    EvictClientCommands(
        EvictCommands gameplay,
        InviteManager invites,
        RoundEndCommands roundEnd,
        EvictHelpCommands help
    ) {
        this.gameplay = gameplay;
        this.invites = invites;
        this.roundEnd = roundEnd;
        this.help = help;
    }

    void register(CommandHandler handler) {
        gameplay.registerClientCommands(handler);
        invites.registerClientCommands(handler);
        roundEnd.registerClientCommands(handler);

        // Register last so the filtered menu replaces vanilla /help.
        help.registerClientCommands(handler);
    }
}
