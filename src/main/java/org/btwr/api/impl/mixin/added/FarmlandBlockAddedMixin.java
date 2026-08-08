package org.btwr.api.impl.mixin.added;

import net.minecraft.block.FarmlandBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.btwr.api.impl.added.BlockAdded;
import org.spongepowered.asm.mixin.Mixin;

import static net.minecraft.block.FarmlandBlock.MOISTURE;

@Mixin(FarmlandBlock.class)
public abstract class FarmlandBlockAddedMixin implements BlockAdded {
    @Override
    public boolean btwr$isBlockHydratedForPlantGrowthOn(World world, BlockPos pos) {
        return world.getBlockState(pos).get(MOISTURE) == 7;
    }
}
