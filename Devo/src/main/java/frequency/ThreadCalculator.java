package frequency;

public class ThreadCalculator extends  Thread  implements TermFrequency {

    private String fileName;
    private double frequency;

    public ThreadCalculator(String fileName, double frequency) {

        this.fileName = fileName;
        this.frequency = frequency;

        start();
    }

    @Override
    public void run() {

        ServiceListener.write(fileName,calculate());
    }

    public double calculate(){

        double tf = frequency / ServiceListener.total;
        double idf = Math.log10(ServiceListener.total/ServiceListener.totalFilesWithFrequency);
        return tf/idf;
    }

}
