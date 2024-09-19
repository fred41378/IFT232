package jarvis.atoms.primitives.bool;

import jarvis.atoms.AbstractAtom;
import jarvis.atoms.BoolAtom;
import jarvis.atoms.ObjectAtom;
import jarvis.atoms.primitives.PrimitiveOperationAtom;
import jarvis.interpreter.JarvisInterpreter;

public abstract class BoolPrimitiveOperationSimple extends PrimitiveOperationAtom {

    protected void init() {
        argCount = 0;
    }

    protected abstract AbstractAtom calculateResult(JarvisInterpreter ji, BoolAtom val1);

    @Override
    protected AbstractAtom execute(JarvisInterpreter ji, ObjectAtom self) {
        BoolAtom bool1 = (BoolAtom) self.message("value");

        return calculateResult(ji, bool1);
    }
}
