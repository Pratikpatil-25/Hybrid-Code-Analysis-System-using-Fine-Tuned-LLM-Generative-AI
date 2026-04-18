package org.apache.derby.impl.store.access.sort;

import org.apache.derby.iapi.services.sanity.SanityManager;

import org.apache.derby.iapi.error.StandardException;
import org.apache.derby.iapi.store.access.conglomerate.TransactionManager;



public class SortBufferScan extends SortScan
{
	
	protected SortBuffer sortBuffer;

	

	SortBufferScan(
    MergeSort           sort, 
    TransactionManager  tran, 
    SortBuffer          sortBuffer,
    boolean             hold)
	{
		super(sort, tran, hold);

        if (SanityManager.DEBUG)
            SanityManager.ASSERT(sortBuffer != null);

		this.sortBuffer = sortBuffer;
	}

	

    
    public boolean next()
		throws StandardException
	{
        if (SanityManager.DEBUG)
        {
            SanityManager.ASSERT(
                sortBuffer != null, 
                "next() called on scan after scan was closed.");
        }

		super.current = sortBuffer.removeFirst();
		return (super.current != null);
	}

    
    public boolean closeForEndTransaction(boolean closeHeldScan)
    {
        if (closeHeldScan || !hold)
        {
            close();
            return(true);
        }
        else
        {
            return(false);
        }

    }

    
    public void close()
	{
		if (super.sort != null)
		{
			sort.doneScanning(this, sortBuffer);
			sortBuffer = null;
		}
		super.close();
	}

}