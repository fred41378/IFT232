package labo6.profiler;

import labo6.Ressources;
import labo6.Ressources.Gender;
import labo6.User;
import labo6.behaviors.checks.CheckBehavior;
import labo6.behaviors.checks.CheckBehaviorImpatient;
import labo6.behaviors.waits.WaitBehavior;
import labo6.behaviors.waits.WaitBehaviorSaySomething;
import labo6.database.*;
import labo6.Ressources.Country;

public class SeductiveProfile extends Profiler {

    public SeductiveProfile(User human) {
        super(human);
    }

    @Override
    public PictureList getSuitablePictures() {
        PictureList pics = PictureDatabase.getAllPictures().keep(Picture.PictureKey.isSeductive, true);
        if(country == Country.Japan){
            pics = pics.keep(Picture.PictureKey.isComic, true);
        }
        return pics;
    }

    @Override
    public TextList getSuitableMessages() {
        TextList messageList = TextDatabase.getAllMessages().keep(TextMessage.TextKey.isSeductive, true);
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
        return new CheckBehaviorImpatient();
    }

    @Override
    public WaitBehavior createWaitBehavior() {
        return new WaitBehaviorSaySomething();
    }
}
