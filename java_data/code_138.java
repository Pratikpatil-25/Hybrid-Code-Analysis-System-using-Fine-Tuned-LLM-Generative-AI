package cws.core;

import java.util.Collection;
import java.util.LinkedList;

import cws.core.cloudsim.CWSSimEntity;
import cws.core.cloudsim.CWSSimEvent;
import cws.core.cloudsim.CloudSimWrapper;
import cws.core.dag.DAG;
import cws.core.dag.DAGJob;
import cws.core.dag.DAGJobListener;


public class EnsembleManager extends CWSSimEntity {
    
    private LinkedList<DAGJob> dags = new LinkedList<DAGJob>();

    
    private LinkedList<DAGJobListener> listeners;

    
    private WorkflowEngine engine = null;

    public EnsembleManager(Collection<DAG> dags, WorkflowEngine engine, CloudSimWrapper cloudsim) {
        super("EnsembleManager", cloudsim);
        this.engine = engine;
        this.dags = new LinkedList<DAGJob>();
        this.listeners = new LinkedList<DAGJobListener>();
        prioritizeDAGs(dags);
    }

    public EnsembleManager(WorkflowEngine engine, CloudSimWrapper cloudsim) {
        this(null, engine, cloudsim);
    }

    private void prioritizeDAGs(Collection<DAG> dags) {
        if (dags == null)
            return;

                int priority = 0;
        for (DAG d : dags) {
            DAGJob dj = new DAGJob(d, getId());
            dj.setPriority(priority++);
            this.dags.add(dj);
        }
    }

    public void addDAGJobListener(DAGJobListener l) {
        this.listeners.add(l);
    }

    public void removeDAGJobListener(DAGJobListener l) {
        this.listeners.remove(l);
    }

    @Override
    public void startEntity() {
                while (!dags.isEmpty()) {
            submitDAG(dags.pop());
        }
    }

    @Override
    public void processEvent(CWSSimEvent ev) {
        switch (ev.getTag()) {
        case WorkflowEvent.DAG_STARTED:
            dagStarted((DAGJob) ev.getData());
            break;
        case WorkflowEvent.DAG_FINISHED:
            dagFinished((DAGJob) ev.getData());
            break;
        default:
            throw new RuntimeException("Unknown event: " + ev);
        }
    }

    @Override
    public void shutdownEntity() {
            }

    public void submitDAG(DAGJob dagJob) {
                sendNow(engine.getId(), WorkflowEvent.DAG_SUBMIT, dagJob);
    }

    private void dagStarted(DAGJob dag) {
                for (DAGJobListener l : listeners) {
            l.dagStarted(dag);
        }
    }

    private void dagFinished(DAGJob dag) {
                for (DAGJobListener l : listeners) {
            l.dagFinished(dag);
        }
                dags.remove(dag);
    }
}