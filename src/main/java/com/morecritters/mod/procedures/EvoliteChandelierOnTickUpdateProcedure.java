package com.morecritters.mod.procedures;

import java.util.Comparator;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class EvoliteChandelierOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        Vec3 _center = new Vec3(x, y, z);

        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12.5), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:critterling")))
                && !(entityiterator instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MoreCrittersModMobEffects.EVOLIGHTENED))
                && entityiterator instanceof LivingEntity _entity
                && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.EVOLIGHTENED, 200, 0, false, false));
            }
        }

        if (world instanceof ServerLevel _level) {
            _level.getServer()
                .getCommands()
                .performPrefixedCommand(
                    new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                    "/particle more_critters:evolightened_particle ~0.5 ~-1 ~0.5 0.5 -0.6 0.5 0.01 3 force"
                );
        }
    }
}
