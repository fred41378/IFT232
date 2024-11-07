package jarvis.atoms.primitives;

import jarvis.atoms.AbstractAtom;

import jarvis.atoms.ObjectAtom;
import jarvis.interpreter.JarvisInterpreter;

public class OperatorSetPrimitive extends PrimitiveOperationAtom{

    protected void init() {
        argCount = 2;
    }

    @Override
    protected AbstractAtom execute(JarvisInterpreter ji,ObjectAtom self) {

        AbstractAtom arg1 = ji.getArg();
        AbstractAtom arg2 = ji.getArg();
        self.setAttribute(arg1, arg2);

        return self;
    }

    @Override
    public String makeKey() {

        return "OperatorSetPrimitive";
    }

}