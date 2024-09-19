package jarvis.atoms.primitives.integers;

import jarvis.atoms.AbstractAtom;
import jarvis.atoms.BoolAtom;
import jarvis.atoms.IntAtom;
import jarvis.atoms.ObjectAtom;
import jarvis.interpreter.JarvisInterpreter;

import java.util.ArrayList;

public class IntegerPrimitiveLess extends IntegerPrimitiveOperation {

    @Override
    public String makeKey() {

        return "IntegerPrimitiveLess";
    }

    @Override
    protected AbstractAtom calculateResult(JarvisInterpreter ji, IntAtom val1, IntAtom val2) {


        boolean result = val1.getValue() < val2.getValue();

        ArrayList<AbstractAtom> data = new ArrayList<AbstractAtom>();
        data.add(new BoolAtom(result));

        return new ObjectAtom(((ObjectAtom) ji.getEnvironment().get("bool")), data, ji);
    }
}
