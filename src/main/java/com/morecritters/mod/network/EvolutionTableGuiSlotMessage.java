package com.morecritters.mod.network;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.procedures.EvoTableProcedure1Procedure;
import com.morecritters.mod.procedures.EvoTableProcedure2Procedure;
import com.morecritters.mod.world.inventory.EvolutionTableGuiMenu;
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
public record EvolutionTableGuiSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) implements CustomPacketPayload {
    public static final Type<EvolutionTableGuiSlotMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MoreCritters.MODID, "evolution_table_gui_slot_message"));
    public static final StreamCodec<RegistryFriendlyByteBuf, EvolutionTableGuiSlotMessage> STREAM_CODEC = StreamCodec.of((buffer, message) -> {
        buffer.writeInt(message.slotID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
        buffer.writeInt(message.changeType);
        buffer.writeInt(message.meta);
    }, buffer -> new EvolutionTableGuiSlotMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

    @Override
    public Type<EvolutionTableGuiSlotMessage> type() {
        return TYPE;
    }

    public static void handleData(EvolutionTableGuiSlotMessage message, IPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.enqueueWork(() -> handleSlotAction(context.player(), message.slotID, message.changeType, message.meta, message.x, message.y, message.z)).exceptionally(e -> {
                context.connection().disconnect(Component.literal(e.getMessage()));
                return null;
            });
        }
    }

    public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
        Level world = entity.level();
        HashMap guistate = EvolutionTableGuiMenu.guistate;
        if (world.hasChunkAt(new BlockPos(x, y, z))) {
            if (slot == 0 && changeType == 0) {
                EvoTableProcedure1Procedure.execute(world, entity);
            }

            if (slot == 0 && changeType == 2) {
                EvoTableProcedure1Procedure.execute(world, entity);
            }

            if (slot == 1 && changeType == 1) {
                EvoTableProcedure2Procedure.execute(world, x, y, z, entity);
            }

            if (slot == 2 && changeType == 0) {
                EvoTableProcedure1Procedure.execute(world, entity);
            }

            if (slot == 2 && changeType == 2) {
                EvoTableProcedure1Procedure.execute(world, entity);
            }

            if (slot == 3 && changeType == 0) {
                EvoTableProcedure1Procedure.execute(world, entity);
            }

            if (slot == 3 && changeType == 2) {
                EvoTableProcedure1Procedure.execute(world, entity);
            }

            if (slot == 4 && changeType == 0) {
                EvoTableProcedure1Procedure.execute(world, entity);
            }

            if (slot == 4 && changeType == 2) {
                EvoTableProcedure1Procedure.execute(world, entity);
            }

            if (slot == 8 && changeType == 0) {
                EvoTableProcedure1Procedure.execute(world, entity);
            }

            if (slot == 8 && changeType == 2) {
                EvoTableProcedure1Procedure.execute(world, entity);
            }
        }
    }

    @SubscribeEvent
    public static void registerMessage(RegisterPayloadHandlersEvent event) {
        event.registrar("1").playToServer(TYPE, STREAM_CODEC, EvolutionTableGuiSlotMessage::handleData);
    }
}
