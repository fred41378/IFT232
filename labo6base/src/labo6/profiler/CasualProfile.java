package labo6.profiler;

import labo6.Ressources;
import labo6.Ressources.Gender;
import labo6.User;
import labo6.behaviors.checks.CheckBehavior;
import labo6.behaviors.checks.CheckBehaviorSlowmo;
import labo6.behaviors.waits.WaitBehavior;
import labo6.behaviors.waits.WaitBehaviorNothing;
import labo6.database.*;

public class CasualProfile extends Profiler {

    public CasualProfile(User human) {
        super(human);
    }

    @Override
    public PictureList getSuitablePictures() {
        PictureList pics = PictureDatabase.getAllPictures().remove(Picture.PictureKey.isSeductive, true);
        if(country == Ressources.Country.Japan){
            pics = pics.keep(Picture.PictureKey.isComic, true);
        }
        return pics;
    }

    @Override
    public TextList getSuitableMessages() {
        TextList messageList = TextDatabase.getAllMessages().remove(TextMessage.TextKey.isSeductive, true);
        if(country == Ressources.Country.France || country == Ressources.Country.Quebec){
            messageList = messageList.keep(TextMessage.TextKey.language, TextMessage.Language.french);
        }
        else if(country == Ressources.Country.Japan || country == Ressources.Country.Canada){
            messageList = messageList.keep(TextMessage.TextKey.language, TextMessage.Language.english);
        }
        return messageList;
    }

    @Override
    public CheckBehavior createCheckBehavior() {
        return new CheckBehaviorSlowmo();
    }

    @Override
    public WaitBehavior createWaitBehavior() {
        return new WaitBehaviorNothing();
    }
}
