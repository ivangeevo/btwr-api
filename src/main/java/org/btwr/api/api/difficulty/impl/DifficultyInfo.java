package org.btwr.api.api.difficulty.impl;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.Identifier;

/** Hold information about a difficulty's Identifier and whether it should be locked **/
public record DifficultyInfo(Identifier id, boolean locked) {
    public static final MapCodec<DifficultyInfo> CODEC = RecordCodecBuilder.mapCodec(instance ->
        instance.group(
                Identifier.CODEC.fieldOf("id").forGetter(DifficultyInfo::id),
                Codec.BOOL.fieldOf("locked").forGetter(DifficultyInfo::locked)
        ).apply(instance, DifficultyInfo::new)
    );
    public static final PacketCodec<RegistryByteBuf, DifficultyInfo> PACKET_CODEC = PacketCodec.tuple(
            Identifier.PACKET_CODEC,
            DifficultyInfo::id,
            PacketCodecs.BOOL,
            DifficultyInfo::locked,
            DifficultyInfo::new
    );
}