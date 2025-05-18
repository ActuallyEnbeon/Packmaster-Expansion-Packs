package thePackmaster.packs;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.UIStrings;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.cards.cosmoscommandpack.*;
import thePackmaster.cards.cosmoscommandpack.deprecated.*;

import java.util.ArrayList;

public class CosmosCommandPack extends AbstractCardPack {
    public static final String ID = SpireAnniversary5Mod.makeID("CosmosCommandPack");
    private static final UIStrings UI_STRINGS = CardCrawlGame.languagePack.getUIString(ID);
    public static final String NAME = UI_STRINGS.TEXT[0];
    public static final String DESC = UI_STRINGS.TEXT[1];
    public static final String AUTHOR = UI_STRINGS.TEXT[2];

    public CosmosCommandPack() {
        // TODO: update pack summary
        super(ID, NAME, DESC, AUTHOR, new PackSummary(3, 2, 4, 1, 4, PackSummary.Tags.Exhaust, PackSummary.Tags.Debuffs));
    }

    @Override
    public ArrayList<String> getCards() {
        ArrayList<String> cards = new ArrayList<>();
        cards.add(EternalFlame.ID);
        cards.add(ReflexiveDodge.ID);
        cards.add(StaticShock.ID);
        cards.add(Coalesce.ID);
        cards.add(Cognition.ID);
        cards.add(RefractEnergy.ID);
        cards.add(WallOfSparks.ID);
        cards.add(ArcingEnergy.ID);
        cards.add(Starburst.ID);
        cards.add(UltimaBlast.ID);
        return cards;
    }
}