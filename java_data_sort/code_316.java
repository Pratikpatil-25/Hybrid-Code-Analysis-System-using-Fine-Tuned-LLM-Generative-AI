package com.actelion.research.datawarrior.task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Properties;

import com.actelion.research.chem.MolecularFormula;
import com.actelion.research.chem.StereoMolecule;
import com.actelion.research.datawarrior.DEFrame;


public class DETaskAddFormula extends DETaskAbstractAddChemProperty implements Runnable {
	public static final String TASK_NAME = "Add Molecular Formula";
    private static Properties sRecentConfiguration;

	public DETaskAddFormula(DEFrame parent, boolean isInteractive) {
		super(parent, DESCRIPTOR_NONE, true, true, isInteractive);
		}

	@Override
	public Properties getRecentConfiguration() {
    	return sRecentConfiguration;
    	}

	@Override
	public void setRecentConfiguration(Properties configuration) {
    	sRecentConfiguration = configuration;
    	}

	@Override
	public String getTaskName() {
		return TASK_NAME;
		}

	@Override
    protected int getNewColumnCount() {
		return 1;
		}

	@Override
    protected String getNewColumnName(int column) {
		return "Molecular Formula";
		}

	@Override
	protected String getNewColumnValue(StereoMolecule mol, Object descriptor, int column) {
		if (mol.getAllAtoms() == 0)
			return "";

        int[] fragmentNo = new int[mol.getAllAtoms()];
        int fragments = mol.getFragmentNumbers(fragmentNo, false);
		if (fragments == 1)
			return new MolecularFormula(mol).getFormula();

		StereoMolecule[] fragment = mol.getFragments(fragmentNo, fragments);
		Arrays.sort(fragment, new Comparator<StereoMolecule>() {
			public int compare(StereoMolecule mol1, StereoMolecule mol2) {
				return mol1.getAllAtoms() > mol2.getAllAtoms() ? 0
					 : mol1.getAllAtoms() == mol2.getAllAtoms() ? 1 : 2;
				}
			});

		StringBuilder formula = new StringBuilder(new MolecularFormula(fragment[0]).getFormula());
		for (int i=1; i<fragment.length; i++)
			formula.append("."+new MolecularFormula(fragment[i]).getFormula());
		return formula.toString();
		}
	}