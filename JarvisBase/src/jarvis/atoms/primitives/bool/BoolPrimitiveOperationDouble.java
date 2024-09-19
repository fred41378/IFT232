package jarvis.atoms.primitives.bool;

import jarvis.atoms.AbstractAtom;
import jarvis.atoms.BoolAtom;
import jarvis.atoms.ObjectAtom;
import jarvis.atoms.primitives.PrimitiveOperationAtom;
import jarvis.interpreter.JarvisInterpreter;

public abstract class BoolPrimitiveOperationDouble extends PrimitiveOperationAtom {

    protected void init() {
        argCount = 1;
    }

    protected abstract AbstractAtom calculateResult(JarvisInterpreter ji, BoolAtom val1, BoolAtom val2);

    @Override
    protected AbstractAtom execute(JarvisInterpreter ji, ObjectAtom self) {
        BoolAtom bool1 = (BoolAtom) self.message("value");

        AbstractAtom arg2=ji.getArg();
        BoolAtom bool2;

        if(arg2 instanceof BoolAtom)
        {
            bool2=(BoolAtom) arg2;

        }
        else
        {
            if(arg2 instanceof ObjectAtom){

                AbstractAtom res = ((ObjectAtom) arg2).message("value");

                if(res instanceof BoolAtom){
                    bool2 = (BoolAtom) res;
                }
                else throw new IllegalArgumentException(makeKey()+", argument 2: object does not contain a \"value\" field of type IntAtom. Class = " + ((ObjectAtom)arg2).findClassName(ji)+", object contents = ["+arg2.makeKey()+"]");
            }
            else throw new IllegalArgumentException(makeKey()+", argument 2: wrong atom type " + arg2.getClass().getName()+", value = "+arg2.makeKey());

        }
        //Proc�de finalement au calcul sp�cifique � chaque primitive concernant 2 int (voir classes filles).
        return calculateResult(ji, bool1, bool2);
    }
}
