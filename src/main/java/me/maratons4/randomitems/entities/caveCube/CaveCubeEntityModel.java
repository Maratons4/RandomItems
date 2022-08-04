package me.maratons4.randomitems.entities.caveCube;

import com.google.common.collect.ImmutableList;
import me.maratons4.randomitems.RandomItems;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class CaveCubeEntityModel extends EntityModel<CaveCubeEntity> {

    private final ModelPart base;

    public CaveCubeEntityModel(ModelPart modelPart) {
        this.base = modelPart.getChild(String.valueOf(RandomItems.CAVE_CUBE));
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(String.valueOf(RandomItems.CAVE_CUBE), ModelPartBuilder.create().uv(0, 0).cuboid(-6F, 12F, -6F, 12F, 12F, 12F), ModelTransform.pivot(0F, 0F, 0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles (CaveCubeEntity entity, float limbAngle, float limbDistance, float animationProgress,
                           float headYaw, float headPitch){
    }

    @Override
    public void render (MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red,
                        float green, float blue, float alpha){
        ImmutableList.of(this.base).forEach((modelRenderer) -> modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha));
    }
}

