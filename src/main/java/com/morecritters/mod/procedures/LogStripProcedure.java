package com.morecritters.mod.procedures;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class LogStripProcedure {
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
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                .is(ItemTags.create(ResourceLocation.parse("minecraft:axes")))) {
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.EERIE_BIRCH_LOG.get()) {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        ItemStack _ist = entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY;
                        if (world instanceof ServerLevel _serverLevel) {
                            _ist.hurtAndBreak(1, _serverLevel, null, _item -> {});
                        }
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.axe.strip")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.axe.strip")), SoundSource.BLOCKS, 1.0F, 1.0F, false
                            );
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = Blocks.STRIPPED_BIRCH_LOG.defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var20) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }

                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.EERIE_BIRCH_WOOD.get()) {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        ItemStack _ist = entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY;
                        if (world instanceof ServerLevel _serverLevel) {
                            _ist.hurtAndBreak(1, _serverLevel, null, _item -> {});
                        }
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.axe.strip")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.axe.strip")), SoundSource.BLOCKS, 1.0F, 1.0F, false
                            );
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = Blocks.STRIPPED_BIRCH_WOOD.defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var19) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }

                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.GHOSTLY_LOG.get()) {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        ItemStack _ist = entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY;
                        if (world instanceof ServerLevel _serverLevel) {
                            _ist.hurtAndBreak(1, _serverLevel, null, _item -> {});
                        }
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.axe.strip")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.axe.strip")), SoundSource.BLOCKS, 1.0F, 1.0F, false
                            );
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.STRIPPED_GHOSTLY_LOG.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var18) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }

                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.GHOSTLY_WOOD.get()) {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        ItemStack _ist = entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY;
                        if (world instanceof ServerLevel _serverLevel) {
                            _ist.hurtAndBreak(1, _serverLevel, null, _item -> {});
                        }
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.axe.strip")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.axe.strip")), SoundSource.BLOCKS, 1.0F, 1.0F, false
                            );
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.STRIPPED_GHOSTLY_WOOD.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var17) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            }
        }
    }
}
