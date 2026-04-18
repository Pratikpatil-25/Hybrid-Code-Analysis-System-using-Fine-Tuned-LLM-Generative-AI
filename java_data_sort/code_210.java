package de.metas.materialtracking.qualityBasedInvoicing.invoicing;




import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.adempiere.util.Check;


public final class QualityInvoiceLineGroupByTypeComparator implements Comparator<IQualityInvoiceLineGroup>
{
	
	private final Map<QualityInvoiceLineGroupType, Integer> type2index = new HashMap<>();

	
	private final static int INDEX_NotFound = 10000000;

	public QualityInvoiceLineGroupByTypeComparator(final QualityInvoiceLineGroupType... inspectionLineTypes)
	{
		this(Arrays.asList(inspectionLineTypes));
	}

	public QualityInvoiceLineGroupByTypeComparator(final List<QualityInvoiceLineGroupType> inspectionLineTypes)
	{
		super();

		Check.assumeNotEmpty(inspectionLineTypes, "inspectionLineTypes not empty");

						for (int index = 0; index < inspectionLineTypes.size(); index++)
		{
			final QualityInvoiceLineGroupType type = inspectionLineTypes.get(index);
			Check.assumeNotNull(type, "type not null");

			final Integer indexOld = type2index.put(type, index);
			if (indexOld != null)
			{
				throw new IllegalArgumentException("Duplicate type " + type + " found in " + inspectionLineTypes);
			}
		}
	}

	@Override
	public int compare(final IQualityInvoiceLineGroup line1, final IQualityInvoiceLineGroup line2)
	{
		final int index1 = getIndex(line1);
		final int index2 = getIndex(line2);

		return index1 - index2;
	}

	private final int getIndex(final IQualityInvoiceLineGroup line)
	{
		Check.assumeNotNull(line, "line not null");
		final QualityInvoiceLineGroupType type = line.getQualityInvoiceLineGroupType();
		final Integer index = type2index.get(type);
		if (index == null)
		{
			return INDEX_NotFound;
		}

		return index;
	}

	private final boolean hasType(final QualityInvoiceLineGroupType type)
	{
		return type2index.containsKey(type);
	}

	
	public void filter(final List<IQualityInvoiceLineGroup> groups)
	{
		for (final Iterator<IQualityInvoiceLineGroup> it = groups.iterator(); it.hasNext();)
		{
			final IQualityInvoiceLineGroup group = it.next();
			final QualityInvoiceLineGroupType type = group.getQualityInvoiceLineGroupType();
			if (!hasType(type))
			{
				it.remove();
			}
		}
	}

	
	public void sort(final List<IQualityInvoiceLineGroup> lines)
	{
		Collections.sort(lines, this);
	}

	
	public void filterAndSort(final List<IQualityInvoiceLineGroup> lines)
	{
		filter(lines);
		sort(lines);
	}
}