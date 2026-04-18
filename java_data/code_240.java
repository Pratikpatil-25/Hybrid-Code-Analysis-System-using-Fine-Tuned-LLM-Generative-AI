package org.opentox.jaqpot3.www.services;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.opentox.toxotis.core.component.ErrorReport;
import org.opentox.toxotis.core.component.Task;
import org.opentox.toxotis.core.component.Task.Status;
import org.opentox.toxotis.database.engine.error.AddErrorReport;
import org.opentox.toxotis.database.engine.task.AddTask;
import org.opentox.toxotis.database.engine.task.UpdateTask;
import org.opentox.toxotis.database.exception.DbException;


public abstract class RunnableTaskService implements Runnable {

    protected static void updateFailedTask(Task task, Throwable throwable, String explanation, int httpStatus, String actor) {
        task.getMeta().addDescription("Failed task. " + explanation);
        task.setHttpStatus(httpStatus);
        task.setStatus(Status.ERROR);
        String details = exceptionDetails(throwable);
        String code = "";
        StringBuilder additionalMessage = new StringBuilder();        Throwable tempException = throwable;
        
        while (tempException != null) {
            additionalMessage.append(tempException.getMessage() != null ? tempException.getMessage() : "");
            tempException = tempException.getCause();
        }
        if (explanation == null) {
            explanation = "No explanation provided (Please report the issue to the service administrators)";
        }
        ErrorReport er = new ErrorReport(httpStatus, actor, explanation + additionalMessage, details, code);
        task.setErrorReport(er);

        AddErrorReport addError = new AddErrorReport(task.getErrorReport());
        try {
            addError.write();
        } catch (DbException ex) {
            Logger.getLogger(RunnableTaskService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                addError.close();
            } catch (DbException ex) {
                Logger.getLogger(RunnableTaskService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        UpdateTask updater = new UpdateTask(task);
        updater.setUpdateErrorReport(true);
        updater.setUpdateTaskStatus(true);
        updater.setUpdateMeta(true);
        try {
            updater.update();
            updater.close();
        } catch (DbException ex) {
            Logger.getLogger(RunnableTaskService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected static void updateFailedTask(Task task, ErrorReport er) {
        task.getMeta().addDescription("Failed task. " + er.getMessage());
        task.setHttpStatus(er.getHttpStatus());
        task.setStatus(Status.ERROR);
        task.setErrorReport(er);
        AddErrorReport addError = new AddErrorReport(task.getErrorReport());
        try {
            addError.write();
        } catch (DbException ex) {
            Logger.getLogger(RunnableTaskService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                addError.close();
            } catch (DbException ex) {
                Logger.getLogger(RunnableTaskService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        UpdateTask updater = new UpdateTask(task);
        updater.setUpdateErrorReport(true);
        updater.setUpdateTaskStatus(true);
        updater.setUpdateMeta(true);
        try {
            updater.update();
            updater.close();
        } catch (DbException ex) {
            Logger.getLogger(RunnableTaskService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected static String exceptionDetails(Throwable ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);

        Throwable currentThrowable = ex.getCause();
        while (currentThrowable != null) {
            pw.append("\nPrevious Stack Trace...\n");
            currentThrowable.printStackTrace(pw);
            currentThrowable = currentThrowable.getCause();
        }

        return sw.toString();
    }
}