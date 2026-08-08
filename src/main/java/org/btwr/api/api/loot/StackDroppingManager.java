package org.btwr.api.api.loot;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.btwr.api.api.loot.condition.DirectionalDropConditions;
import org.btwr.api.api.util.utils.ItemUtils;
import org.btwr.api.api.util.utils.VectorUtils;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class StackDroppingManager {

    private static final StackDroppingManager instance = new StackDroppingManager();

    // Private constructor to prevent instantiation
    private StackDroppingManager() {}

    public static StackDroppingManager getInstance() {
        return instance;
    }

    public void onDropStacks(BlockState state, World world, BlockPos pos, BlockEntity blockEntity, Entity entity,
                             ItemStack tool, CallbackInfo ci)
    {
        if (world instanceof ServerWorld) {
            Direction lookDirection = VectorUtils.getMiningDirection(entity, world, pos);

            if (DirectionalDropConditions.test(state, tool)) {
                ItemUtils.ejectStackFromBlockTowardsFacing(world, entity, pos, state, blockEntity, tool, lookDirection);
                ci.cancel();
            }
        }
    }

}