package jarvis.atoms.primitives.bool;

import jarvis.atoms.AbstractAtom;
import jarvis.atoms.BoolAtom;
import jarvis.atoms.IntAtom;
import jarvis.atoms.ObjectAtom;
import jarvis.atoms.primitives.integers.IntegerPrimitiveOperation;
import jarvis.interpreter.JarvisInterpreter;

import java.util.ArrayList;

public class BoolPrimitiveAnd extends BoolPrimitiveOperation {

    @Override
    public String makeKey() {

        return "BoolPrimitiveAnd";
    }

    @Override
    protected AbstractAtom calculateResult(JarvisInterpreter ji, BoolAtom val1) {
        return null;
    }

    @Override
    protected AbstractAtom calculateResult(JarvisInterpreter ji, BoolAtom val1, BoolAtom val2) {

        // C'est ici que l'op�ration r�elle a lieu
        boolean result = val1.getValue() && val2.getValue();

        // Ici, construit un objet int manuellement
        // � noter, on retourne un objet de type bool, pas un atome de type
        // bool.
        ArrayList<AbstractAtom> data = new ArrayList<AbstractAtom>();
        data.add(new BoolAtom(result));

        return new ObjectAtom(((ObjectAtom) ji.getEnvironment().get("bool")), data, ji);
    }
}