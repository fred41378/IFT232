package labo6.profiler;

import labo6.Ressources;
import labo6.Ressources.Gender;
import labo6.User;
import labo6.behaviors.checks.CheckBehavior;
import labo6.behaviors.checks.CheckBehaviorPatient;
import labo6.behaviors.waits.WaitBehavior;
import labo6.behaviors.waits.WaitBehaviorAsk;
import labo6.database.*;

public class NormalProfile extends Profiler {

    public NormalProfile(User peer) {
        super(peer);
    }

    @Override
    public PictureList getSuitablePictures() {
        PictureList pics = PictureDatabase.getAllPictures();
        if(country == Ressources.Country.Japan){
            pics = pics.keep(Picture.PictureKey.isComic, true);
        }
        return pics;
    }

    @Override
    public TextList getSuitableMessages() {
        TextList messageList = TextDatabase.getAllMessages();
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
        return new CheckBehaviorPatient();
    }

    @Override
    public WaitBehavior createWaitBehavior() {
        return new WaitBehaviorAsk();
    }
}
