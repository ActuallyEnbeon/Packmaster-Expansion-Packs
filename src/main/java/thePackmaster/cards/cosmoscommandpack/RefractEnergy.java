package thePackmaster.cards.cosmoscommandpack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.MindblastEffect;
import thePackmaster.patches.marisapack.AmplifyPatches;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.vfx;

public class RefractEnergy extends AbstractCosmosCard {
    public final static String ID = makeID("RefractEnergy");

    public RefractEnergy() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ALL_ENEMY);
        baseDamage = 8;
        magicNumber = baseMagicNumber = 6;
        this.isMultiDamage = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        vfx(new MindblastEffect(p.hb.cX, p.hb.cY, p.flipHorizontal));
        allDmg(AbstractGameAction.AttackEffect.NONE);
    }

    @Override
    public void applyPowers() {
        int realBaseDamage = baseDamage;
        if (AmplifyPatches.amplifiedThisTurn) { baseDamage += magicNumber; }
        super.applyPowers();
        baseDamage = realBaseDamage;
        isDamageModified = (damage != baseDamage);
    }

    @Override
    public void calculateCardDamage(AbstractMonster mo) {
        int realBaseDamage = baseDamage;
        if (AmplifyPatches.amplifiedThisTurn) { baseDamage += magicNumber; }
        super.calculateCardDamage(mo);
        baseDamage = realBaseDamage;
        isDamageModified = (damage != baseDamage);
    }

    @Override
    public void triggerOnGlowCheck() {
        glowColor = (AmplifyPatches.amplifiedThisTurn ? GOLD_BORDER_GLOW_COLOR : BLUE_BORDER_GLOW_COLOR);
    }

    public void upp() {
        upgradeDamage(2);
        upgradeMagicNumber(2);
    }
}