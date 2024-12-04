package labo6.session;

import labo6.Labo6Main;
import labo6.Ressources;
import labo6.User;
import labo6.behaviors.checks.CheckBehavior;
import labo6.behaviors.checks.CheckBehaviorImpatient;
import labo6.behaviors.waits.WaitBehavior;
import labo6.behaviors.waits.WaitBehaviorSaySomething;
import labo6.bots.ChatBot;
import labo6.database.*;
import labo6.profiler.Profiler;
import labo6.profiler.SeductiveProfile;

public class SeductionSession extends Session {

    public SeductionSession(Labo6Main l, User u) {
        super(l, u);
    }

    @Override
    public Profiler createProfiler() {
        if(human.getGender() == Ressources.Gender.man)
            botGender = Ressources.Gender.woman;
        else{
            botGender = Ressources.Gender.man;
        }
        return new SeductiveProfile(human);
    }


}
