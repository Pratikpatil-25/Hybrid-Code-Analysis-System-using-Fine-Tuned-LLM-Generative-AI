import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.texts.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.EnumSet;
import java.util.List;

public class searchTextAndGetAllBounds {

    public static void main(String args[]) {
                String inputFile = "data/FindTextAndGetAllBounds.pdf";
        String outputFile = "output/CoverAllFindingBounds.pdf";

                PdfDocument pdf = new PdfDocument();

                pdf.loadFromFile(inputFile);

                List<PdfTextFragment> results = null;

                PdfTextFindOptions findOptions = new PdfTextFindOptions();

                findOptions.setTextFindParameter(EnumSet.of(TextFindParameter.IgnoreCase));

        PdfTextFinder textFinder = null;

        for (Object pageObj : pdf.getPages()) {
                        PdfPageBase page = (PdfPageBase) pageObj;

                        PdfGraphicsState state = page.getCanvas().save();

                        PdfPen pen = new PdfPen(new PdfRGBColor(Color.BLACK), 1f);
            PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.RED));

                        textFinder = new PdfTextFinder(page);

                        results = textFinder.find("Customized Demo", findOptions);

                        for (PdfTextFragment find : results) {
                                Rectangle2D[] bounds = find.getBounds();

                                for (Rectangle2D rect : bounds) {
                    page.getCanvas().drawRectangle(pen, brush, rect);
                }
            }

                        page.getCanvas().restore(state);
        }

                pdf.saveToFile(outputFile, FileFormat.PDF);

                pdf.close();

                pdf.dispose();
    }
}