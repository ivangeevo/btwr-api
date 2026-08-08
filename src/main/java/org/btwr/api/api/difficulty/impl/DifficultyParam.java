package org.btwr.api.api.difficulty.impl;

import com.mojang.serialization.Codec;
import net.minecraft.util.Identifier;

 /** A simple utility record that holds all data of a difficulty parameter **/
public record DifficultyParam<T>(Identifier id, Codec<T> codec, T defaultValue) {}