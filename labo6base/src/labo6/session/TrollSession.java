package labo6.session;

import labo6.Labo6Main;
import labo6.Ressources;
import labo6.User;
import labo6.profiler.Profiler;
import labo6.profiler.SeductiveProfile;
import labo6.profiler.TrollProfile;

public class TrollSession extends Session {
    public TrollSession(Labo6Main l, User u) {
        super(l, u);
    }

    @Override
    public Profiler createProfiler() {
        botGender = Ressources.Gender.random();
        return new TrollProfile(human);
    }
}
