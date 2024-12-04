package labo6.profiler;

import labo6.Ressources;
import labo6.User;
import labo6.behaviors.checks.CheckBehavior;
import labo6.behaviors.checks.CheckBehaviorImpatient;
import labo6.behaviors.waits.WaitBehavior;
import labo6.behaviors.waits.WaitBehaviorTroll;
import labo6.database.*;

public class TrollProfile extends Profiler {

    public TrollProfile(User human) {
        super(human);
    }

    @Override
    public PictureList getSuitablePictures() {
        return  PictureDatabase.getAllPictures().keep(Picture.PictureKey.isComic, true);
    }

    @Override
    public TextList getSuitableMessages() {
        TextList messageList = TextDatabase.getAllMessages().keep(TextMessage.TextKey.isOffensive, true);
        if(country == Ressources.Country.France || country == Ressources.Country.Quebec){
            messageList = messageList.keep(TextMessage.TextKey.language, TextMessage.Language.english);
        }
        else if(country == Ressources.Country.Japan || country == Ressources.Country.Canada){
            messageList = messageList.keep(TextMessage.TextKey.language, TextMessage.Language.french);
        }
        return messageList;
    }

    @Override
    public CheckBehavior createCheckBehavior() {
        return new CheckBehaviorImpatient();
    }

    @Override
    public WaitBehavior createWaitBehavior() {
        return new WaitBehaviorTroll();
    }
}
