package me.maratons4.randomitems.entities.caveMonster;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;


public class CaveMonsterEntity extends PathAwareEntity {

    private final ServerBossBar bossBar;
    public CaveMonsterEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);

        this.bossBar = new ServerBossBar(this.getDisplayName(), BossBar.Color.RED, BossBar.Style.PROGRESS);
    }
}

