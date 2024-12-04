package labo6.session;

import labo6.Labo6Main;
import labo6.Ressources;
import labo6.User;
import labo6.behaviors.checks.CheckBehavior;
import labo6.behaviors.checks.CheckBehaviorSlowmo;
import labo6.behaviors.waits.WaitBehavior;
import labo6.behaviors.waits.WaitBehaviorNothing;
import labo6.bots.ChatBot;
import labo6.database.*;
import labo6.profiler.CasualProfile;
import labo6.profiler.Profiler;
import labo6.profiler.SeductiveProfile;

public class CasualSession extends Session {

    public CasualSession(Labo6Main l, User u) {
        super(l, u);
    }

    @Override
    public Profiler createProfiler() {
        botGender = human.getGender();
        return new CasualProfile(human);
    }
}
