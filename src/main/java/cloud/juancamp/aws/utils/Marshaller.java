package cloud.juancamp.aws.utils;

public interface Marshaller<TIn, TOut> {

    TOut marshall(TIn input);

    Class<TIn> getInputClass();

}
