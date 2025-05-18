package thePackmaster.cards.cosmoscommandpack;

import basemod.patches.com.megacrit.cardcrawl.screens.compendium.CardLibraryScreen.NoCompendium;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ModifyDamageAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.marisapack.AmplifyCard;

import static thePackmaster.SpireAnniversary5Mod.makeID;

@NoCompendium
public class EternalFlame extends AbstractCosmosCard implements AmplifyCard {
    public final static String ID = makeID("EternalStrike");

    public EternalFlame() {
        super(ID, 0, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        damage = baseDamage = 4;
        magicNumber = baseMagicNumber = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
    }

    @Override
    public boolean skipUseOnAmplify() {
        return false;
    }

    @Override
    public void useAmplified(AbstractPlayer p, AbstractMonster m) {
        this.returnToHand = true;
        addToBot(new ModifyDamageAction(this.uuid, magicNumber));
    }

    @Override
    public void applyPowers() {
        super.applyPowers();
        this.returnToHand = false;
    }

    @Override
    public int getAmplifyCost() {
        return 2;
    }

    public void upp() {
        upgradeDamage(2);
        upgradeMagicNumber(2);
    }
}