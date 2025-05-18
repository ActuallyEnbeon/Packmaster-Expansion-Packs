package thePackmaster.cards.cosmoscommandpack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.vfx.WallopEffect;
import thePackmaster.cards.marisapack.AmplifyCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.forAllMonstersLiving;

public class Starburst extends AbstractCosmosCard implements AmplifyCard {
    public final static String ID = makeID("Starburst");

    public Starburst() {
        super(ID, 0, CardType.SKILL, CardRarity.RARE, CardTarget.ALL_ENEMY);
        magicNumber = baseMagicNumber = 1;
        secondMagic = baseSecondMagic = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        forAllMonstersLiving((mo) -> {
            Wiz.applyToEnemy(mo, new WeakPower(mo, magicNumber, false));
            Wiz.applyToEnemy(mo, new VulnerablePower(mo, magicNumber, false));
        });
    }

    @Override
    public boolean skipUseOnAmplify() {
        return true;
    }

    @Override
    public void useAmplified(AbstractPlayer p, AbstractMonster m) {
        // TODO: vfx
        forAllMonstersLiving((mo) -> {
            if (mo.hb != null) Wiz.vfx(new WallopEffect(5 * secondMagic, mo.hb.cX, mo.hb.cY));
            Wiz.applyToEnemy(mo, new WeakPower(mo, secondMagic, false));
            Wiz.applyToEnemy(mo, new VulnerablePower(mo, secondMagic, false));
        });
    }

    @Override
    public int getAmplifyCost() {
        return 2;
    }

    public void upp() {
        upgradeSecondMagic(2);
    }
}