package thePackmaster.cards.cosmoscommandpack.deprecated;

import basemod.patches.com.megacrit.cardcrawl.screens.compendium.CardLibraryScreen.NoCompendium;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.cosmoscommandpack.AbstractCosmosCard;
import thePackmaster.powers.cosmoscommandpack.deprecated.HeatEnginePower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.applyToSelf;

@NoCompendium
public class HeatEngine extends AbstractCosmosCard {
    public final static String ID = makeID("HeatEngine");

    public HeatEngine() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new HeatEnginePower(p, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}