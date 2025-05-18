package thePackmaster.cards.cosmoscommandpack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.marisapack.FreeAmplifyPower;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class WallOfSparks extends AbstractCosmosCard {
    public static final String ID = makeID("WallOfSparks");

    public WallOfSparks() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 12;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        Wiz.applyToSelf(new FreeAmplifyPower(1));
    }

    @Override
    public void upp() {
        upgradeBlock(3);
    }
}
