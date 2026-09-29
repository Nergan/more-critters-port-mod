package com.morecritters.mod.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.world.entity.LivingEntity;
import org.joml.Quaternionf;
import org.joml.Vector3f;

/**
 * The 1.20.1 {@code InventoryScreen.renderEntityInInventoryFollowsAngle}: feet at (x, y), no scissor box.
 * The 1.21 version centres the entity inside a rectangle, which would move every atlas model.
 */
public final class GuiEntityRenderer {
    private GuiEntityRenderer() {
    }

    public static void renderEntityInInventoryFollowsAngle(
        GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity
    ) {
        Quaternionf pose = new Quaternionf().rotateZ((float)Math.PI);
        Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20.0F * (float)(Math.PI / 180.0));
        pose.mul(cameraOrientation);
        float bodyRot = entity.yBodyRot;
        float yRot = entity.getYRot();
        float xRot = entity.getXRot();
        float headRotO = entity.yHeadRotO;
        float headRot = entity.yHeadRot;
        entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
        entity.setYRot(180.0F + angleXComponent * 40.0F);
        entity.setXRot(-angleYComponent * 20.0F);
        entity.yHeadRot = entity.getYRot();
        entity.yHeadRotO = entity.getYRot();
        InventoryScreen.renderEntityInInventory(guiGraphics, (float)x, (float)y, (float)scale, new Vector3f(), pose, cameraOrientation, entity);
        entity.yBodyRot = bodyRot;
        entity.setYRot(yRot);
        entity.setXRot(xRot);
        entity.yHeadRotO = headRotO;
        entity.yHeadRot = headRot;
    }
}
