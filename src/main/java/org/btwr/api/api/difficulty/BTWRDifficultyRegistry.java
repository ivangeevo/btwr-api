package org.btwr.api.api.difficulty;

import net.minecraft.util.Identifier;
import org.btwr.api.api.difficulty.impl.BTWRDifficulty;
import org.btwr.api.api.difficulty.impl.DifficultyInfo;

import java.util.*;

/**
 * Registry for all BTWR difficulties.
 *
 * <p>Use this class to create, register, and retrieve difficulties.
 * Difficulties should be registered during mod initialization.
 */
public class BTWRDifficultyRegistry {
    public static final Map<Identifier, BTWRDifficulty> DIFFICULTIES = new LinkedHashMap<>();

    /**
     * Registers a difficulty.
     *
     * <p>Each difficulty identifier must be unique. Attempting to register
     * another difficulty with the same identifier will throw an exception.
     *
     * @param difficulty the difficulty to register
     * @throws IllegalStateException if a difficulty with the same identifier is already registered
     */
    public static void register(BTWRDifficulty difficulty) {
        if (DIFFICULTIES.putIfAbsent(difficulty.info().id(), difficulty) != null) {
            throw new IllegalStateException("Duplicate difficulty: " + difficulty.info().id());
        }
    }

    /**
     * Returns the difficulty with the given identifier.
     *
     * @param id the difficulty identifier
     * @return the registered difficulty, or {@code null} if it is not registered
     */
    public static BTWRDifficulty get(Identifier id) {
        return DIFFICULTIES.get(id);
    }

    /**
     * Returns all registered difficulties.
     *
     * <p>The returned collection is read-only.
     *
     * @return all registered difficulties
     */
    public static Collection<BTWRDifficulty> getAll() {
        return Collections.unmodifiableCollection(DIFFICULTIES.values());
    }

    /**
     * Finds a difficulty by its identifier.
     *
     * @param id the difficulty identifier
     * @return an {@link Optional} containing the difficulty if it exists
     */
    public static Optional<BTWRDifficulty> find(Identifier id) {
        return Optional.ofNullable(DIFFICULTIES.get(id));
    }

    /**
     * Creates a builder using the supplied difficulty information.
     * <p> Sets a default (non-locked) difficulty.
     *
     * @param id the identifier of the difficulty
     * @return a new difficulty builder
     */
    public static BTWRDifficulty.Builder builder(Identifier id) {
        return builder(id, false);
    }

    /**
     * Creates a builder for a new difficulty.
     *
     * @param id the identifier of the difficulty
     * @return a new difficulty builder
     */
    public static BTWRDifficulty.Builder builder(Identifier id, boolean locked) {
        return new BTWRDifficulty.Builder(new DifficultyInfo(id, locked));
    }

    /**
     * Creates a builder using the supplied difficulty information.
     *
     * @param info the difficulty information
     * @return a new difficulty builder
     */
    public static BTWRDifficulty.Builder builder(DifficultyInfo info) {
        return builder(info.id(), info.locked());
    }
}