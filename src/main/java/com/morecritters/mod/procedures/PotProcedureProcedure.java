package com.morecritters.mod.procedures;

import java.util.Map.Entry;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class PotProcedureProcedure {
    @SubscribeEvent
    public static void onRightClickBlock(RightClickBlock event) {
        if (event.getHand() == event.getEntity().getUsedItemHand()) {
            execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.FLOWER_POT) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                        != MoreCrittersModBlocks.BLOSSOMBUSH.get().asItem()
                    && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                        != MoreCrittersModBlocks.CLOSED_BLOSSOMBUSH.get().asItem()) {
                    if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                            != MoreCrittersModBlocks.ELECTRIC_BLOSSOMBUSH.get().asItem()
                        && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                            != MoreCrittersModBlocks.CLOSED_ELECTRIC_BLOSSOMBUSH.get().asItem()) {
                        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                            == MoreCrittersModBlocks.VITA_SHROOM.get().asItem()) {
                            if (entity instanceof LivingEntity _entity) {
                                _entity.swing(InteractionHand.MAIN_HAND, true);
                            }

                            BlockPos _bp = BlockPos.containing(x, y, z);
                            BlockState _bs = MoreCrittersModBlocks.POT_VITA.get().defaultBlockState();
                            BlockState _bso = world.getBlockState(_bp);
                            for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                                Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                        _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                                    } catch (Exception var23) {
                                    }
                                }
                            }

                            world.setBlock(_bp, _bs, 3);
                            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                                (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                            }
                        } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                            == MoreCrittersModBlocks.MORI_SHROOM.get().asItem()) {
                            if (entity instanceof LivingEntity _entity) {
                                _entity.swing(InteractionHand.MAIN_HAND, true);
                            }

                            BlockPos _bp = BlockPos.containing(x, y, z);
                            BlockState _bs = MoreCrittersModBlocks.POT_MORI.get().defaultBlockState();
                            BlockState _bso = world.getBlockState(_bp);
                            for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                                Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                        _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                                    } catch (Exception var22) {
                                    }
                                }
                            }

                            world.setBlock(_bp, _bs, 3);
                            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                                (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                            }
                        }
                    } else {
                        if (entity instanceof LivingEntity _entity) {
                            _entity.swing(InteractionHand.MAIN_HAND, true);
                        }

                        BlockPos _bp = BlockPos.containing(x, y, z);
                        BlockState _bs = MoreCrittersModBlocks.POT_ELECTRIC_BLOSSOMBUSH.get().defaultBlockState();
                        BlockState _bso = world.getBlockState(_bp);
                        for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                            Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                            if (_property != null && _bs.getValue(_property) != null) {
                                try {
                                    _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                                } catch (Exception var24) {
                                }
                            }
                        }

                        world.setBlock(_bp, _bs, 3);
                        if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                            (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                        }
                    }
                } else {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.POT_BLOSSOMBUSH.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var25) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                }
            }
        }
    }
}
