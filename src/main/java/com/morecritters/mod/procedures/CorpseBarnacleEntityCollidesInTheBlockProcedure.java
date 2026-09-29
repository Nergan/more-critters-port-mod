package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CorpseBarnacleEntityCollidesInTheBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            if (!(new Object() {
                        public boolean checkGamemode(Entity _ent) {
                            if (_ent instanceof ServerPlayer _serverPlayer) {
                                return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                            } else {
                                return _ent.level().isClientSide() && _ent instanceof Player _player
                                    ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                        && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                            == GameType.SPECTATOR
                                    : false;
                            }
                        }
                    })
                    .checkGamemode(entity)
                && !(new Object() {
                        public boolean checkGamemode(Entity _ent) {
                            if (_ent instanceof ServerPlayer _serverPlayer) {
                                return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                            } else {
                                return _ent.level().isClientSide() && _ent instanceof Player _player
                                    ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                        && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                            == GameType.CREATIVE
                                    : false;
                            }
                        }
                    })
                    .checkGamemode(entity)) {
                rate = Mth.nextInt(RandomSource.create(), 1, 20);
                if (rate == 1.0 && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1.5, 1.5, 1.5), e -> true).isEmpty()) {
                    int _value = 1;
                    BlockPos _pos = BlockPos.containing(x, y, z);
                    BlockState _bs = world.getBlockState(_pos);
                    if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_value)) {
                        world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                    }

                    MoreCritters.queueServerWork(
                        5,
                        () -> {
                            int _valuex = 0;
                            BlockPos _posx = BlockPos.containing(x, y, z);
                            BlockState _bsx = world.getBlockState(_posx);
                            if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerPropxx
                                && _integerPropxx.getPossibleValues().contains(_valuex)) {
                                world.setBlock(_posx, _bsx.setValue(_integerPropxx, _valuex), 3);
                            }

                            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1.5, 1.5, 1.5), e -> true).isEmpty()) {
                                entity.hurt(
                                    new DamageSource(
                                        world.registryAccess()
                                            .registryOrThrow(Registries.DAMAGE_TYPE)
                                            .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("more_critters:biting")))
                                    ),
                                    4.0F
                                );
                            } else {
                                _valuex = 0;
                                _posx = BlockPos.containing(x, y, z);
                                _bsx = world.getBlockState(_posx);
                                if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerPropx
                                    && _integerPropx.getPossibleValues().contains(_valuex)) {
                                    world.setBlock(_posx, _bsx.setValue(_integerPropx, _valuex), 3);
                                }
                            }
                        }
                    );
                }
            }

            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1.5, 1.5, 1.5), e -> true).isEmpty()) {
                int _value = 0;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            }
        }
    }
}
