package me.maratons4.randomitems.entities.CaveMonster;

import me.maratons4.randomitems.RandomItemsClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CaveMonsterEntityRenderer extends MobEntityRenderer<CaveMonsterEntity, CaveMonsterEntityModel> {

    public CaveMonsterEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CaveMonsterEntityModel(context.getPart(RandomItemsClient.MODEL_CAVE_MONSTER_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(CaveMonsterEntity entity) {
        return new Identifier("randomitems", "textures/entity/cave_monster/cave_monster.png");
    }
}
