package thePackmaster.cards.cosmoscommandpack;

import basemod.patches.com.megacrit.cardcrawl.screens.compendium.CardLibraryScreen.NoCompendium;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.cosmoscommandpack.CoalescePower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.applyToSelf;

@NoCompendium
public class Coalesce extends AbstractCosmosCard {
    public final static String ID = makeID("HeatEngine");

    public Coalesce() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new CoalescePower(p, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}