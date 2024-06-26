package taewookim.util;

import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import taewookim.BattleSystemPlugin;

public enum ElementTypes {

    ELEMENT(Particle.CLOUD, Particle.SMOKE_LARGE, new ElementDamager() {
        @Override
        public void entityDamage(LivingEntity damager, LivingEntity target, int power) {
            BattleSystemPlugin.Damage(damager, target, BattleSystemPlugin.getDamage(damager)*((double)power)*0.2d);
        }
    }),
    ELEMENT_FIRE(Particle.FLAME, Particle.LAVA, new ElementDamager() {
        @Override
        public void entityDamage(LivingEntity damager, LivingEntity target, int power) {
            BattleSystemPlugin.Damage(damager, target, BattleSystemPlugin.getDamage(damager)*((double)power)*0.17d);
            target.setFireTicks(power*20);
        }
    }),
    ;

    private final Particle main;
    private final Particle sub;
    private final ElementDamager elementdamager;

    ElementTypes(Particle main, Particle sub, ElementDamager elementdamager) {
        this.main = main;
        this.sub = sub;
        this.elementdamager = elementdamager;
    }

    public Particle getMainParticle() {
        return main;
    }

    public Particle getSubParticle() {
        return sub;
    }

    public void damage(LivingEntity damager, LivingEntity target, int power) {
        elementdamager.entityDamage(damager, target, power);
    }

}
