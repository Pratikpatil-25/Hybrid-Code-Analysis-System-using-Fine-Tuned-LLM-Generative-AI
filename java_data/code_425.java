package xal.model.alg;


import xal.model.IElement;
import xal.model.IProbe;
import xal.model.ModelException;
import xal.model.elem.IdealDrift;
import xal.model.elem.IdealMagSectorDipole2;
import xal.model.elem.IdealPermMagQuad;
import xal.model.probe.EnvelopeProbe;



public class EnvelopeTrackerPmqDipole extends EnvelopeTracker {

    
    
    
    
    
    
    
    public static final String      s_strTypeId = EnvelopeTrackerPmqDipole.class.getName();
    
    
    public static final int         s_intVersion = 1;
    
    
    public static final Class<EnvelopeProbe>       s_clsProbeType = EnvelopeProbe.class;
    
    
    
    
     
     
     
    
    

    
    public EnvelopeTrackerPmqDipole() { 
        super(s_strTypeId, s_intVersion, s_clsProbeType);
    };
    
    
    public EnvelopeTrackerPmqDipole( EnvelopeTrackerPmqDipole sourceTracker ) {
        super( sourceTracker );
    }
    
    
    @Override
    public EnvelopeTrackerPmqDipole copy() {
        return new EnvelopeTrackerPmqDipole( this );
    }

    
    
    
    @Override
    public void doPropagation(IProbe probe, IElement elem) throws ModelException {
        
        int     nSteps;
        double  dblSize;

                double elemPos = this.getElemPosition();
        double elemLen = elem.getLength();
        double propLen = elemLen - elemPos;
        
        if (propLen < 0) {
        	System.err.println("doPropagation, elemPos, elemLen = "+elemPos+" "+elemLen);
        	return;
        }
  
        if (elem instanceof IdealPermMagQuad || elem instanceof IdealMagSectorDipole2)   {
            nSteps = (int)Math.max(Math.ceil(propLen / getStepSize()), 1);
            
        } else if (elem instanceof IdealDrift) {
            nSteps = (int)Math.max(Math.ceil(propLen / getStepSize()), 1);
            
        }else if(this.getUseSpacecharge()) {
            nSteps = (int) Math.max(Math.ceil(propLen / getStepSize()), 1);
        
        } else { 
            nSteps = 1;
            
        }
                
        dblSize = propLen / nSteps;
        for (int i=0 ; i<nSteps ; i++) {
            this.advanceState(probe, elem, dblSize);
            this.advanceProbe(probe, elem, dblSize);
        }
    }
    

}