package jarvis.atoms.primitives.bool;

import jarvis.atoms.AbstractAtom;
import jarvis.atoms.BoolAtom;
import jarvis.atoms.ObjectAtom;
import jarvis.interpreter.JarvisInterpreter;

import java.util.ArrayList;

public class BoolPrimitiveNot extends BoolPrimitiveOperation {

    @Override
    public String makeKey() {

        return "IntegerPrimitiveEquals";
    }

    @Override
    protected AbstractAtom calculateResult(JarvisInterpreter ji, BoolAtom val1) {
        return null;
    }

    @Override
    protected AbstractAtom calculateResult(JarvisInterpreter ji, BoolAtom val1, BoolAtom val2) {

        // C'est ici que l'opération réelle a lieu
        boolean result = val1 == val2;

        // Ici, construit un objet int manuellement
        // À noter, on retourne un objet de type bool, pas un atome de type
        // bool.
        ArrayList<AbstractAtom> data = new ArrayList<AbstractAtom>();
        data.add(new BoolAtom(result));

        return new ObjectAtom(((ObjectAtom) ji.getEnvironment().get("bool")), data, ji);
    }



}