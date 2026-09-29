package com.morecritters.mod.procedures;

import io.netty.buffer.Unpooled;
import com.morecritters.mod.world.inventory.WanderingTraderGuiMenu;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class WanderingCollectorRightClickedOnEntityProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if (sourceentity instanceof ServerPlayer _ent) {
                final BlockPos _bpos = BlockPos.containing(x, y, z);
                _ent.openMenu(new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return Component.literal("WanderingTraderGui");
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                        return new WanderingTraderGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                    }
                }, _bpos);
            }

            entity.lookAt(Anchor.EYES, new Vec3(sourceentity.getX(), sourceentity.getY() + sourceentity.getBbHeight(), sourceentity.getZ()));
        }
    }
}
