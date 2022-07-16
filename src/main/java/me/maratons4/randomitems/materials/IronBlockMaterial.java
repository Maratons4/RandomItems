package me.maratons4.randomitems.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class IronBlockMaterial  implements ToolMaterial {

    public static final IronBlockMaterial INSTANCE = new IronBlockMaterial();

    @Override
    public int getDurability() {
        return 1000;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return 45.0F;
    }
    @Override
    public float getAttackDamage() {
        return 3.0F;
    }
    @Override
    public int getMiningLevel() {
        return 5;
    }
    @Override
    public int getEnchantability() {
        return 15;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.IRON_BLOCK);
    }
}
