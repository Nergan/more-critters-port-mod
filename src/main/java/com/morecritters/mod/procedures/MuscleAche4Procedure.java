package com.morecritters.mod.procedures;

import net.neoforged.neoforge.network.PacketDistributor;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.BalloonRatEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.LeftClickEmpty;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;

@EventBusSubscriber(Dist.CLIENT)
public class MuscleAche4Procedure {
    @SubscribeEvent
    public static void onLeftClick(LeftClickEmpty event) {
        PacketDistributor.sendToServer(new MuscleAche4Procedure.MuscleAche4Message());
        execute(event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity instanceof LivingEntity _livEnt0
                && _livEnt0.hasEffect(MoreCrittersModMobEffects.MUSCLE_ACHE)
                && !(entity instanceof BalloonRatEntity)
                && !(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.extensive_hurt")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.extensive_hurt")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                entity.hurt(
                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
                    (float)Mth.nextDouble(RandomSource.create(), 2.0, 3.0)
                );

                for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 3.0, 7.0); index0++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(x, y + entity.getBbHeight(), z),
                                        Vec2.ZERO,
                                        _level,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _level.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle more_critters:bone_debris ~ ~ ~ 0 0 0 0.05 1 force"
                            );
                    }
                }
            }
        }
    }

    @EventBusSubscriber(bus = Bus.MOD)
    public record MuscleAche4Message() implements CustomPacketPayload {
        public static final Type<MuscleAche4Message> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MoreCritters.MODID, "procedure_muscle_ache_4"));
        public static final StreamCodec<RegistryFriendlyByteBuf, MuscleAche4Message> STREAM_CODEC = StreamCodec.unit(new MuscleAche4Message());

        @Override
        public Type<MuscleAche4Message> type() {
            return TYPE;
        }

        public static void handleData(MuscleAche4Message message, IPayloadContext context) {
            if (context.flow() == PacketFlow.SERVERBOUND) {
                context.enqueueWork(() -> {
                    Player player = context.player();
                    if (player.level().hasChunkAt(player.blockPosition())) {
                        MuscleAche4Procedure.execute(player.level(), player.getX(), player.getY(), player.getZ(), player);
                    }
                });
            }
        }

        @SubscribeEvent
        public static void registerMessage(RegisterPayloadHandlersEvent event) {
            event.registrar("1").playToServer(TYPE, STREAM_CODEC, MuscleAche4Message::handleData);
        }
    }
}
