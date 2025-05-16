package thePackmaster.cards.cosmoscommandpack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.WeightyImpactEffect;
import thePackmaster.cards.marisapack.AmplifyCard;
import thePackmaster.powers.shamanpack.IgnitePower;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class UltimaBlast extends AbstractCosmosCard implements AmplifyCard {
    public final static String ID = makeID("UltimaBlast");

    public UltimaBlast() {
        super(ID, 1, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 13;
        magicNumber = baseMagicNumber = 6;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
    }

    @Override
    public boolean skipUseOnAmplify() {
        return true;
    }

    @Override
    public void useAmplified(AbstractPlayer p, AbstractMonster m) {
        if (m.hb != null) {
            Wiz.vfx(new WeightyImpactEffect(m.hb.cX, m.hb.cY));
            addToBot(new WaitAction(0.8F));
        }
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
        if (getAmplifyCost() >= 2) {
            Wiz.applyToEnemy(m, new IgnitePower(m, magicNumber));
        }
    }

    @Override
    public int getAmplifyCost() {
        if (shouldAmplify(this, 2)) return 2;
        return 1;
    }

    @Override
    public void upp() {
        upgradeDamage(2);
        upgradeMagicNumber(2);
    }

    @Override
    public void applyPowers() {
        int realBaseDamage = baseDamage;
        if (shouldAmplify(this, 1)) {
            baseDamage *= 2;
        }
        super.applyPowers();
        baseDamage = realBaseDamage;
        isDamageModified = (damage != baseDamage);
    }

    @Override
    public void calculateCardDamage(AbstractMonster mo) {
        int realBaseDamage = baseDamage;
        if (shouldAmplify(this, 1)) {
            baseDamage *= 2;
        }
        super.calculateCardDamage(mo);
        baseDamage = realBaseDamage;
        isDamageModified = (damage != baseDamage);
    }

    @Override
    public void triggerOnGlowCheck() {
        glowColor = (getAmplifyCost() >= 2) ? GOLD_BORDER_GLOW_COLOR : BLUE_BORDER_GLOW_COLOR;
    }
}
