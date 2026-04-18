package org.wikipediacleaner.gui.swing.worker;



import java.util.Collections;

import java.util.List;



import org.wikipediacleaner.api.APIException;

import org.wikipediacleaner.api.APIFactory;

import org.wikipediacleaner.api.algorithm.AlgorithmError;

import org.wikipediacleaner.api.algorithm.AlgorithmErrorComparator;

import org.wikipediacleaner.api.check.algorithm.CheckErrorAlgorithm;

import org.wikipediacleaner.api.configuration.CWConfigurationError;

import org.wikipediacleaner.api.constants.EnumWikipedia;

import org.wikipediacleaner.gui.swing.basic.BasicWindow;

import org.wikipediacleaner.gui.swing.basic.BasicWorker;

import org.wikipediacleaner.i18n.GT;





public class CheckWikiProjectWorker extends BasicWorker {



  final List<AlgorithmError> errors;

  private final List<CheckErrorAlgorithm> selectedAlgorithms;

  private final int errorLimit;



  

  public CheckWikiProjectWorker(

      EnumWikipedia wikipedia, BasicWindow window,

      List<AlgorithmError> errors,

      List<CheckErrorAlgorithm> selectedAlgorithms,

      boolean otherErrors,

      int errorLimit) {

    super(wikipedia, window);

    this.errors = errors;

    if (!otherErrors) {

      this.errors.clear();

    }

    this.selectedAlgorithms = selectedAlgorithms;

    this.errorLimit = errorLimit;

  }



  

  @Override

  public Object construct() {



    
    boolean errorLoaded = false;

    APIException exception = null;

    if (selectedAlgorithms != null) {

      for (final CheckErrorAlgorithm algorithm : selectedAlgorithms) {

        try {

          

          if ((algorithm != null) &&

              (algorithm.isAvailable()) &&

              (algorithm.getPriority() != CWConfigurationError.PRIORITY_BOT_ONLY)) {

            
            setText(

                GT._T("Checking for errors n°{0}", Integer.toString(algorithm.getErrorNumber())) +

                " - " + algorithm.getShortDescriptionReplaced());

            APIFactory.getCheckWiki().retrievePages(algorithm, errorLimit, getWikipedia(), errors);

            errorLoaded = true;

          }

        } catch (APIException e) {

          exception = e;

        }

      }

    }

    if (!errorLoaded && (exception != null)) {

      return exception;

    }



    
    setText(GT._T("Sorting errors by priority"));

    Collections.sort(errors, new AlgorithmErrorComparator());



    return null;

  }

}