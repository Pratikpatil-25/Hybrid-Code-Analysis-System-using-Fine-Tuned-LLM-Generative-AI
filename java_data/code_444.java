package K;



import CSV.Row;

import CSV.RowWithLabel;

import CSV.TableWithLabels;



import java.util.*;




public class KNN implements Algorithm<TableWithLabels, List<Double>, Integer> {



    private TableWithLabels dataAnalysed;



    @Override

    public void train(TableWithLabels data) {

        this.dataAnalysed = data;

    }



    @Override

    public Integer estimate(List<Double> data) {

        if (dataAnalysed == null) throw new IllegalStateException("Modelo no entrenado");



        Integer chosenClass = -1;



        Optional<Row> row = dataAnalysed.getRows().stream()

                .min(Comparator.comparing(v -> euclideanDistance(v.getData(),data)));





        if (row.isPresent()) {

            
            RowWithLabel chosenRow = (RowWithLabel) row.get();

            chosenClass = dataAnalysed.getLabelAsInteger(chosenRow.getLabel());

        }



        return chosenClass;

    }



    private Double euclideanDistance(Collection<Double> obj1, Collection<Double> obj2) {



        
        if (obj1.size() != obj2.size()) throw new IllegalArgumentException("Los dos vectores no tienen el mismo tamaño.");



        Iterator<Double> it1 = obj1.iterator();

        Iterator<Double> it2 = obj2.iterator();

        double sum = 0.0;



        while (it1.hasNext()) {

            double diff = it1.next() - it2.next();

            sum += diff * diff;

        }

        return Math.sqrt(sum);

    }

}