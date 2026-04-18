package asposefeatures.datahandling.sortdata.java;

import com.aspose.cells.CellArea;
import com.aspose.cells.Cells;
import com.aspose.cells.DataSorter;
import com.aspose.cells.SortOrder;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

public class AsposeDataSort
{
	public static void main(String[] args) throws Exception
	{
		String dataPath = "src/asposefeatures/datahandling/sortdata/data/";
		
				Workbook workbook = new Workbook(dataPath + "AsposeDataInput.xls");
		
				Worksheet worksheet = workbook.getWorksheets().get(0);
		
				Cells cells = worksheet.getCells();

				DataSorter sorter = workbook.getDataSorter();
		
				sorter.setOrder1(SortOrder.ASCENDING);
		
				sorter.setKey1(0);
		
				sorter.setOrder2(SortOrder.ASCENDING);
		
				sorter.setKey2(1);
		
				CellArea ca = new CellArea();
		
				ca.StartRow = 1;
				ca.StartColumn = 0;
				ca.EndRow = 9;
				ca.EndColumn = 2;
		
				sorter.sort(cells, ca);

				workbook.save(dataPath + "AsposeSortedData_Out.xls");
	}
}