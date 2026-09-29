package com.morecritters.mod.network;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.procedures.PageFlipRoot2Procedure;
import com.morecritters.mod.procedures.PageFlipShadelet2Procedure;
import com.morecritters.mod.world.inventory.CritterAtlasShadeletMenu;
import java.util.HashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record CritterAtlasShadeletButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
    public static final Type<CritterAtlasShadeletButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MoreCritters.MODID, "critter_atlas_shadelet_button_message"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CritterAtlasShadeletButtonMessage> STREAM_CODEC = StreamCodec.of((buffer, message) -> {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }, buffer -> new CritterAtlasShadeletButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

    @Override
    public Type<CritterAtlasShadeletButtonMessage> type() {
        return TYPE;
    }

    public static void handleData(CritterAtlasShadeletButtonMessage message, IPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
                context.connection().disconnect(Component.literal(e.getMessage()));
                return null;
            });
        }
    }

    public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
        Level world = entity.level();
        HashMap guistate = CritterAtlasShadeletMenu.guistate;
        if (world.hasChunkAt(new BlockPos(x, y, z))) {
            if (buttonID == 0) {
                PageFlipRoot2Procedure.execute(world, x, y, z, entity);
            }

            if (buttonID == 1) {
                PageFlipShadelet2Procedure.execute(world, x, y, z, entity);
            }
        }
    }

    @SubscribeEvent
    public static void registerMessage(RegisterPayloadHandlersEvent event) {
        event.registrar("1").playToServer(TYPE, STREAM_CODEC, CritterAtlasShadeletButtonMessage::handleData);
    }
}
