package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import io.netty.buffer.Unpooled;
import com.morecritters.mod.world.inventory.CritterAtlasCritterlings2Menu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class PageFlipCritterling2Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity instanceof ServerPlayer _ent) {
                final BlockPos _bpos = BlockPos.containing(x, y, z);
                _ent.openMenu(new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return Component.literal("CritterAtlasCritterlings2");
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                        return new CritterAtlasCritterlings2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                    }
                }, _bpos);
            }

            if (!world.isClientSide() && world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(
                        (Player)null,
                        BlockPos.containing(x, y, z),
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")),
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F
                    );
                } else {
                    _level.playLocalSound(
                        x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.PLAYERS, 1.0F, 1.0F, false
                    );
                }
            }
        }
    }
}
