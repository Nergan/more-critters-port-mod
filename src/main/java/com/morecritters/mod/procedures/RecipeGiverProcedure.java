package com.morecritters.mod.procedures;

import java.util.List;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class RecipeGiverProcedure {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        execute(event, event.getEntity());
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity != null) {
            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.BUNBUG_EGGS.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:bunbug_caviar_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.RAW_BUNBUG_MEAT.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:bunbug_cook_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:bunbug_cook_2")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:bunbug_cook_3")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:critter_kebab_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.COOKED_BUNBUG_MEAT.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:bunbug_burger_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.RAW_BLUBBERFISH.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:blubberfish_cook_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:blubberfish_cook_2")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:blubberfish_cook_3")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:critter_kebab_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.FREEZING_STRING.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:coldstone_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:coldstone_bricks_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:coldstone_chiseled_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:freezing_cobweb_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:coldstone_crf_11")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:websack_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.COLDSTONE.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:coldstone_stairs_crf_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:coldstone_slab_crf_2")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:coldstone_wall_crf_1")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.COLDSTONE_BRICKS.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:coldstone_bricks_stairs_crf_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:coldstone_bricks_slab_crf_2")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:coldstone_bricks_wall_crf_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:coldstone_crf_5")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.POLISHED_COLDSTONE.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:coldstone_polished_stairs_crf_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:coldstone_polished_slab_crf_2")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:coldstone_polished_wall_crf_1")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.SHRIEKBAT_WING.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:shriekbomb_crf_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:shriekbat_soup_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.BLOSSOMBUSH_SEED.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:blossombush_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.BOTTLEO_ELECTRICITY.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:taser_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:electric_blossombush_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.STURDY_SHELLS.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:sturdy_shell_block_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:sturdy_chestplate_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:biting_shield_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.STURDY_SHELL_BLOCK.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:sturdy_shell_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.VITA_SHROOM.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:life_stew_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:purgatorial_mix_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.MORI_SHROOM.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:death_stew_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:purgatorial_mix_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.ANCIENT_BONE.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ancient_skeleton_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:fungal_staff_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.ANCIENT_SKELETON_ITEM.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ancient_skeleton_exhibit_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.BOUNCEBERRY.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:bounceberry_jam_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.BOUNCEBERRY_JAM.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:bounceberry_sandwich_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.BOUNCELIZARD_EGG.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:cooked_bouncelizard_egg_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.IRON_NUGGET)) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:fossil_display_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.AVOIDER_TAIL.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:booster_pump_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:jelly_torpedo_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.EXPLOSIVE_JELLY.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:jelly_torpedo_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.MOLDED_SHELL.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:iropod_helmet_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.SHELL_PIECES.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:nautical_helmet_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:nautical_axe_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:nauticrawl_shell_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:sails_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.END_DUST.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:chrysalis_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.SUGAR)) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:tooth_melter_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:sprinkles_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.HONEYCOMB)) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:sprinkles_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.EERIE_BARK.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:eerie_log_crf_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:eerie_wood_crf_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:eerie_dart_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.BLACK_RESIN_BLOCK.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:black_resin_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.BLACK_RESIN_CLUMP.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:black_resin_block_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:black_resin_cook")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.BLACK_RESIN_BRICK.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:resin_brick_crf_1")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.BLACK_RESIN_BRICKS.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:black_resin_stairs_crf_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:black_resin_slab_crf_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:black_resin_wall_crf_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:black_resin_chiseled_crf_1")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.LOST_NERVE.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:lost_nerve_cook_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:lost_nerve_cook_2")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:lost_nerve_cook_3")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.COOKED_NERVE.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:nerval_salad_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:popped_mix_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.GHOSTLY_LOG.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.GHOSTLY_WOOD.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.STRIPPED_GHOSTLY_LOG.get())) : false)
                || (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.STRIPPED_GHOSTLY_WOOD.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ghostly_crf_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ghostly_crf_2")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ghostly_crf_6")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.GHOSTLY_PLANKS.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ghostly_crf_10")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ghostly_crf_12")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ghostly_crf_15")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ghostly_crf_17")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ghostly_crf_19")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ghostly_crf_25")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ghostly_crf_26")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ghostly_crf_28")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:mosaic_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:wet_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:petrified_planks_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.FISH_BONE_BLOCK.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:fish_bone_crf_1")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.FISH_BONE.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:fish_bone_crf_2")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:fish_bone_crf_3")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:fish_bone_crf_6")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.TATTERED_CLOTH.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:fish_bone_crf_6")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:pirate_armor_crf_1")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:pirate_armor_crf_3")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:pirate_armor_crf_4")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:pirate_armor_crf_5")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:tattered_flag_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CANNON_BALL.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:cold_cannon_ball_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:fire_cannon_ball_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:slime_cannon_ball_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:electric_cannon_ball_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:combusting_cannon_ball_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.SHARK_TOOTH.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:tooth_syringe_crf_2")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.HARDTACK.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:hardtack_piece_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.HARDTACK_PIECE.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:hardtack_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.CAPTAINS_HEART.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:corpse_parrot_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.GRAVEDIGGER_APPENDAGE.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:grave_brush_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.GLOWING_OOZE.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ooze_block_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:cut_ooze_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ooze_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ooze_rod_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.DRIPPER_REMAINS.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:wall_mask_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:slashklub_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.SCULK_ESSENCE.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:custodian_core_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.KELPIRE_ROLL_PIECE.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:kelpire_roll_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.NAUTICRAWL_TENTACLE.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:nauticrawl_ramen_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.DRIED_KELP)) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:kelp_carpet_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModItems.ECTOMETAL.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ectometal_block_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ectometal_nail_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ectometal_screw_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ectometal_railing_crf")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:giant_chain_crf")));
                }
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.ECTOMETAL_BLOCK.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:ectometal_crf")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.WET_GHOSTLY_PLANKS.get())) : false)
                && entity instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:mosaic_crf_3")));
            }

            if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MoreCrittersModBlocks.PETRIFIED_GHOSTLY_PLANKS.get())) : false)) {
                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:mosaic_crf_2")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:petrified_planks_craft_2")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:petrified_planks_craft_3")));
                }

                if (entity instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.awardRecipesByKey(List.of(ResourceLocation.parse("more_critters:petrified_planks_craft_4")));
                }
            }
        }
    }
}
