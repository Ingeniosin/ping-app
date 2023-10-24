package cloud.juancamp.aws.utils.task;


import cloud.juancamp.aws.utils.Context;

@FunctionalInterface
public interface Task<T> {

    T execute(Context context);

}
